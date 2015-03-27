package com.husume.games.tictacto;

import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public interface Game {

	boolean isWonBy(GamePiece p);

	boolean isTied();

	void playTurn(int x, int y, GamePiece p) throws InvalidGamePlayException;
}