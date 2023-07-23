package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.dto.ReportDto;
import org.mapstruct.Mapper;
@Mapper
public interface ReportMapper {
    Report ReportDtoToReport(ReportDto reportDto);

    ReportDto ReportToReportDto(Report report);
}
