package com.example.archunit.dependencyRules.correct.simple.administration;


import com.example.archunit.dependencyRules.correct.simple.importer.ImportService;
import com.example.archunit.dependencyRules.correct.simple.report.Report;
import com.example.archunit.dependencyRules.correct.simple.report.ReportService;

import java.util.UUID;

public class AdministrationService {
    private ReportService reportService;
    private ImportService importService;

    public void saveNewInvoice(Invoice invoice) {
        String customer = invoice.getCustomer();
        Report report = reportService.getReport(customer);
        UUID customerId = createCustomerId(customer);
        importService.process(customerId, customer);

        if (!report.isEmpty()) {
            throw new IllegalArgumentException("Invoice " + invoice + " is not new");
        }
        // save whatever
    }

    public UUID createCustomerId(String customer) {
        return UUID.randomUUID();
    }
}
