package com.devlearn.dymamiclayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout linLayout = new LinearLayout(this);
		linLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams linLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(linLayout, linLayoutParams);
		
		LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		TextView tv = new TextView(this);
		tv.setText("TextView");
		tv.setLayoutParams(lpView);
		linLayout.addView(tv);
		
		Button btn = new Button(this);
		btn.setText("Button");
		linLayout.addView(btn, lpView);
		
		LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		leftMarginParams.leftMargin = 50;
		Button btn1 = new Button(this);
		btn1.setText("Button1");
		linLayout.addView(btn1, leftMarginParams);
		
		LinearLayout.LayoutParams rigthGravityLayout = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rigthGravityLayout.gravity = Gravity.RIGHT;
		Button btn2 = new Button(this);
		btn2.setText("Button2");
		linLayout.addView(btn2, rigthGravityLayout);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
}
