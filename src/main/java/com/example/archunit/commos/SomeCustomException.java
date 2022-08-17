package com.example.archunit.commos;

public class SomeCustomException extends RuntimeException {
    public SomeCustomException() {
    }

    public SomeCustomException(String message) {
        super(message);
    }

    public SomeCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
