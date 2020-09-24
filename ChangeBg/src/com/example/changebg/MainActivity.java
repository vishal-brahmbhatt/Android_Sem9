package com.example.changebg;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {
	
	Button btn ;
	int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn1);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.parent1);
		parentLayout.setBackgroundColor(Color.CYAN);

		if(i == 1)
		{
			parentLayout.setBackgroundColor(Color.TRANSPARENT);
			i = 0;
			btn.setText("Click to Change Background");
		}
		else
		{
			parentLayout.setBackgroundColor(Color.CYAN);
			i = 1;
			btn.setText("Click to remove background color");
		}
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
