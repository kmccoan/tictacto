package com.husume.games.tictacto;

import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;

public interface Board {

	GamePiece getState(int x, int y);

	void setState(int x, int y, GamePiece piece) throws InvalidGamePlayException;	
}