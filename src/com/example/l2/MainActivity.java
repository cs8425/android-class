package com.example.l2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.menu_settings:
	    	onAbout();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	public void onCal(View view) {
		double kg = 0;
		CharSequence in = ((TextView)findViewById(R.id.input)).getText();
		if(in.length() != 0) {
			try{
				kg = Double.parseDouble(in.toString());
				double pound = kg * 2.20462262;
				((TextView)findViewById(R.id.output)).setText(String.valueOf(pound));
				//view.findViewById(R.id.editText2)
				//onAbout();
			}
			catch(Error e){
				
			}
		}else{
			Toast.makeText(MainActivity.this, "輸入錯誤!!", Toast.LENGTH_SHORT).show();
		}

	}
	
	public void onAbout() {
		DialogInterface.OnClickListener OK = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		};
		new AlertDialog.Builder(MainActivity.this).setTitle("關於L2").setMessage("第2堂\n測試用\n").setPositiveButton("OK",OK).show();
	}
}
