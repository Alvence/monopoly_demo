package com.unimelb.swen30006.monopoly;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-18
 *
 */
public class Board {
	public static final int SIZE = 40;
	
	public static final int INDEX_GO = 0;
	public static final int INDEX_INCOME_TAX = 4;
	public static final int INDEX_JAIL = 10;
	public static final int INDEX_GO_TO_JAIL = 30;
	
	private List<Square> squares = new ArrayList<Square>(SIZE);
	
	public Board(){
		buildSquares();
		linkSquares();
	}
	
	public Square getSquare(Square start, int distance){
		int endIndex = (start.getIndex() + distance) % SIZE;
		return squares.get(endIndex);
	}
	
	public Square getStartSquare(){
		return squares.get(0);
	}
	
	private void buildSquares(){
		for(int i = 0; i < SIZE; i++){
			Square s;
			if(i == INDEX_GO){
				s = new GoSquare("GO",i);
			}else if(i == INDEX_INCOME_TAX){
				s = new IncomeTaxSquare("Income Tax",i);
			}else if(i == INDEX_GO_TO_JAIL){
				s = new GoToJailSquare("Go to jail",i);
			}else if(i == INDEX_JAIL){
				s = new RegularSquare("Jail",i);
			}else{
				s = new RegularSquare("Square "+ i,i);
			}
			squares.add(s);
		}
		//set jail square
		((GoToJailSquare)squares.get(INDEX_GO_TO_JAIL)).setJail(squares.get(INDEX_JAIL));
	}
	
	private void linkSquares(){
		for (int i = 0; i < SIZE; i++){
			link(i);
		}
	}
	
	private void link(int i){
		Square current = squares.get(i);
		Square next = squares.get((i + 1) % SIZE);
		current.setNextSquare(next);
	}
}
