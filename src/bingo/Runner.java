package bingo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Runner {

	public static void main(String[] args) {
		
		Game game = new Game();
//		game.checkBoard();
//		game.endGame();
		
		JFrame frame = new JFrame("Bingo");
		
		frame.setLayout(new GridLayout(6, 5));

//		JLabel title = new JLabel("Bingo Game");
//
//		frame.add(new JLabel(""));
//		frame.add(new JLabel(""));
//		frame.add(title);
//		frame.add(new JLabel(""));
//		frame.add(new JLabel(""));
//		Test
		
		// fills gridLayout with bingo board //
		for(int row = 0; row < game.board.length; row++) {
			
			for (int col = 0; col < game.board.length; col++) {
				
				JLabel newLabel = new JLabel(String.valueOf(game.board[row][col]));
				frame.add( newLabel );
				newLabel.setHorizontalAlignment(JLabel.CENTER);
			}
			
			
		}
		
		JLabel buttonOne = new JLabel("Bing");
		JButton button = new JButton("Roll");
		JLabel buttonTwo = new JLabel("");
		
		ActionListener b1Event = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				game.checkBoard();
//				clearBoard(frame);
				for(int row = 0; row < game.board.length; row++) {
					
					for (int col = 0; col < game.board.length; col++) {
						
						frame.add( new JLabel(String.valueOf(game.board[row][col]) ) );
						
					}
				}
				
			}
		};
		
		button.addActionListener(b1Event);
		
		frame.add(buttonOne);
		frame.add(buttonTwo);
		frame.add(button);
		
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

	}
	
}
