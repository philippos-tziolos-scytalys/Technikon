package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.domain.Report;

import java.util.List;

public interface ReportService {

    List<Report> fetchReportList();
    Report createReport(Report report);

    Report updateReportById(Report report, Long reportId);

    void deleteById(Long reportId);

    Report getReportById(Long reportId);
}