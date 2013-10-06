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

public class Report extends Activity {
	int score = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		
		String[] rep = getResources().getStringArray(R.array.ansdata);
		Bundle bundle = this.getIntent().getExtras();
		score = bundle.getInt("score");
		if(score < 16){
			((TextView)findViewById(R.id.reptext)).setText(rep[0]);
		}else{
			if(score < 26){
				((TextView)findViewById(R.id.reptext)).setText(rep[1]);
			}else{
				((TextView)findViewById(R.id.reptext)).setText(rep[2]);
			}
		}
		((TextView)findViewById(R.id.score)).setText("得分：" + String.valueOf(score));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater aa = getMenuInflater();
		//aa.inflate(R.menu.activity_main, menu);
		menu.add(0, R.id.menu_about, 0, R.string.about).setIcon(R.drawable.ic_launcher);

		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
		    case R.id.menu_about:
		    	onAbout();
		        return true;
		    default:
		        return super.onOptionsItemSelected(item);
	    }
	}
	public void onBack(View view) {
		Report.this.finish();
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
		AlertDialog.Builder builder = new AlertDialog.Builder(Report.this);
		builder.setTitle("關於L2").setMessage("第3堂\nfor作業\n\n資料來源:\nhttp://amberbeautiful.blogspot.tw/2012/07/blog-post_6896.html").setPositiveButton("OK",OK);
		builder.setNegativeButton("首頁", homepage).show();
	}
}
