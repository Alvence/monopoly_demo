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
		for(int i = 1; i <= SIZE; i++){
			build(i);
		}
	}
	
	private void build(int i){
		Square s = new Square("Square "+i, i - 1);
		squares.add(s);
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
