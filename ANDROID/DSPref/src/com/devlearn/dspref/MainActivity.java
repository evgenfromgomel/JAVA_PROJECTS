package com.devlearn.dspref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener{
 
	final String SAVED_TEXT = "saved_text";
	
	Button btnSave, btnLoad;
	EditText etIOField;
	
	SharedPreferences sPref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		etIOField = (EditText) findViewById(R.id.etIOField);
		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(this);
		btnLoad = (Button) findViewById(R.id.btnLoad);
		btnLoad.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSave:
			saveText();
			break;
		case R.id.btnLoad:
			loadText();
			break;
		}
		
	}
	
	public void saveText(){
		sPref = getPreferences(MODE_PRIVATE);
		Editor ed = sPref.edit();
		ed.putString(SAVED_TEXT, etIOField.getText().toString());
		ed.commit();
		Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
	}
	
	public void loadText(){
		sPref = getPreferences(MODE_PRIVATE);
		String savedText = sPref.getString(SAVED_TEXT, "");
		etIOField.setText(savedText);
		Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
	}

}
