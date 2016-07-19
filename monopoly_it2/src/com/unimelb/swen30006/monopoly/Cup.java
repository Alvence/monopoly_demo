package com.unimelb.swen30006.monopoly;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * This class is proposed by Pure Fabrication, and holds a colletion of many Die objects;
 * 
 * The behavior is coded based on Figure 25.8 and 25.9
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-19
 *
 */
public class Cup {
	
	private List<Die> dice;
	private int total;
	
	public Cup(int numOfDice) {
		dice = new ArrayList<Die>(numOfDice);
		for (int i = 0; i < numOfDice; i++ ){
			dice.add(new Die());
		}
	}
	
	/**
	 * roll all the dice
	 */
	public void roll(){
		total = 0;
		for (Die die:dice){
			die.roll();
			total += die.getFaceValue();
		}
	}
	
	public int getTotal(){
		return total;
	}

}
