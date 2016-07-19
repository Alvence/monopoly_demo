package com.unimelb.swen30006.monopoly;
/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * The behavior is coded based on Figure 25.7
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-19
 *
 */
public class GoToJailSquare extends Square {
	private Square jail;
	
	public GoToJailSquare(String name, int index) {
		super(name, index);
	}
	
	public void setJail(Square jail){
		this.jail = jail;
	}

	@Override
	public void landOn(Player p) {
		p.setLocation(jail);
	}

}
