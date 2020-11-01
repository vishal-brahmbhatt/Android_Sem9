package com.example.notes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	Button readbtn,savebtn;
	EditText title,data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		readbtn = (Button)findViewById(R.id.load_btn);
		savebtn = (Button)findViewById(R.id.save_btn);
		title = (EditText)findViewById(R.id.notes_title);
		data = (EditText)findViewById(R.id.notes_data);
		
		readbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(title.getText().toString().matches(""))
				{
					Toast.makeText(getApplicationContext(), "Please enter title to open file",Toast.LENGTH_SHORT).show();
				}
				else
				{
					StringBuffer sb = new StringBuffer();
					try {  
	                    //Attaching BufferedReader to the FileInputStream by the help of InputStreamReader  
	                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(  
	                            openFileInput(title.getText().toString())));  
	                    String inputString;  	                    
	                    while ((inputString = inputReader.readLine()) != null) {  
	                        sb.append(inputString + "\n");  
	                    }  
	  
	                } 
					catch (FileNotFoundException e)
					{
						Toast.makeText(getApplicationContext(), "No Note exist having " + title.getText().toString(),Toast.LENGTH_SHORT).show();
					} 
					catch (IOException e) 
					{  
	                    e.printStackTrace();  
	                }  
					
					data.setText(sb.toString());
				}
			}
		});
		
		
		savebtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(title.getText().toString().matches(""))
				{
					Toast.makeText(getApplicationContext(), "Please add title to note",Toast.LENGTH_SHORT).show();
				}
				else if(data.getText().toString().matches(""))
				{
					Toast.makeText(getApplicationContext(), "Please add body to note",Toast.LENGTH_SHORT).show();
				} 
				else
				{
					FileOutputStream fos;
					try {  
	                    fos = openFileOutput(title.getText().toString(), Context.MODE_PRIVATE);  
	                    //default mode is PRIVATE, can be APPEND etc.  
	                    fos.write(data.getText().toString().getBytes());  
	                    fos.close();  
	  
	                    Toast.makeText(getApplicationContext(),title.getText().toString() + " saved",  
	                            Toast.LENGTH_LONG).show();  
	  
	                    title.setText("");
	                    data.setText("");
	  
	                }   
	                catch (IOException e) 
					{
	                	e.printStackTrace();
	                }  
				}
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
