package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.*;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.ReportService;
import com.scytalys.technikon.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;


    public List<Report> fetchReportList() {
        return reportRepository.findAll();
    }

    @Override
    public Report createReport(Report newReport) {
        User user = newReport.getUser();
        User existingUser = userRepository.findByTinNumber(user.getTinNumber());
        newReport.setUser(existingUser);
        return reportRepository.save(newReport);
    }

    @Override
    public Report updateReportById(Report report, Long reportId) {
        return reportRepository.findById(reportId)
                .map(report1 -> {
                    report1.setReportDate(report.getReportDate());
                    report1.setReportType(report.getReportType());
                    report1.setReportDescription(report.getReportDescription());
                    return reportRepository.save(report1);
                }).orElseThrow(() -> new RuntimeException("Id not found" + reportId));
    }

    @Override
    public void deleteById(Long reportId) {
        reportRepository.deleteById(reportId);
    }

    @Override
    public Report getReportById(Long reportId) {
        return reportRepository.findById(reportId).orElseThrow(
                () -> new RuntimeException("Id not found" + reportId));
    }


}