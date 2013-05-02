package com.devlearn.listeners.button;

import com.devlearn.custombutton.R;

import android.app.Activity;
import android.support.v4.app.NotificationCompat.Action;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class NumButtonListener implements OnClickListener {
	
	
	@Override
	public void onClick(View v) {
		View parView = (View) v.getParent();
		TextView tv = (TextView) parView.findViewById(R.id.tvDisp);
		tv.setText("Number button pressesed");
	}

}
