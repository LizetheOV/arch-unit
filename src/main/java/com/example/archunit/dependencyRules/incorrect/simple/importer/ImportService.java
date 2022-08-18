package com.example.archunit.dependencyRules.incorrect.simple.importer;


import com.example.archunit.dependencyRules.incorrect.simple.administration.AdministrationService;

import java.util.UUID;

public class ImportService {
    private AdministrationService administrationService;

    public void process(String customer) {
        UUID customerId = administrationService.createCustomerId(customer);
        process(customerId, customer);
    }

    private void process(UUID id, String customer) {
        // process whatever
    }
}
