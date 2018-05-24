package bingo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Runner {

	public static JPanel p;

	public static void main(String[] args) {
		
		int testComett;

		Game game = new Game();

		JFrame frame = new JFrame("Bingo");

		JPanel p = new JPanel(new GridLayout(7, 5));
		
		String [] test = {"B", "I", "N", "G", "O"};
		
		JLabel B = new JLabel(test[0]);
		p.add(B);
		B.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel I = new JLabel(test[1]);
		p.add(I);
		I.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel N = new JLabel(test[2]);
		p.add(N);
		N.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel G = new JLabel(test[3]);
		p.add(G);
		G.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel O = new JLabel(test[4]);
		p.add(O);
		O.setHorizontalAlignment(JLabel.CENTER);

		for (int row = 0; row < game.board.length; row++) {

			for (int col = 0; col < game.board.length; col++) {

				JLabel newLabel = new JLabel(String.valueOf(game.board[row][col]));
				p.add(newLabel);
				newLabel.setHorizontalAlignment(JLabel.CENTER);
			}
		}


		// game.checkBoard();
		// game.endGame();
		/*
		 * JFrame frame = new JFrame("Bingo");
		 * 
		 * frame.setLayout(new GridLayout(6, 5));
		 * 
		 * for(int row = 0; row < game.board.length; row++) {
		 * 
		 * for (int col = 0; col < game.board.length; col++) {
		 * 
		 * JLabel newLabel = new JLabel(String.valueOf(game.board[row][col]));
		 * frame.add( newLabel ); newLabel.setHorizontalAlignment(JLabel.CENTER); } }
		 */

		//
		JLabel buttonOne = new JLabel("");
		buttonOne.setHorizontalAlignment(JLabel.CENTER);
		
		JButton button = new JButton("Roll");
		
		JLabel buttonTwo = new JLabel("");
		buttonTwo.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel buttonFour = new JLabel("");
		buttonFour.setHorizontalAlignment(JLabel.CENTER);

		ActionListener b1Event = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				game.checkBoard();
				
				if ( game.isBingo() ) {
					
					buttonFour.setText("YAY BINGO!!!");
					button.setText("Play Again?");
				}
				
				buttonOne.setText("Number:\n" + String.valueOf(game.getGuess()));

				// Resets the board
				p.removeAll();

				// Updates with new information
				
				JLabel B = new JLabel(test[0]);
				p.add(B);
				B.setHorizontalAlignment(JLabel.CENTER);
				
				JLabel I = new JLabel(test[1]);
				p.add(I);
				I.setHorizontalAlignment(JLabel.CENTER);
				
				JLabel N = new JLabel(test[2]);
				p.add(N);
				N.setHorizontalAlignment(JLabel.CENTER);
				
				JLabel G = new JLabel(test[3]);
				p.add(G);
				G.setHorizontalAlignment(JLabel.CENTER);
				
				JLabel O = new JLabel(test[4]);
				p.add(O);
				O.setHorizontalAlignment(JLabel.CENTER);
				
				for (int row = 0; row < game.board.length; row++) {

					for (int col = 0; col < game.board.length; col++) {

						JLabel newLabel = new JLabel(String.valueOf(game.board[row][col]));
						p.add(newLabel);
						newLabel.setHorizontalAlignment(JLabel.CENTER);

					}
				}

				p.add(buttonOne);
				p.add(buttonTwo);
				p.add(button);
				p.add(buttonFour);
				frame.add(p);

			}

		};

		button.addActionListener(b1Event);

		p.add(buttonOne);
		p.add(buttonTwo);
		p.add(button);
		frame.add(p);

		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
