package com.unimelb.swen30006.monopoly;
/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-18
 *
 */
public class Player {
	private String name;
	private Piece piece;
	private Board board;
	private Die[] dice;
	
	public Player(String name, Die[] dice, Board board) {
		this.name = name;
		this.board = board;
		this.dice = dice;
		piece = new Piece(board.getStartSquare());
	}
	
	/**
	 * simulation run for each turn, output player, dice total and destination square
	 */
	public void takeTurn(){
		//roll dice
		int fvTot = 0;
		for (int i = 0; i < dice.length; i++){
			dice[i].roll();
			fvTot += dice[i].getFaceValue();
		}
		
		Square oldLoc = piece.getLocation();
		Square newLoc = board.getSquare(oldLoc, fvTot);
		piece.setLocation(newLoc);
		
		System.out.println(name+": dice total = "+fvTot+" move to "+newLoc.getName());
	}
	
	public Square getLocation(){
		return piece.getLocation();
	}
	
	public String getName(){
		return name;
	}
}
