package com.devlearn.dynamiclayout2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	LinearLayout llMain;
	RadioGroup rgGravity;
	EditText etName;
	Button btnCreate;
	Button btnClear;
	
	int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		llMain = (LinearLayout) findViewById(R.id.llMain);
		rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
		etName = (EditText) findViewById(R.id.etName);
		btnCreate = (Button) findViewById(R.id.btnCreate);
		btnClear = (Button) findViewById(R.id.btnClear);
		
		btnCreate.setOnClickListener(this);
		btnClear.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.btnCreate:
				LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
				int btnGravity = Gravity.LEFT;
				
				switch(rgGravity.getCheckedRadioButtonId()){
					case R.id.rdLeft:
						btnGravity = Gravity.LEFT;
						break;
					case R.id.rdCenter:
						btnGravity = Gravity.CENTER;
						break;
					case R.id.rdRight:
						btnGravity = Gravity.RIGHT;
					break;
				}
				lParams.gravity = btnGravity;
				
				Button btnNew = new Button(this);
				btnNew.setText(etName.getText().toString());
				llMain.addView(btnNew, lParams);
			break;
			case R.id.btnClear:
				llMain.removeAllViews();
				Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
			break;
			
		}
	}

}
