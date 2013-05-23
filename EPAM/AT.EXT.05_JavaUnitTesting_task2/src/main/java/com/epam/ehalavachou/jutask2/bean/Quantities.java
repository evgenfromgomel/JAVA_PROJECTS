package com.epam.ehalavachou.jutask2.bean;

import com.epam.ehalavachou.jutask2.interfaces.IAirBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IEarthBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IElementsBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IFireBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IWaterBehavior;

public class Quantities {

	static int fireQuantity;
	static int earthQuantity;
	static int waterQuantity;
	static int airQuantity;
	
	public static int getQuantity(IElementsBehavior obj){
		if (obj instanceof IFireBehavior){
			return fireQuantity;
		}
		if (obj instanceof IEarthBehavior) {
			return earthQuantity;
		}
		if (obj instanceof IWaterBehavior) {
			return waterQuantity;
		}
		if (obj instanceof IAirBehavior) {
			return airQuantity;
		}
		else return 0;
	}
	
	public static void setQuantity(IElementsBehavior obj, int quantity){
		if (obj instanceof IFireBehavior){
			fireQuantity = quantity;
		}
		if (obj instanceof IEarthBehavior) {
			earthQuantity = quantity;
		}
		if (obj instanceof IWaterBehavior) {
			waterQuantity = quantity;
		}
		if (obj instanceof IAirBehavior) {
			airQuantity = quantity;
		}
	}

	
	
}
