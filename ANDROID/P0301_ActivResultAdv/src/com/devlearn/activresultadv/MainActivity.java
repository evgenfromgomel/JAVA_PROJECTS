package com.devlearn.activresultadv;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	final int REQUEST_CODE_COLOR = 1;
	final int REQUEST_CODE_ALIGN = 2;
	
	Button btnColor;
	Button btnAlign;
	TextView tvText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnColor = (Button) findViewById(R.id.btnColor);
		btnAlign = (Button) findViewById(R.id.btnAlign);
		tvText = (TextView) findViewById(R.id.tvText);
		
		btnColor.setOnClickListener(this);
		btnAlign.setOnClickListener(this);
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public void onClick(View v) {
		
		Intent intent;
		switch (v.getId()) {
		case R.id.btnColor:
			intent = new Intent(this, ColorActivity.class);
			startActivityForResult(intent, REQUEST_CODE_COLOR);
			break;
		case R.id.btnAlign:
			intent = new Intent(this, AlingActivity.class);
			startActivityForResult(intent, REQUEST_CODE_ALIGN);
			break;	
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Log.d("myLog", "reqCode = " + requestCode + "; resCode = " + resultCode + ";");
		if(resultCode == RESULT_OK){
			switch (requestCode) {
			case REQUEST_CODE_COLOR:
				int color = data.getIntExtra("color", Color.WHITE);
				tvText.setTextColor(color);
				break;
			case REQUEST_CODE_ALIGN:
				int align = data.getIntExtra("align", Gravity.LEFT);
				tvText.setGravity(align);
				break;
			}
		} else{
			Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
		}
	}

}
