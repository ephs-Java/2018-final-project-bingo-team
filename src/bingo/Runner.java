package bingo;

import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game();
		game.print();
		checkBoard(game);
		
		System.out.println(game.isBingo());
		
	}
	
	public static void checkBoard (Game game) {
		
		while ( !game.isBingo() ) {
			
			int guess = makeRandom();
			
			for (int row = 0; row < game.board.length; row++) {
				
				for (int col = 0; col < game.board[0].length; col++) {
					
					if (game.board[row][col] == guess) {
						
						game.board[row][col] = 0; 
						
					}
				}
				
			}
			
			game.print();	
			System.out.println();
		
		}
	}
	
	public static int makeRandom() {
		Random r = new Random();
		return r.nextInt(99) + 1;
	}


}
