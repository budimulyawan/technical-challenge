package org.oracle.reporting;

public class ConsoleReportViewer implements ReportViewer{
    @Override
    public void view(Report report) {
        System.out.println(report.getDescription());
        System.out.println(report.getReportBody());
    }
}
