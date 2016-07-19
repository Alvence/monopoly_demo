package com.unimelb.swen30006.monopoly.square;

import com.unimelb.swen30006.monopoly.Player;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * The behavior is coded based on Figure 25.5
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-19
 *
 */
public class RegularSquare extends Square {
	public RegularSquare(String name, int index) {
		super(name, index);
	}

	@Override
	public void landOn(Player p) {
		//do nothing
	}

}
