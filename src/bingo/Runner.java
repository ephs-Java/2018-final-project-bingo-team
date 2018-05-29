package bingo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Runner {
	static String[] test = { "B", "I", "N", "G", "O" };

	public static JPanel p;

	static JButton resetButton = new JButton("Play Again");
	
	static Game game = new Game();

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		p = new JPanel(new GridLayout(7, 5));

		printBingo();

		printBoard();

		JLabel buttonOne = new JLabel("");
		buttonOne.setHorizontalAlignment(JLabel.CENTER);

		JButton button = new JButton("Roll");

		JLabel buttonTwo = new JLabel("");
		buttonTwo.setHorizontalAlignment(JLabel.CENTER);

		JLabel buttonFour = new JLabel("");
		buttonFour.setHorizontalAlignment(JLabel.CENTER);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				game.checkBoard();

				if (game.isBingo()) {
					resetButton.setVisible(true);
					buttonOne.setText("YAY BINGO!!!");
					button.setVisible(false);
					// button.addActionListener(resetEvent);

				} else {

				buttonOne.setText("Number:\n" + String.valueOf(game.getGuess()));

				// Resets the board
				p.removeAll();

				// Updates with new information

				printBingo();
				printBoard();

				p.add(buttonOne);
				p.add(buttonTwo);
				p.add(button);
				p.add(resetButton);
				frame.add(p);
				}
			}

		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				p.removeAll();

				game.endGame();
				printBingo();
				printBoard();

				p.add(buttonOne);
				p.add(buttonTwo);
				p.add(button);
				p.add(resetButton);
				p.add(buttonFour);
				frame.add(p);
				
				button.setVisible(true);
				buttonOne.setText("");
				SwingUtilities.updateComponentTreeUI(frame);
				
			}
		});

		p.add(buttonOne);
		p.add(buttonTwo);
		p.add(button);
		p.add(resetButton);
		p.add(buttonFour);
		
		frame.add(p);

		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public static void printBingo() {
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
	}

	public static void printBoard() {
		resetButton.setVisible(false);
		for (int row = 0; row < game.board.length; row++) {

			for (int col = 0; col < game.board.length; col++) {

				JLabel newLabel = new JLabel(String.valueOf(game.board[row][col]));
				p.add(newLabel);
				newLabel.setHorizontalAlignment(JLabel.CENTER);

			}
		}
	}

}
