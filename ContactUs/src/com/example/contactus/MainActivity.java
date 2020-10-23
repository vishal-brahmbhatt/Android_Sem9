package com.example.contactus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	TextView contnumber;
	TextView contmail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		contnumber = (TextView) findViewById(R.id.contnumber);
		contmail= (TextView) findViewById(R.id.mailadd);
		
		contnumber.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri num = Uri.parse("tel:" + contnumber.getText().toString());
				Intent dial = new Intent(Intent.ACTION_DIAL,num);
				startActivity(dial);
			}
		});
		
		contmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
			      
			      emailIntent.setData(Uri.parse("mailto:"));
			      emailIntent.setType("text/plain");
			      emailIntent.putExtra(Intent.EXTRA_EMAIL, contmail.getText().toString());			      
			      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
			      startActivity(Intent.createChooser(emailIntent, "Send mail..."));
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
}
