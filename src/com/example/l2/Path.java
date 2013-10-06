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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Path extends Activity {
	int score = 0;
	int num = 0;
	int len;
	boolean hasChecked = false;
	//String[] q = getResources().getStringArray(R.array.qarray);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.path);
		
		String[] q = getResources().getStringArray(R.array.qarray);
		String[] sq = getResources().getStringArray(R.array.sqarray);
		Bundle bundle = this.getIntent().getExtras();
		num = bundle.getInt("num");
		score = bundle.getInt("score");
		len = bundle.getInt("len");
		((TextView)findViewById(R.id.score)).setText(String.valueOf(num+1) + "." + q[num]);
		((RadioButton)findViewById(R.id.A)).setText(sq[num*3]);
		((RadioButton)findViewById(R.id.B)).setText(sq[num*3+1]);
		((RadioButton)findViewById(R.id.C)).setText(sq[num*3+2]);
	}
	public void onBack(View view) {
		/*Intent intent = new Intent();
		intent.setClass(Report.this, Report.class);
		Bundle bundle = new Bundle();
		bundle.putDouble("out", 1234.4);
		intent.putExtras(bundle);
		startActivity(intent);*/
		Path.this.finish();
	}
	public void onNext(View view) {
		RadioGroup radioGroupId = (RadioGroup) findViewById(R.id.radioGenderGroup);
		int selectedOption = radioGroupId.getCheckedRadioButtonId();
		//Toast.makeText(Path.this, String.valueOf(selectedOption), Toast.LENGTH_SHORT).show();
		if(selectedOption != -1){
		    switch(selectedOption) {
		        case R.id.A:
		        	score += 1;
		            break;
		        case R.id.B:
		        	score += 2;
		            break;
		        case R.id.C:
		        	score += 3;
		            break;
		    }
			
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			if(num == (len - 1)){
				intent.setClass(Path.this, Report.class);
				bundle.putInt("score", score);
			}else{
				intent.setClass(Path.this, Path.class);
				bundle.putInt("num", num + 1);
				bundle.putInt("score", score);
				bundle.putInt("len", len);
			}
			intent.putExtras(bundle);
			startActivity(intent);
		}else{
			Toast.makeText(Path.this, "請選一項!!", Toast.LENGTH_SHORT).show();
		}

	}
}
