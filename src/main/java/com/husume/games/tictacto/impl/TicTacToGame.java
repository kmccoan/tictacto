package com.husume.games.tictacto.impl;

import com.husume.games.tictacto.Game;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.Board;
import com.husume.games.tictacto.impl.BoardImpl;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public class TicTacToGame implements Game {

	private final Board board;

	public TicTacToGame() {
		board = new BoardImpl();
	}

	@Override
	public boolean isWonBy(GamePiece p) {
		if (isVerticalWin(p) || isHorizontalWin(p) || isDiagonalWin(p)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isTied() {
		if (isWonBy(GamePiece.X) || isWonBy(GamePiece.Y)) {
			return false;
		}
		
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				if (GamePiece.AVAILABLE.equals(board.getState(col, row))) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void playTurn(int x, int y, GamePiece p) throws InvalidGamePlayException {
		board.setState(x, y, p);
	}

	private boolean isVerticalWin(GamePiece p) {
		for (int col = 0; col < 3; col++) {
			boolean win = true;
			for (int row = 0; row < 3; row ++) {
				if (!p.equals(board.getState(col,row))) {
					win = false;
				}
			}
			if (win) {
				return true;
			}
		}
		return false;
	}

	private boolean isHorizontalWin(GamePiece p) {
		for (int row = 0; row < 3; row++) {
			boolean win = true;
			for (int col = 0; col < 3; col ++) {
				if (!p.equals(board.getState(col,row))) {
					win = false;
				}
			}
			if (win) {
				return true;
			}
		}
		return false;
	}

	private boolean isDiagonalWin(GamePiece p) {
		boolean win = true;
		for (int col = 0; col < 3; col++) {
			int row = col;
			if (!p.equals(board.getState(col,row))) {
				win = false;
				break;
			}
		}

		if (win) {
			return true;
		}

		win = true;
		int row = 0;
		for (int col = 2; col >= 0; col--) {
			if (!p.equals(board.getState(col,row))) {
				win = false;
				break;
			}
			row++;
		}

		if (win) {
			return true;
		}

		return false;
	}
}