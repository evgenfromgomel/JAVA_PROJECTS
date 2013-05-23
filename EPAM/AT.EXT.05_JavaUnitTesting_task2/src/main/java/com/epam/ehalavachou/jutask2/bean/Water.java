package com.epam.ehalavachou.jutask2.bean;

import com.epam.ehalavachou.jutask2.interfaces.IElementsBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IFireBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IWaterBehavior;

public class Water extends ElementObject implements IWaterBehavior {

	public Water() {
	}
	
	public void creation() {
	}

	public void distruction() {
	}

	@Override
	void interaction(IElementsBehavior obj) {
		if (obj instanceof IFireBehavior) {
			
			if(Quantities.getQuantity(this) > Quantities.getQuantity((IFireBehavior)obj)){
				((IFireBehavior)obj).quench();
			}
		}
	}

	public void evaporate() {
		sizzleQuetly();
	}
	
	public void sizzleQuetly() {
		System.out.println("A lot of fire! Sizzle quetly!");
	}

}
