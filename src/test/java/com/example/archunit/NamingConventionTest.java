package com.example.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class NamingConventionTest {

    private final static String PACKAGES = "com.example.archunit.namingConventionRules.correct";
    private final JavaClasses classes = new ClassFileImporter().importPackages(PACKAGES);

    @Test
    public void services_should_be_prefixed() {
        classes()
                .that().resideInAPackage("..service..")
                .and().areAnnotatedWith(Service.class)
                .should().haveSimpleNameStartingWith("Service")
                .check(classes);
    }

    @Test
    public void controllers_should_not_have_Gui_in_name() {
        classes()
                .that().resideInAPackage("..controller..")
                .should().haveSimpleNameNotContaining("Gui")
                .check(classes);
    }

    @Test
    public void controllers_should_be_suffixed() {
        classes()
                .that().resideInAPackage("..controller..")
                .or().areAnnotatedWith(Controller.class)
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);
    }

    @Test
    public void classes_named_controller_should_be_in_a_controller_package() {
        classes()
                .that().haveSimpleNameContaining("Controller")
                .should().resideInAPackage("..controller..")
                .check(classes);
    }

}
