package com.scytalys.technikon.controller;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.domain.ReportType;
import com.scytalys.technikon.dto.PropertyDto;
import com.scytalys.technikon.dto.ReportDto;
import com.scytalys.technikon.mapper.ReportMapper;
import com.scytalys.technikon.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @PostMapping("/create")
    public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto reportDto) {

        return new ResponseEntity<>(reportMapper.reportToReportDto(
                reportService.createReport(reportMapper.reportDtoToReport(reportDto))), HttpStatus.CREATED);
    }

    @GetMapping("/allreports")
    public ResponseEntity<List<ReportDto>> fetchReportList() {
        return new  ResponseEntity<>(reportMapper.reportToReportDtoList(reportService.fetchReportList()), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{reportId}")
    public ResponseEntity<ReportDto> updateReportById(@RequestBody ReportDto reportDto, @PathVariable("reportId") Long reportId) {
        Report updatedReport = reportService.updateReportById(reportMapper.reportDtoToReport(reportDto), reportId);
        ReportDto updatedReportDto = reportMapper.reportToReportDto(updatedReport);
        return ResponseEntity.ok(updatedReportDto);
    }

    @DeleteMapping("/delete/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable("reportId") final Long reportId) {
        reportService.deleteById(reportId);
        return ResponseEntity.ok("Report deleted successfully");
    }

    @GetMapping("/search/{reportId}")
    public ResponseEntity<ReportDto> findPropertyById(@PathVariable("reportId") Long reportId) {
        return new ResponseEntity<>(reportMapper.reportToReportDto(reportService.getReportById(reportId)), HttpStatus.ACCEPTED);
    }

}