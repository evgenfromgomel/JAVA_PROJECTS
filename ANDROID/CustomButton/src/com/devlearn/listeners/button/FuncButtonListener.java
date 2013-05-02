package com.devlearn.listeners.button;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.devlearn.custombutton.R;

public class FuncButtonListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		View parView = (View) v.getParent();
		TextView tv = (TextView) parView.findViewById(R.id.tvDisp);
		tv.setText("Function button pressesed");
	}

}
