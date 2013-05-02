package com.devlearn.layoutinflater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LayoutInflater ltInlfater = getLayoutInflater();
		LinearLayout linLauoyt = (LinearLayout) findViewById(R.id.linLayout);
		View view1 = ltInlfater.inflate(R.layout.text, linLauoyt, true);
		LayoutParams lp1 = view1.getLayoutParams();
		
		
		Log.d(LOG_TAG, "Class of view: " + view1.getClass().toString());
		Log.d(LOG_TAG, "Class of layoutParams of view1:" + lp1.getClass().toString());
		Log.d(LOG_TAG, "Text of view:" + ((TextView) view1).getText());
		
		RelativeLayout rlLauoyt = (RelativeLayout) findViewById(R.id.relLayout);
		View view2 = ltInlfater.inflate(R.layout.text, rlLauoyt, true);
		LayoutParams lp2 = view2.getLayoutParams();
		
		
		Log.d(LOG_TAG, "Class of view: " + view2.getClass().toString());
		Log.d(LOG_TAG, "Class of layoutParams of view2:" + lp2.getClass().toString());
		Log.d(LOG_TAG, "Text of view:" + ((TextView) view2).getText());
	}

	

}
