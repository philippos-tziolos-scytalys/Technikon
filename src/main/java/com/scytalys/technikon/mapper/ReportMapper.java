package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.ReportDto;
import com.scytalys.technikon.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    Report reportDtoToReport(ReportDto reportDto);

    ReportDto reportToReportDto(Report report);

    List<Report> reportDtoToReportList(List<ReportDto> reportDtoList);

    List<ReportDto> reportToReportDtoList(List<Report> reportList);

}