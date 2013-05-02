package com.devlearn.menuadv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView tv;
	CheckBox chb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tv = (TextView) findViewById(R.id.textView);
		chb = (CheckBox) findViewById(R.id.chbExtMenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymenu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		menu.setGroupVisible(1, chb.isChecked());
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("Item menu");
		sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
		sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
		sb.append("\r\n order: " + String.valueOf(item.getOrder()));
		sb.append("\r\n title: " + String.valueOf(item.getTitle()));
		tv.setText(sb.toString());
		
		return super.onOptionsItemSelected(item);
	}

}
