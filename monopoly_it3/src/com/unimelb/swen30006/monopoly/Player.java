package com.unimelb.swen30006.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.unimelb.swen30006.monopoly.square.PropertySquare;
import com.unimelb.swen30006.monopoly.square.RRSquare;
import com.unimelb.swen30006.monopoly.square.Square;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne.
 * 
 *  New Feature: 
 *  1. add properties attribute based on Figure 36.29
 *  2. add attempPurchase() function based on Figure 36.26
 * @author 	Yunzhe(Alvin) Jia
 * @version 3.0
 * @since 	2016-07-19
 *
 */
public class Player {
	public static final float INIT_CASH = 1000;
	
	private String name;
	private Square location;
	private Board board;
	private float cash;
	private float netWorth;
	
	private List<PropertySquare> properties = new ArrayList<PropertySquare>();
	private int RRCount = 0;
	
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		location = board.getStartSquare();
		cash = INIT_CASH;
		netWorth = 0;
	}
	
	/**
	 * simulation run for each turn, output player, dice total and destination square
	 */
	public void takeTurn(){
		//roll dice
		Cup.roll();
		int fvTot = Cup.getTotal();
		
		location = board.getSquare(location, fvTot);
		System.out.println(name+": dice total = "+fvTot+" move to "+location.getName());
		location.landOn(this);
	}
	
	public void attempPurchase(PropertySquare property){
		float price = property.getPrice();
		if (cash >= price){
			property.setOwner(this);
			reduceCash(price);
			properties.add(property);
			if (property instanceof RRSquare){
				RRCount++;
			}
			
			System.out.println(getName()+" buy "+property.getName());
		}
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
	
	public void addNetWorth(float c){
		netWorth+=c;
	}
	
	public void reduceNetWorth(float c){
		netWorth-=c;
	}
	
	public int getRRCount(){
		return RRCount;
	}
}
