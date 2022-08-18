package com.example.archunit.dependencyRules.incorrect.simple.report;

import com.example.archunit.dependencyRules.incorrect.simple.importer.ImportService;

public class ReportService {
    private ImportService importService;

    public Report getReport(String customer) {
        if (isUnknown(customer)) {
            importService.process(customer);
        }
        return new Report();
    }

    private boolean isUnknown(String customer) {
        return true;
    }
}
