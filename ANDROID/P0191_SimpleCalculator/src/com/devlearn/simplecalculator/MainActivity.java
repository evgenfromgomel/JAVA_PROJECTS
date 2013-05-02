package com.devlearn.simplecalculator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	List<Button> btnArray;
	TextView tvDisplay;
	StringBuilder currDisplayValue = new StringBuilder("");
	float currValue = 0;

	boolean actPressed = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnArray = new ArrayList<Button>();
		btnArray.add((Button) findViewById(R.id.btnNum0));
		btnArray.add((Button) findViewById(R.id.btnNum1));
		btnArray.add((Button) findViewById(R.id.btnNum2));
		btnArray.add((Button) findViewById(R.id.btnNum3));
		btnArray.add((Button) findViewById(R.id.btnNum4));
		btnArray.add((Button) findViewById(R.id.btnNum5));
		btnArray.add((Button) findViewById(R.id.btnNum6));
		btnArray.add((Button) findViewById(R.id.btnNum7));
		btnArray.add((Button) findViewById(R.id.btnNum8));
		btnArray.add((Button) findViewById(R.id.btnNum9));
		btnArray.add((Button) findViewById(R.id.btnAdd));
		btnArray.add((Button) findViewById(R.id.btnSub));
		btnArray.add((Button) findViewById(R.id.btnDiv));
		btnArray.add((Button) findViewById(R.id.btnClear));
		btnArray.add((Button) findViewById(R.id.btnMul));
		btnArray.add((Button) findViewById(R.id.btnDot));
		btnArray.add((Button) findViewById(R.id.btnEqu));
		tvDisplay = (TextView) findViewById(R.id.tvDisplay);

		for (Button btn : btnArray) {
			btn.setOnClickListener(this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (!actPressed) {
			switch (v.getId()) {
			case R.id.btnAdd:
				actPressed = true;
				
				break;
			case R.id.btnSub:

				break;
			case R.id.btnMul:

				break;

			case R.id.btnDiv:

				break;

			case R.id.btnEqu:

				break;

			default:
				updateDisplay(v);
				break;
			}
		}
		else {
			tvDisplay.setText("");
			
		}

	}

	private void updateDisplay(View v) {
		String pressedNum = ((Button) v).getText().toString();
		currDisplayValue.append(pressedNum);
		tvDisplay.setText(currDisplayValue);
	}

}
