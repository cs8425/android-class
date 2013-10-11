package com.example.l2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	static String[] item = new String[]{"磅","盎司"};
	int select = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spinner = (Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, item);

		adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adp);
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, String.valueOf(arg2)+","+String.valueOf(arg3) , Toast.LENGTH_SHORT).show();
				select = arg2;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "請選一項!!", Toast.LENGTH_SHORT).show();
			}
		});
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
				double out;
				if(select == 0){
					out = kg * 2.20462262;
				}else{
					out = kg * 35.2739619;
				}
				((TextView)findViewById(R.id.output)).setText(String.valueOf(out));
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
		new AlertDialog.Builder(MainActivity.this).setTitle("關於L4").setMessage("第4堂\n測試用\n").setPositiveButton("OK",OK).show();
	}
}
