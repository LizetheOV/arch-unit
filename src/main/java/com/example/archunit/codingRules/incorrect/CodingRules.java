package com.example.archunit.codingRules.incorrect;

import com.example.archunit.commos.SomeCustomException;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class CodingRules {
    static Logger log = Logger.getLogger("Wrong Logger");

    public void printToStandardStream() throws FileNotFoundException {
        System.out.println("I'm gonna print to the command line");
        System.err.println("I'm gonna print to the command line");
        new SomeCustomException().printStackTrace();

        new SomeCustomException().printStackTrace(new PrintStream("/some/file"));
        new SomeCustomException().printStackTrace(new PrintWriter("/some/file"));
    }

    public void throwGenericExceptions() throws Throwable {
        if (Math.random() > 0.75) {
            throw new Throwable();
        } else if (Math.random() > 0.25) {
            throw new Exception("Bummer");
        } else {
            throw new RuntimeException("I have some cause", new Exception("I'm the cause"));
        }
    }

    public void thisIsOkay() {
        throw new SomeCustomException();
    }
}
