package com.example.archunit.dependencyRules.incorrect.inheritance.slice1;


import com.example.archunit.dependencyRules.incorrect.inheritance.slice3.ClassThatImplementsInterfaceFromSliceOne;

public class ClassThatCallSliceThree {
    public ClassThatCallSliceThree() {
        new ClassThatImplementsInterfaceFromSliceOne();
    }
}
