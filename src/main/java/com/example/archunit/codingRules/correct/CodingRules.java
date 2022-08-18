package com.example.archunit.codingRules.correct;

import com.example.archunit.commos.SomeCustomException;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class CodingRules {
    private static final Logger logger = Logger.getLogger("Wrong Logger");

    public void printToStandardStream() throws FileNotFoundException {
        logger.info("I'm gonna print to the command line");
        logger.info("I'm gonna print to the command line");
        new SomeCustomException().printStackTrace(new PrintStream("/some/file"));

        new SomeCustomException().printStackTrace(new PrintStream("/some/file"));
        new SomeCustomException().printStackTrace(new PrintWriter("/some/file"));
    }

    public void throwGenericExceptions() throws Throwable {
        if (Math.random() > 0.75) {
            thisIsOkay();
        } else if (Math.random() > 0.25) {
            throw new SomeCustomException("Bummer");
        } else {
            throw new SomeCustomException("I have some cause", new SomeCustomException("I'm the cause"));
        }
    }


    public void thisIsOkay() {
        throw new SomeCustomException();
    }
}
