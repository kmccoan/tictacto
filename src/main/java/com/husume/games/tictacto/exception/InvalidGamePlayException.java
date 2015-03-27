package com.husume.games.tictacto.exception;

import java.lang.Exception;

public class InvalidGamePlayException extends Exception {
	public InvalidGamePlayException(String message) {
        super(message);
    }
}