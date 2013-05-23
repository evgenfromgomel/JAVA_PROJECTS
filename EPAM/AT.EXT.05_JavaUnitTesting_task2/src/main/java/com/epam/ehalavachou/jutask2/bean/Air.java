package com.epam.ehalavachou.jutask2.bean;

import com.epam.ehalavachou.jutask2.interfaces.IAirBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IElementsBehavior;

public class Air extends ElementObject implements IAirBehavior {

	public Air() {
	}
	
	public void creation() {
	}

	public void distruction() {
	}

	@Override
	void interaction(IElementsBehavior obj) {
	}
	
	public void burn() {
		int q = Quantities.getQuantity(this);
		q -= 1;
		Quantities.setQuantity(this, q);
	}

	

}
