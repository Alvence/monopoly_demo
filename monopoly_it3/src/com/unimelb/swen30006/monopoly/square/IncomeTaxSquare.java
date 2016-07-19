package com.unimelb.swen30006.monopoly.square;

import com.unimelb.swen30006.monopoly.Player;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * The behavior is coded based on Figure 25.6
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-19
 *
 */
public class IncomeTaxSquare extends Square {
	public static final int MAX_TAX = 200;
	public static final float TAX_RATE = 0.1f;
	
	public IncomeTaxSquare(String name, int index) {
		super(name, index);
	}

	@Override
	public void landOn(Player p) {
		float w = p.getNetWorth();
		float tax = min(MAX_TAX,w*TAX_RATE);
		p.reduceCash(tax);
		
		System.out.println(p.getName()+" pay income tax $"+tax);
	}
	
	private float min(float num1, float num2){
		if(num1 < num2){
			return num1;
		}else{
			return num2;
		}
	}

}
