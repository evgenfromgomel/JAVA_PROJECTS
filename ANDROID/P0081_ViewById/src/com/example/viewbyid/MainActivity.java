package com.example.viewbyid;

import com.example.viewbyid.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		TextView myTextView = (TextView) findViewById(R.id.myText);
		myTextView.setText("This is new text!");
		
		Button myBtn = (Button) findViewById(R.id.myBtn);
		myBtn.setText("Press here");
		myBtn.setEnabled(false);
		
		CheckBox myChk = (CheckBox) findViewById(R.id.myChk);
		myChk.setChecked(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
