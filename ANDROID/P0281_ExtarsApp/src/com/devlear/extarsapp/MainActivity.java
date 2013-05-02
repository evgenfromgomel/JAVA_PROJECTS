package com.devlear.extarsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	 EditText etFName;
	 EditText etLName;
	 Button btnSubmit;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		 etFName = (EditText) findViewById(R.id.etFName);
	     etLName = (EditText) findViewById(R.id.etLName);
	        
	     btnSubmit = (Button) findViewById(R.id.btnSubmit);
	     btnSubmit.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, ViewActivity.class); 
	    intent.putExtra("fname", etFName.getText().toString());
	    intent.putExtra("lname", etLName.getText().toString());
	    startActivity(intent);
		
	}

}
