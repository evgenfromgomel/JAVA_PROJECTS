package com.devlear.extarsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends Activity {
	
	TextView tvView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view);
		
		tvView = (TextView) findViewById(R.id.tvView);
		
		Intent intent = getIntent();
		
		String fname = intent.getStringExtra("fname");
		String lname = intent.getStringExtra("lname");
		
		tvView.setText("Your name is:" + fname + " " + lname);
	}

}
