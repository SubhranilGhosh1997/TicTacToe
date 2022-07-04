package com.monocept.test;

import java.util.Scanner;

public class TicTacToe {
	static char[][] board = new char[3][3];
	static String winner;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Player's name");
		String firstPlayer = sc.nextLine();
		System.out.println("Enter Second Player's name");
		String secondPlayer = sc.nextLine();
		System.out.println(firstPlayer + " with mark X. ");
		System.out.println(secondPlayer + " with mark O. ");
		int totalTurn = 0;
		do {
			firstPlayerMove(firstPlayer);
			if (isContinue('X')) {
				winner = firstPlayer;
				getWinnerName();
				break;
			}
			totalTurn++;
			if (totalTurn == 9) {
				System.out.println("Match Draw");
				break;
			}
			secondPlayerMove(secondPlayer);
			if (isContinue('O')) {
				winner = secondPlayer;
				getWinnerName();
				break;
			}
			totalTurn++;
		} while (totalTurn <= 9);

	}

	private static boolean putO(int row, int column) {
		boolean success = validatebox(row, column);
		if (success == true) {
			board[row - 1][column - 1] = 'O';
		}
		return success;
	}

	private static boolean putX(int row, int column) {
		boolean success = validatebox(row, column);
		if (success == true) {
			board[row - 1][column - 1] = 'X';
		}
		return success;
	}

	private static boolean validatebox(int row, int column) {
		if (row > 3 || column > 3)
			return false;
		if (board[row - 1][column - 1] == 'X' || board[row - 1][column - 1] == 'O') {
			System.out.println("already " + board[row - 1][column - 1] + " present at this point please try again....");
			return false;
		} else
			return true;
	}

	private static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + board[i][j] + " ");
				if (j != 2)
					System.out.print("|");
			}
			System.out.println();
			System.out.println("-----------");
		}
	}

	private static boolean isContinue(char input) {
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == input
				|| board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == input
				|| board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == input
				|| board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == input
				|| board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == input
				|| board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == input
				|| board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == input
				|| board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] == input) {
			return true;
		}
		return false;
	}

	private static void getWinnerName() {
		System.out.println("--------------------------------");
		System.out.println("......." + winner + " WIN THE GAME.......");
		System.out.println("--------------------------------");
	}

	private static void firstPlayerMove(String firstPlayer) {
		Scanner sc = new Scanner(System.in);
		int column, row;
		do {
			System.out.println(firstPlayer + " , enter your move (row[1-3] column[1-3]):");
			column = sc.nextInt();
			row = sc.nextInt();
		} while (!putX(column, row));
		printBoard();
	}

	private static void secondPlayerMove(String secondPlayer) {
		Scanner sc = new Scanner(System.in);
		int column, row;
		do {
			System.out.println(secondPlayer + " , enter your move (row[1-3] column[1-3]):");
			column = sc.nextInt();
			row = sc.nextInt();
		} while (!putO(column, row));
		printBoard();
	}
}
