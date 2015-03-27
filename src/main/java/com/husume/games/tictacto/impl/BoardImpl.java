package com.husume.games.tictacto.impl;

import java.util.Map;
import java.util.HashMap;

import com.husume.games.tictacto.Board;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public class BoardImpl implements Board {

	public BoardImpl()  {
	}

	@Override
	public GamePiece getState(int x, int y) {
		return null;
	}

	@Override
	public boolean setState(int x, int y, GamePiece piece) throws InvalidGamePlayException {
		return false;
	}

}