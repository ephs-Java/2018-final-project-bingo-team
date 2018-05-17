package bingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	ArrayList<Integer> guesses; 
	int [][] board = new int [5][5];
	int guess;
	
	public Game () {
		////// Uses 2D int Array /////
		
		for (int row = 0; row < 5; row++) {
			
			for (int col = 0; col < 5; col++) {
				
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
			board[2][2] = 0; //free space
		}
			
	}
	
//	public void print() {
//		
//		System.out.println("|-----------------------------------------------|");
//		System.out.println("|\tB.\tI.\tN.\tG.\tO.\t|");
//		System.out.println("|-----------------------------------------------|");
//	
//		
//		for (int row = 0; row < 5; row++) {
//			
//			for (int col = 0; col < 5; col++) {
//				
//				if (col == 0) {
//					
//					System.out.print("\t" + board[row][col]);
//					
//				} else if (col % 4 == 0) {
//					
//					System.out.print("\t" + board[row][col] + "\n");
//					
//				} else {
//					
//					System.out.print("\t" + board[row][col]);
//				}
//				
//				
//			}
//		}
//	}
	
	public static int makeRandom(int num) {
		Random r = new Random();
		return r.nextInt(15) + num;
	}
	
	public static int makeRandom() {
		Random r = new Random();
		return r.nextInt(99) + 1;
	}
	
	public boolean isBingo () {
		// checks the horizontal bingos //
		for (int i = 0; i < 5; i++) {
			
			if ( horzBingo(i) ) {
				return true;
			}
				
		}
		
		// checks the vertical bingos //
		for (int i = 0; i < 5; i++) {
			
			if ( vertBingo(i) ) {
				return true;
			}
				
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
	
	public boolean horzBingo (int row) {
		boolean bool = true;
		
		for (int col = 0; col < 5; col++) {
			
			if ( this.board [row][col] != 0 )  
				return false;
		}
		
		
		return bool; 
	}
	
	public boolean vertBingo (int col) {
		boolean bool = true;
		
		for (int row = 0; row < 5; row++) {
			
			if ( this.board [row][col] != 0 )  
				return false;
		}
		return bool; 
	}
	
	public void checkBoard () {
		
		boolean wantPlay = true;
		// Prints initial board // 
//		System.out.println("Here is your board !!\n");
//		this.print();
		
		while ( !this.isBingo() && wantPlay) {

			
			// Has user start and stop game //
			boolean test = false;
			
//			System.out.println("\nPress enter to roll another number");
			Scanner s = new Scanner(System.in);
			
			String user = s.nextLine();
			
			if (! user.equals("quit") ) {
			
				
			}
			
			
			// Guesses the number and sets board to zero //
			int guess = makeRandom();
			
			for (int row = 0; row < this.board.length; row++) {
				
				for (int col = 0; col < this.board[0].length; col++) {
					
					if (this.board[row][col] == guess) {
						
						this.board[row][col] = 0; 
						test = true;
					
					}	
				}
				
			}
			
			if (test) {
//				System.out.println("Yay your board has a " + guess);
			} else {
//				System.out.println("Sorry your board doesn't have a " + guess);
			}
			
//			this.print();
	
			System.out.println();
			System.out.println();

		
		}
	}
	
	public void endGame() {

		
		// Checks if they got a bingo again //
		if ( this.isBingo() ) {
			System.out.println("Congrats you got a bingo!");
			System.out.println("Would you like to play again? (y/n)");
		}
		
		// Asks the user if they want to play again //
		Scanner keyboard = new Scanner (System.in);
		String s = keyboard.nextLine();
		s.toLowerCase();
		
		// Either starts new game or ends it //
		if (s.equals ("y") ) {
			
			Game newGame = new Game();
			this.checkBoard();
			this.endGame();
			
		} else if ( s.equals("n") ) {
			System.out.println("Have a nice day!");	
		} else { 
			System.out.println("Please enter a valid letter");	
		}
	}
	
}
