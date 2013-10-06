package com.example.l2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
		MenuInflater aa = getMenuInflater();
		//aa.inflate(R.menu.activity_main, menu);
		menu.add(0, R.id.menu_about, 0, R.string.about).setIcon(R.drawable.ic_launcher);
		menu.add(0, R.id.menu_net, 0, R.string.net).setIcon(R.drawable.ic_launcher);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
		    case R.id.menu_settings:
		    	onAbout();
		        return true;
		    case R.id.menu_about:
		    	onAbout();
		        return true;
		    case R.id.menu_net:
		    	onNet();
		        return true;
		    default:
		        return super.onOptionsItemSelected(item);
	    }
	}
	
	public void onCal(View view) {
		String[] q = getResources().getStringArray(R.array.qarray);
		Intent intent = new Intent();
		Bundle bundle = new Bundle();
		intent.setClass(MainActivity.this, Path.class);
		bundle.putInt("num", 0);
		bundle.putInt("score", 0);
		bundle.putInt("len", q.length);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	public void onAbout() {
		DialogInterface.OnClickListener OK = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		};
		DialogInterface.OnClickListener homepage = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Uri uri= Uri.parse("https://www.google.com.tw");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		};
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("關於L2").setMessage("第3堂\nfor作業\n\n資料來源:\nhttp://amberbeautiful.blogspot.tw/2012/07/blog-post_6896.html").setPositiveButton("OK",OK);
		builder.setNegativeButton("首頁", homepage).show();
	}
	public void onNet() {
		Uri uri= Uri.parse("https://www.google.com.tw");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

}
