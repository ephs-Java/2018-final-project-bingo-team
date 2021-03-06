package bingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	//My test for commit
	int testCommitt;
	ArrayList<Integer> guesses = new ArrayList<Integer>();
	ArrayList<Integer> holdNums = new ArrayList<Integer>();
	int[][] board = new int[5][5];
	int guess;
	int roll;
	private int ranNum;
	int test;

	public Game() {
		createBoard();
	}

	public static int makeRandom(int num) {
		Random r = new Random();
		return r.nextInt(15) + num;
	}

	public static int makeRandom() {
		Random r = new Random();
		return r.nextInt(99) + 1;
	}

	// Continues rolling a random number until a new one is rolled and added to list
	public void dupTest(int num, ArrayList<Integer> list) {
		guess = makeRandom(num);

		while (checkDup(holdNums) == false) {
			guess = makeRandom(num);
		}

		list.add(guess);
	}

	public boolean isBingo() {
		// checks the horizontal bingos //
		for (int i = 0; i < 5; i++) {

			if (horzBingo(i)) {
				return true;
			}

		}

		// checks the vertical bingos //
		for (int i = 0; i < 5; i++) {

			if (vertBingo(i)) {
				return true;
			}

		}
		// checks the left to right diagonal bingos //
		if (board[0][0] == 0 && this.board[1][1] == 0 && this.board[2][2] == 0 && this.board[3][3] == 0
				&& this.board[4][4] == 0) {

			return true;
		}

		// checks the right to left diagonal bingos //
		if (this.board[0][4] == 0 && this.board[1][3] == 0 && this.board[2][2] == 0 && this.board[3][1] == 0
				&& this.board[4][0] == 0) {

			return true;
		}

		return false;
	}

	public boolean horzBingo(int row) {
		boolean bool = true;

		for (int col = 0; col < 5; col++) {

			if (this.board[row][col] != 0)
				return false;
		}

		return bool;
	}

	public boolean vertBingo(int col) {
		boolean bool = true;

		for (int row = 0; row < 5; row++) {

			if (this.board[row][col] != 0)
				return false;
		}
		return bool;
	}

	// Checks for duplicates in the list
	public boolean checkDup(ArrayList<Integer> list) {
		for (Integer item : list) {
			if (guess == item) {
				return false;
			}
		}
		return true;
	}

	// Check board for rolled numbers
	public void checkBoard() {

	// Guesses the number and sets board to zero //
		guess = makeRandom();
		while(checkDup(guesses) == false) {
			guess = makeRandom();
		}
		
		guesses.add(guess);

	// Checking part of the method
		for (int row = 0; row < this.board.length; row++) {

			for (int col = 0; col < this.board[0].length; col++) {

				if (this.board[row][col] == guess) {

					this.board[row][col] = 0;

				}
			}
		}
	}

	public int getGuess() {
		return guess;
	}

	public void getRandom() {
		guess = makeRandom();
	}

	public void endGame() {
		guesses.clear();
		holdNums.clear();
		createBoard();
	}
	
	public void createBoard() {
		////// Uses 2D int Array /////

		for (int row = 0; row < 5; row++) {

			for (int col = 0; col < 5; col++) {

				if (col == 0) {
					dupTest(1, holdNums);
					this.board[row][col] = guess;

				} else if (col == 1) {
					dupTest(15, holdNums);
					this.board[row][col] = guess;
				} else if (col == 2) {
					dupTest(30, holdNums);
					this.board[row][col] = guess;
				} else if (col == 3) {
					dupTest(45, holdNums);
					this.board[row][col] = guess;
				} else if (col == 4) {
					dupTest(60, holdNums);
					this.board[row][col] = guess;
				}

			}
			
		}
		this.board[2][2] = 0; // free space
	}
}
