package com.unimelb.swen30006.monopoly.square;

import com.unimelb.swen30006.monopoly.Player;

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
public abstract class PropertySquare extends Square {
	protected Player owner;
	protected float price;
	
	public PropertySquare(String name, int index, float price) {
		super(name, index);
		this.price = price;
		owner = null;
	}

	/**
	 * behaviour based on Figure 36.25
	 * @param p player landed on the square
	 */
	@Override
	public void landOn(Player p) {
		if (owner==null){
			p.attempPurchase(this);
		}else if (!owner.equals(p)){
			payRent(p);
		}
		
		
	}
	
	/**
	 * behaviour based on Figure 36.27
	 * @param p player landed on the square
	 */
	private void payRent(Player p){
		float rent = getRent();
		owner.addCash(rent);
		p.reduceCash(rent);
		
		//add net worth calculation, not included in the figures in the book
		owner.addNetWorth(rent);
		p.reduceNetWorth(rent);
		
		System.out.println(p.getName()+" pays $"+rent+" to "+owner.getName());
	}
	
	
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public abstract float getRent();

	
}
