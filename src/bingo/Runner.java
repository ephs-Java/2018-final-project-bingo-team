package bingo;

import java.awt.GridLayout;

import javax.swing.*;

public class Runner {

	public static void main(String[] args) {
		
		Game game = new Game();
//		game.checkBoard();
//		game.endGame();
		
		JFrame frame = new JFrame("Bingo");
		
		frame.setLayout(new GridLayout(6, 5));
		
		// fills gridLayout with bingo board //
		for(int row = 0; row < game.board.length; row++) {
			
			for (int col = 0; col < game.board.length; col++) {
				
				JLabel newLabel = new JLabel(String.valueOf(game.board[row][col]));
				frame.add( newLabel );
				newLabel.setHorizontalAlignment(JLabel.CENTER);
			}
			
			
		}
		
		JLabel buttonOne = new JLabel("");
		JButton button = new JButton("Roll");
		JLabel buttonTwo = new JLabel("");
		
		frame.add(buttonOne);
		frame.add(buttonTwo);
		frame.add(button);
		
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

	}
	
}
