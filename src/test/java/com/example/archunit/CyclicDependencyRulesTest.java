package com.example.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class CyclicDependencyRulesTest {

    private final static String PACKAGES = "com.example.archunit.dependencyRules.correct";
    private final JavaClasses classes = new ClassFileImporter().importPackages(PACKAGES);

    @Test
    public void no_cycles_by_inheritance_between_slices() {
        slices().matching("..(inheritance).(*)..").namingSlices("$2 of $1")
                .should().beFreeOfCycles()
                .check(classes);
    }

    @Test
    public void no_cycles_in_simple_scenario() {
        slices().matching("..simple.(*)..").namingSlices("$1")
                .should().beFreeOfCycles()
                .check(classes);
    }
}
