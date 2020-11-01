package com.example.feedbackform;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	String [] FeedBackList = {"Very Bad","Bad","Aveage","Good","Very Good","Excellent"};
	Button submit_btn;
	AutoCompleteTextView atv;
	String feedbackText;
	ArrayAdapter <String> adapt;
	RatingBar ratebar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ratebar =(RatingBar) findViewById(R.id.ratingBar);
		
		ArrayAdapter <String> adapt = new ArrayAdapter <String>(this,android.R.layout.select_dialog_item,FeedBackList);
		AutoCompleteTextView atv = (AutoCompleteTextView)findViewById(R.id.feedback_autocomplete);
		atv.setThreshold(2);
		atv.setAdapter(adapt);
		
		atv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				feedbackText =  parent.getItemAtPosition(position).toString();
			}
		});
		
		
		submit_btn = (Button)findViewById(R.id.submit_btn);
		
		submit_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str = "FeedBack : " + feedbackText + "\n Rating : " + String.valueOf(ratebar.getRating());
				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
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
