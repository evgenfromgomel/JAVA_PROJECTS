package com.devlearn.onclickbuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  {
	
	TextView tvOut;
	Button btnOk;
	Button btnCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public void onClickStart(View v) {
		
		switch(v.getId()){
		case R.id.btnOk:
			tvOut.setText("Нажата кнопка ОК");
			break;
		case R.id.btnCancel:
			tvOut.setText("Нажата кнопка Cancel");
			break;
		}
		
	}
	

}
