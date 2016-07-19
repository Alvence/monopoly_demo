package com.unimelb.swen30006.monopoly.square;

import com.unimelb.swen30006.monopoly.Cup;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * The behavior is coded based on Figure 36.29
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-19
 *
 */
public class UtilitySquare extends PropertySquare {
	public static final int UTILILY_RATE = 4;

	public UtilitySquare(String name, int index, float price) {
		super(name, index, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getRent() {
		int total = Cup.getTotal();
		return total * UTILILY_RATE;
	}

}
