package com.example.springadvancedtheorie.exceptions;

public class KanMailNietVersturenException extends RuntimeException{
    public static final long serialVersionUID = 1L;

    public KanMailNietVersturenException(Throwable cause) {
        super(cause);
    }
}
