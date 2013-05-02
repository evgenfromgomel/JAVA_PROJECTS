package com.devlearn.listlistener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	 final String LOG_TAG = "myLogs";

	 ListView lvNames;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		lvNames = (ListView) findViewById(R.id.lvNames);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.names, android.R.layout.simple_list_item_1);
		lvNames.setAdapter(adapter);
		
		lvNames.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Log.d(LOG_TAG, "itemClick: positin ")
				
			}
			
		});
	}


}
