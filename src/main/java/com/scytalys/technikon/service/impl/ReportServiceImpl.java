package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.dto.ReportDto;
import com.scytalys.technikon.mapper.ReportMapper;
import com.scytalys.technikon.repository.ReportRepository;
import com.scytalys.technikon.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public void reportSubmission(ReportDto reportDto) {
        Report report = reportMapper.ReportDtoToReport(reportDto);
        Report savedReport = reportRepository.save(report);
        reportMapper.ReportToReportDto(savedReport);
    }

    @Override
    public List<ReportDto> getReport(Date from, Date to) {
        return reportRepository.reportsFromRange(from, to).orElse(null);
    }
}
