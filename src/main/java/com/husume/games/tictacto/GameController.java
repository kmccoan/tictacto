package com.husume.games.tictacto;

import java.util.Scanner;

import com.husume.games.tictacto.Game;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.impl.TicTacToGame;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public class GameController {

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac To");

		GameController controller = new GameController();
		controller.run();
	}

	public void run() {
		Game game = new TicTacToGame();
		Scanner console = new Scanner(System.in);

		while(true) {
			play(console, game, GamePiece.X);
			if (isTieOrWin(game, GamePiece.X)) {
				break;
			}
			play(console, game, GamePiece.Y);
			if (isTieOrWin(game, GamePiece.Y)) {
				break;
			}
		}
	}

	private void play(Scanner console, Game game, GamePiece p) {
		while(true) {
			System.out.println(p + " please enter position: column row");
			int col = console.nextInt();
			int row = console.nextInt();
			try {
				game.playTurn(col, row, p);
				break;
			} catch(InvalidGamePlayException e) {
				System.out.println("Invalid play." + e.getMessage());
			}
		}
	}

	private boolean isTieOrWin(Game game, GamePiece p) {
		if (game.isTied()) {
			System.out.println("Game over. Tied");
			return true;
		}

		if (game.isWonBy(p)) {
			System.out.println("Game over. " + p + " has won.");
			return true;
		}
		return false;
	}

} 