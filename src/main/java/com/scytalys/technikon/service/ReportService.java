package com.scytalys.technikon.service;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.dto.ReportDto;

import java.util.Date;
import java.util.List;

public interface ReportService {
    void reportSubmission(ReportDto reportDto);
    List<ReportDto> getReport(Date from, Date to);
}
