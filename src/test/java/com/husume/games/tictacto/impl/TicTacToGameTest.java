package com.husume.games.tictacto.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.husume.games.tictacto.Game;
import com.husume.games.tictacto.impl.TicTacToGame;
import com.husume.games.tictacto.GamePiece;
import com.husume.games.tictacto.exception.InvalidGamePlayException;


public class TicTacToGameTest {

	private final Game tictacto = new TicTacToGame();

	/*
	* x - -
	* x - -
	* x - -
	*/
	@Test
	public void testIsWonByVerticalLineFirst() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(0, 1, GamePiece.X);
		tictacto.playTurn(0, 2, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* - x -
	* - x -
	* - x -
	*/
	@Test
	public void testIsWonByVerticalMiddle() throws InvalidGamePlayException {
		tictacto.playTurn(1, 0, GamePiece.X);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(1, 2, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* - - x
	* - - x
	* - - x
	*/
	@Test
	public void testIsWonByVerticalLast() throws InvalidGamePlayException {
		tictacto.playTurn(2, 0, GamePiece.X);
		tictacto.playTurn(2, 1, GamePiece.X);
		tictacto.playTurn(2, 2, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* x x x
	* - - -
	* - - -
	*/
	@Test
	public void testIsWonbyHorizontalLineFirst() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(1, 0, GamePiece.X);
		tictacto.playTurn(2, 0, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* - - -
	* x x x
	* - - -
	*/
	@Test
	public void testIsWonbyHorizontalLineMiddle() throws InvalidGamePlayException {
		tictacto.playTurn(0, 1, GamePiece.X);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(2, 1, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* - - -
	* - - -
	* x x x
	*/
	@Test
	public void testIsWonbyHorizontalLineLast() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(1, 0, GamePiece.X);
		tictacto.playTurn(2, 0, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* - - x
	* - x -
	* x - -
	*/
	@Test
	public void testIsWonByDiagonalLineFromNN() throws InvalidGamePlayException {
		tictacto.playTurn(2, 0, GamePiece.X);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(0, 2, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	/*
	* x - -
	* - x -
	* - - x
	*/
	@Test
	public void testIsWonByDiagonalLineFrom00() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(2, 2, GamePiece.X); 

		boolean result = tictacto.isWonBy(GamePiece.X);

		assertTrue(result);
	}

	@Test
	public void testIsNotWon() {
		boolean result = tictacto.isWonBy(GamePiece.X);

		assertFalse(result);
	}

		/*
	* x - -
	* - x -
	* - - x
	*/
	@Test
	public void testIsNotTiedBecauseItIsWon() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(2, 2, GamePiece.X); 

		boolean result = tictacto.isTied();

		assertFalse(result);
	}

	/*
	* x 0 x
	* 0 x 0
	* 0 x 0
	*/
	@Test
	public void testIsTied() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(0, 1, GamePiece.Y);
		tictacto.playTurn(0, 2, GamePiece.Y);
		tictacto.playTurn(1, 0, GamePiece.Y);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(1, 2, GamePiece.X); 
		tictacto.playTurn(2, 0, GamePiece.X);
		tictacto.playTurn(2, 1, GamePiece.Y);
		tictacto.playTurn(2, 2, GamePiece.Y);  

		boolean result = tictacto.isTied();

		assertTrue(result);
	}

	@Test
	public void testIsNotTied() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(0, 1, GamePiece.Y);
		tictacto.playTurn(0, 2, GamePiece.Y);
		tictacto.playTurn(1, 0, GamePiece.Y);
		tictacto.playTurn(1, 1, GamePiece.X);
		tictacto.playTurn(1, 2, GamePiece.Y);  

		boolean result = tictacto.isTied();

		assertFalse(result);
	}

	@Test
	public void testPlayTurnSuccessful() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testPlayTurnWithBadGamePiece() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.AVAILABLE);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testPlayTurnOnSpaceAlreadyPlayed() throws InvalidGamePlayException {
		tictacto.playTurn(0, 0, GamePiece.X);
		tictacto.playTurn(0, 0, GamePiece.Y);
	}

	@Test(expected = InvalidGamePlayException.class)
	public void testPlayIllegalPositionTurn() throws InvalidGamePlayException {
		tictacto.playTurn(-1, 0, GamePiece.X);
	}

}