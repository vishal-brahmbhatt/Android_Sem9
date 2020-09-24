package com.example.activity_lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("lifecycle","on created called");
		Toast.makeText(getApplicationContext(), "on created called", Toast.LENGTH_SHORT).show();
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
	
	protected void onStart() {  
        super.onStart();  
        Log.d("lifecycle","onStart called");  
        Toast.makeText(getApplicationContext(), "onStart called", Toast.LENGTH_SHORT).show();
    }  
    @Override  
    protected void onResume() {  
        super.onResume();  
        Log.d("lifecycle","onResume called");  
        Toast.makeText(getApplicationContext(), "onResume called", Toast.LENGTH_SHORT).show();
    }  
    @Override  
    protected void onPause() {  
        super.onPause();  
        Log.d("lifecycle","onPause called");  
        Toast.makeText(getApplicationContext(), "onPause called", Toast.LENGTH_SHORT).show();
    }  
    @Override  
    protected void onStop() {  
        super.onStop();  
        Log.d("lifecycle","onStop called");  
        Toast.makeText(getApplicationContext(), "onStop  called", Toast.LENGTH_SHORT).show();
    }  
    @Override  
    protected void onRestart() {  
        super.onRestart();  
        Log.d("lifecycle","onRestart called");  
        Toast.makeText(getApplicationContext(), "onRestart called", Toast.LENGTH_SHORT).show();
    }  
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        Log.d("lifecycle","onDestroy called");  
        Toast.makeText(getApplicationContext(), "onDestroy called called", Toast.LENGTH_SHORT).show();
    }  
}
