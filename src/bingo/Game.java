package bingo;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	ArrayList<Integer> guesses; 
	int [] [] board = new int [5][5];
	int guess;
	
	public Game () {
		
		for (int row = 0; row < board.length; row++) {
			
			for (int col = 0; col < board[0].length; col++) {
				
				board [row][col] = makeRandom();
				
			}
		}
			
		
	}
	
	public void print() {
		
		System.out.println("|------------------------------------------------|");
		System.out.println("|\tB.\tI.\tN.\tG.\tO.\t|");
		System.out.println("|------------------------------------------------|");
	
		
		for (int row = 0; row < board.length; row++) {
			
			for (int col = 0; col < board[0].length; col++) {
				
				if (col != 4) {
					
					System.out.print("\t" + board [row][col]);
					
				} else {
					
					System.out.print("\t" + board [row][col] + "\n");
					
				}
			}
		}
		
	}
	
	public static int makeRandom() {
		Random r = new Random();
		return r.nextInt(99);
	}

}
