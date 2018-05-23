package bingo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Runner {

	public static JPanel p;

	public static void main(String[] args) {

		Game game = new Game();

		JFrame frame = new JFrame("Bingo");

		JPanel p = new JPanel(new GridLayout(6, 5));

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
		JLabel buttonOne = new JLabel("Bing");
		JButton button = new JButton("Roll");
		JLabel buttonTwo = new JLabel("");

		ActionListener b1Event = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				game.checkBoard();

				buttonOne.setText(String.valueOf(game.getGuess()));

				// Resets the board
				p.removeAll();

				// Updates with new information
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
