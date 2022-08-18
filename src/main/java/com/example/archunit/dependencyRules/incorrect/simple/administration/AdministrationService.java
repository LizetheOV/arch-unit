package com.example.archunit.dependencyRules.incorrect.simple.administration;


import com.example.archunit.dependencyRules.incorrect.simple.report.Report;
import com.example.archunit.dependencyRules.incorrect.simple.report.ReportService;

import java.util.UUID;

public class AdministrationService {
    private ReportService reportService;

    public void saveNewInvoice(Invoice invoice) {
        Report report = reportService.getReport(invoice.getCustomer());
        if (!report.isEmpty()) {
            throw new IllegalArgumentException("Invoice " + invoice + " is not new");
        }
        // save whatever
    }

    public UUID createCustomerId(String customer) {
        return UUID.randomUUID();
    }
}
