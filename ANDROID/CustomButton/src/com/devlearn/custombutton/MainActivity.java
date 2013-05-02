package com.devlearn.custombutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.devlearn.listeners.button.FuncButtonListener;
import com.devlearn.listeners.button.NumButtonListener;

public class MainActivity extends Activity {

	Button btnAdd;
	Button btnSub;
	Button btnRes;
	Button btnNum0;
	Button btnNum1;
	
	OnClickListener numListener;
	OnClickListener funcListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnNum0  = (Button) findViewById(R.id.btnNum0);
		btnNum1  = (Button) findViewById(R.id.btnNum1);
		btnAdd  = (Button) findViewById(R.id.btnAdd);
		btnSub  = (Button) findViewById(R.id.btnSub);
		btnRes  = (Button) findViewById(R.id.btnRes);
		numListener = new NumButtonListener();
		funcListener = new FuncButtonListener();
		
		btnNum0.setOnClickListener(numListener);
		btnNum1.setOnClickListener(numListener);
		btnAdd.setOnClickListener(funcListener);
		btnSub.setOnClickListener(funcListener);
		btnRes.setOnClickListener(funcListener);
	}

	

}
