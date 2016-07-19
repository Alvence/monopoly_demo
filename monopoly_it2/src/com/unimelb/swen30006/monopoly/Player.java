package com.unimelb.swen30006.monopoly;
/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne.
 * 
 *  New Feature: 
 *  1. add cash and netWorth attributes
 *  2. update takeTurn() based on Figure 25.3 and 25.9
 *  3. remove Piece to be consistent with Figure 25.2
 *  4. add Cup attribute and remove dice
 * @author 	Yunzhe(Alvin) Jia
 * @version 2.0
 * @since 	2016-07-19
 *
 */
public class Player {
	public static final float INIT_CASH = 1000;
	
	private String name;
	private Square location;
	private Board board;
	private Cup cup;
	private float cash;
	private float netWorth;
	
	public Player(String name, Cup cup, Board board) {
		this.name = name;
		this.board = board;
		this.cup = cup;
		location = board.getStartSquare();
		cash = INIT_CASH;
		netWorth = 0;
	}
	
	/**
	 * simulation run for each turn, output player, dice total and destination square
	 */
	public void takeTurn(){
		//roll dice
		cup.roll();
		int fvTot = cup.getTotal();
		
		location = board.getSquare(location, fvTot);
		location.landOn(this);
		
		System.out.println(name+": dice total = "+fvTot+" move to "+location.getName());
	}
	
	public Square getLocation(){
		return location;
	}
	
	public void setLocation(Square location){
		this.location = location;
	}
	
	public String getName(){
		return name;
	}
	
	public float getCash(){
		return cash;
	}
	
	public float getNetWorth(){
		return netWorth;
	}
	
	public void addCash(float c){
		cash+=c;
	}
	
	public void reduceCash(float c){
		cash-=c;
	}
}
