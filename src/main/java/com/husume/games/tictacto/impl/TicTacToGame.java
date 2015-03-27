package com.husume.games.tictacto.impl;

import com.husume.games.tictacto.Game;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public class TicTacToGame implements Game {

	public TicTacToGame() {

	}

	@Override
	public boolean isWonBy(GamePiece p) {
		return false;
	}

	@Override
	public boolean isTied() {
		return false;
	}

	@Override
	public void playTurn(int x, int y, GamePiece p) throws InvalidGamePlayException {
		
	}
}