package com.example.login_page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button log_btn;
	EditText uname,password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		log_btn = (Button) findViewById(R.id.button1);
		uname = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		
		log_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				String c = uname.getText().toString();
				String cc = password.getText().toString();
				Log.d("uname", c);
				Log.d("uname", cc);
				if(TextUtils.isEmpty(uname.getText()))
				{
					Toast.makeText(getApplicationContext(), "UserName is mandatory", Toast.LENGTH_SHORT).show();
				}
				else if(TextUtils.isEmpty(password.getText()))
				{
					Toast.makeText(getApplicationContext(), "Password is mandatory", Toast.LENGTH_SHORT).show();
				}
				if(c.equals("admin") && cc.equals("abcd"))
					{
						Log.d("vishal", "vishal");
						Intent intent = new Intent(MainActivity.this,HomeScreen.class);
						intent.putExtra("uname1", uname.getText().toString());
						startActivity(intent);
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
