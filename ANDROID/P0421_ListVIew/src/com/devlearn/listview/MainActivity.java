package com.devlearn.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		 String[] names = { "����", "�����", "����", "�����", "����", "�����",
			      "�����", "�����", "����", "�����", "������" };
		
		ListView lvMain = (ListView) findViewById(R.id.lvMain);
		
		ArrayAdapter<String> arrAdap = new ArrayAdapter<String>(this, R.layout.list_item, names);
		
		lvMain.setAdapter(arrAdap);
	}

	

}
