package com.unimelb.swen30006.monopoly.square;
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
public class RRSquare extends PropertySquare {
	
	public static final float RR_BASE_FEE = 25;

	public RRSquare(String name, int index, float price) {
		super(name, index, price);
	}

	@Override
	public float getRent() {
		int count = owner.getRRCount();
		return count*RR_BASE_FEE;
	}

}
