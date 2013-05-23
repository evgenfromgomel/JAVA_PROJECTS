package com.epam.ehalavachou.jutask2.bean;

import com.epam.ehalavachou.jutask2.interfaces.IEarthBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IElementsBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IFireBehavior;

public class Earth extends ElementObject implements IEarthBehavior {

	public Earth() {
	}
	
	public void creation() {
	}

	public void distruction() {
	}

	@Override
	void interaction(IElementsBehavior obj) {
		if (obj instanceof IFireBehavior) {
			if(Quantities.getQuantity(this) > (Quantities.getQuantity((IFireBehavior)obj) * 0.5) + 1){
				((IFireBehavior)obj).ingulf();
				
			}
		}
	}

}
