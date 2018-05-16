package bingo;

import java.util.Random;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game();
		
		checkBoard(game);
		endGame(game);
		
		
	}
	
	public static void checkBoard (Game game) {
		
		boolean wantPlay = true;
		// Prints initial board // 
		System.out.println("Here is your board !!\n");
		game.print();
		
		while ( !game.isBingo() && wantPlay) {

			
			// Has user start and stop game //
			boolean test = false;
			
			System.out.println("\nPress enter to roll another number");
			Scanner s = new Scanner(System.in);
			
			String user = s.nextLine();
			
			if (! user.equals("quit") ) {
			
				
			}
			
			
			// Guesses the number and sets board to zero //
			int guess = makeRandom();
			
			for (int row = 0; row < game.board.length; row++) {
				
				for (int col = 0; col < game.board[0].length; col++) {
					
					if (game.board[row][col] == guess) {
						
						game.board[row][col] = 0; 
						test = true;
					
					}	
				}
				
			}
			
			if (test) {
				System.out.println("Yay your board has a " + guess);
			} else {
				System.out.println("Sorry your board doesn't have a " + guess);
			}
			
			game.print();
	
			System.out.println();
			System.out.println();

		
		}
	}
	
	public static int makeRandom() {
		Random r = new Random();
		return r.nextInt(99) + 1;
	}

	public static void endGame(Game game) {
		
		// Checks if they got a bingo again //
		if ( game.isBingo() ) {
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
			checkBoard(newGame);
			endGame(newGame);
			
		} else if ( s.equals("n") ) {
			System.out.println("Have a nice day!");	
		} else { 
			System.out.println("Please enter a valid letter");	
		}
	}
}
