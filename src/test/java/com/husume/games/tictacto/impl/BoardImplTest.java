package com.husume.games.tictacto.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.husume.games.tictacto.Board;
import com.husume.games.tictacto.impl.BoardImpl;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;


public class BoardImplTest {

	private static final int VALID_X_POS = 0;

	private static final int VALID_Y_POS = 0;

	private static final int INVALID_X_POS_NEG = -1;

	private static final int INVALID_Y_POS_NEG = -1;

	private static final int INVALID_X_POS_LARGE_SIZE = 3;

	private static final int INVALID_Y_POS_LARGE_SIZE = 3;

	private final Board board = new BoardImpl();

	@Test
	public void testSetAvailableSquare() throws InvalidGamePlayException {
		board.setState(VALID_X_POS, VALID_Y_POS, GamePiece.X);

		assertEquals(GamePiece.X, board.getState(VALID_X_POS, VALID_Y_POS));
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testSetUnAvailableSquare() throws InvalidGamePlayException {
		board.setState(VALID_X_POS, VALID_Y_POS, GamePiece.Y);
		
		board.setState(VALID_X_POS, VALID_Y_POS, GamePiece.X);

		assertEquals(GamePiece.Y, board.getState(VALID_X_POS, VALID_Y_POS));
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testSetUsingInvalidGamepiece() throws InvalidGamePlayException {
		board.setState(VALID_X_POS, VALID_Y_POS, GamePiece.AVAILABLE);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testSetNegativeX() throws InvalidGamePlayException  {
		board.setState(INVALID_X_POS_NEG, VALID_Y_POS, GamePiece.Y);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testSetNegativeY() throws InvalidGamePlayException  {
		board.setState(VALID_X_POS, INVALID_Y_POS_NEG, GamePiece.Y);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testSetLargeX() throws InvalidGamePlayException  {
		board.setState(INVALID_X_POS_LARGE_SIZE, VALID_Y_POS, GamePiece.Y);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testSetLargeY() throws InvalidGamePlayException  {
		board.setState(VALID_Y_POS, INVALID_Y_POS_LARGE_SIZE, GamePiece.Y);
	}

	@Test
	public void testGetState() throws InvalidGamePlayException  {
		board.setState(VALID_X_POS, VALID_Y_POS, GamePiece.Y);
		GamePiece result = board.getState(VALID_X_POS, VALID_Y_POS);

		assertEquals(GamePiece.Y, result);
	}
}