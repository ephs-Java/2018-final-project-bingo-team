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
				
				if (col == 0) 
					board [row][col] = makeRandom(1);
				else if (col == 1)
					board [row][col] = makeRandom(15);
				else if (col == 2)
					board [row][col] = makeRandom(30);
				else if (col == 3)
					board [row][col] = makeRandom(45);
				else if (col == 4)
					board [row][col] = makeRandom(60);
				
			}
		}
			
		
	}
	
	public void print() {
		
		System.out.println("|-----------------------------------------------|");
		System.out.println("|\tB.\tI.\tN.\tG.\tO.\t|");
		System.out.println("|-----------------------------------------------|");
	
		
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
	
	
	public static int makeRandom(int num) {
		Random r = new Random();
		return r.nextInt(15) + num;
	}
	
	public boolean isBingo () {
		// checks the horizontal bingos //
		for (int col = 0; col < 5; col++) {
			
			if ( this.board [0][col] == 0)
				return true;
			
			else if ( this.board [1][col] == 0)
				return true;
			
			else if ( this.board [2][col] == 0)
				return true;
			
			else if ( this.board [3][col] == 0)
				return true;
			
			else if ( this.board [4][col] == 0)
				return true;
		}
		
		// checks the vertical bingos //
		for (int row = 0; row < 5; row++) {
			
			if ( this.board [row][0] == 0)
				return true;
			
			else if ( this.board [row][1] == 0)
				return true;
			
			else if ( this.board [row][2] == 0)
				return true;
			
			else if ( board [row][3] == 0)
				return true;
			
			else if ( board [row][4] == 0)
				return true;
		}
		// checks the left to right diagonal bingos //
		if ( board [0][0] == 0
				&& this.board [1][1] == 0
				&& this.board [2][2] == 0 
				&& this.board [3][3] == 0 
				&& this.board [4][4] == 0 ) {
			
			return true;
		}
			
		// checks the right to left diagonal bingos //
		if ( this.board [0][4] == 0
				&& this.board [1][3] == 0
				&& this.board [2][2] == 0 
				&& this.board [3][1] == 0 
				&& this.board [4][0] == 0 ) {
			
			return true;
		}
		
		return false;
	}

}
