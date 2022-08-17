package com.example.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

import java.util.logging.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

public class CodingRulesTest {
    private final static String PACKAGES = "com.example.archunit.codingRules.correct";
    private final JavaClasses codingRulesClasses = new ClassFileImporter().importPackages(PACKAGES);

    @Test
    public void classes_should_not_access_standard_streams_defined_by_hand() {
        noClasses().should(ACCESS_STANDARD_STREAMS).check(codingRulesClasses);
    }

    @Test
    public void classes_should_not_access_standard_streams_from_library() {
        NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS.check(codingRulesClasses);
    }

    @Test
    public void classes_should_not_throw_generic_exceptions() {
        NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(codingRulesClasses);
    }

    @Test
    public void loggers_should_be_private_static_final() {
        fields().that().haveRawType(Logger.class)
                .should().bePrivate()
                .andShould().beStatic()
                .andShould().beFinal()
                .because("we agreed on this convention")
                .check(codingRulesClasses);
    }

    @Test
    public void static_final_fields_names_should_be_uppercase() {
        fields().that().areFinal()
                .and() .areDeclaredInClassesThat()
                .resideInAPackage(PACKAGES)
                .should().haveFullNameMatching("/^[A-Z]*$/");
    }

}
