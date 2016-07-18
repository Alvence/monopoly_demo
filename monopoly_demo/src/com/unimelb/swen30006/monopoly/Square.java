package com.unimelb.swen30006.monopoly;
/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-18
 *
 */
public class Square {
	private String name;
	private Square nextSquare;
	private int index;
	
	public Square(String name, int index) {
		this.name = name; 
		this.index = index;
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}
	
	public Square getNextSquare() {
		return nextSquare;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
	
}
