package com.epam.ehalavachou.jutask2.bean;

import com.epam.ehalavachou.jutask2.interfaces.IAirBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IElementsBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IFireBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IWaterBehavior;

public class Fire extends ElementObject implements IFireBehavior {
	
	final int MIN_AIR_QUANTITY = 1;
	
	public Fire() {
	}
	
	public void creation() {
	}

	public void distruction() {
		Quantities.setQuantity(this, 0);
	}

	@Override
	void interaction(IElementsBehavior obj) {
		if (obj instanceof IAirBehavior) {
			;
			if(Quantities.getQuantity((IAirBehavior)obj) < MIN_AIR_QUANTITY){
				this.distruction();
			}
			else{
				((IAirBehavior)obj).burn();
			}
		}
		if (obj instanceof IWaterBehavior) {
				if(Quantities.getQuantity(this) > Quantities.getQuantity((IWaterBehavior)obj)){
				((IWaterBehavior)obj).evaporate();
			}
		}
	}
		
	public void quench() {
		sizzleLoudly();
	}
	
	public void ingulf(){	
	}
	
	public void sizzleLoudly() {
		System.out.println("A lot of water! Fire sizzle loudly!");
	}

}
