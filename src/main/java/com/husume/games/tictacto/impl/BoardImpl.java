package com.husume.games.tictacto.impl;

import java.lang.Integer;
import java.lang.ArrayIndexOutOfBoundsException;

import com.husume.games.tictacto.Board;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public class BoardImpl implements Board {

	private GamePiece [][] grid;

	public BoardImpl()  {
		grid = initBoard();
	}

	@Override
	public GamePiece getState(int col, int row) {
		return grid[col][row];
	}

	@Override
	public void setState(int col, int row, GamePiece piece) throws InvalidGamePlayException {
		if (validate(col, row)) {
			GamePiece previous = getState(col, row);
			if (!previous.equals(GamePiece.AVAILABLE)) {
				throw new InvalidGamePlayException("Position is already taken by another game piece.");
			}

			if (piece.equals(GamePiece.AVAILABLE)) {
				throw new InvalidGamePlayException("Using Illegal Gamepiece");
			}

			grid[col][row] = piece;
		}
		else {
			throw new InvalidGamePlayException("Trying to set an invalid square position.");
		}
	}

	private boolean validate(int col, int row) {
		if (col < 0 || col >= grid[0].length || row < 0 || row >= grid[1].length) {
			return false;
		}
		return true;
	}

	/**
	* [0 0] [1 0] [2 0]
	* [0 1] [1 1] [2 1]
	* [0 2] [1 2] [2 2]
	**/
	private GamePiece[][] initBoard() {
		GamePiece[][] grid = new GamePiece[3][3];
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				grid[col][row] = GamePiece.AVAILABLE;
			}
		}
		return grid;
	}

}