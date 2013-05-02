package com.devlearn.getintentaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btnTime = (Button) findViewById(R.id.btnTime);
		Button btnDate = (Button) findViewById(R.id.btnDate);

		btnTime.setOnClickListener(this);
		btnDate.setOnClickListener(this);

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
		case R.id.btnTime:
			intent = new Intent("ru.startandroid.intent.action.showtime");
			startActivity(intent);
			break;
		case R.id.btnDate:
			intent = new Intent("ru.startandroid.intent.action.showdate");
			startActivity(intent);
			break;
		}

	}

}
