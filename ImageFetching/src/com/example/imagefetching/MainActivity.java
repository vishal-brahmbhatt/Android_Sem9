package com.example.imagefetching;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView imgvw;
	Button btn;
	Bitmap bitmap = null;
	String img_url = "http://192.168.0.54:8080/selogo.png"; // url of your image your ip : xammp or wamp port / path to your image AND don't forget to give internet permission
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgvw = (ImageView) findViewById(R.id.image);
		btn = (Button) findViewById(R.id.btn_loadimg);
		Toast.makeText(getApplicationContext(), "line no 35 works", Toast.LENGTH_LONG).show();
		
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Create an object for subclass of AsyncTask
		        GetXMLTask task = new GetXMLTask();
		        // Execute the task
		        task.execute(new String[] { img_url });
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	
	//////////////////////////// Creating New Class to fetch Image //////////////////////
	private class GetXMLTask extends AsyncTask<String, Void, Bitmap> 
	{
	    @Override
	    protected Bitmap doInBackground(String... urls) 
	    //... means that zero or more String objects
	    {
	        Bitmap map = null;
	        for (String url : urls) {
	            map = downloadImage(url);
	        }
	        return map;
	    }

	    // Sets the Bitmap returned by doInBackground
	    @Override
	    protected void onPostExecute(Bitmap result)
	    {
	    	imgvw.setImageBitmap(result);
	    }

	    // Creates Bitmap from InputStream and returns it
	    private Bitmap downloadImage(String url) 
	    {
	        Bitmap bitmap = null;
	        InputStream stream = null;
	        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	        bmOptions.inSampleSize = 1;

	        try {
	            stream = getHttpConnection(url);
	            bitmap = BitmapFactory.
	                    decodeStream(stream, null, bmOptions);
	            stream.close();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        return bitmap;
	    }

	    // Makes HttpURLConnection and returns InputStream
	    private InputStream getHttpConnection(String urlString)
	            throws IOException {
	        InputStream stream = null;
	        URL url = new URL(urlString);
	        URLConnection connection = url.openConnection();

	        try {
	            HttpURLConnection httpConnection = (HttpURLConnection) connection;
	            httpConnection.setRequestMethod("GET");
	            httpConnection.connect();

	            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	                stream = httpConnection.getInputStream();
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        
	        return stream;
	    }
	}

}


//////////////////////////////////////



