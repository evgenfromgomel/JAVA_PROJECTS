package com.devlearn.electlistview;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {
	
	 final String LOG_TAG = "myLogs";
	 String names[];
	 ListView lvNames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		lvNames = (ListView) findViewById(R.id.lvNames);
		
		lvNames.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.names, android.R.layout.simple_list_item_multiple_choice);
		
		lvNames.setAdapter(adapter);
		
		Button btnChk = (Button) findViewById(R.id.btnChk);
		btnChk.setOnClickListener(this);
		
		names = getResources().getStringArray(R.array.names);
	}

	@Override
	public void onClick(View v) {
		Log.d(LOG_TAG, "checked name: ");
		SparseBooleanArray arr = lvNames.getCheckedItemPositions();
		for (int i = 0; i < arr.size(); i++){
			int key = arr.keyAt(i);
			if(arr.get(key)){
				Log.d(LOG_TAG, names[key]);
			}
		}
		
	}

	
}
