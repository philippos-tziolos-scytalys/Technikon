package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Report;
import com.scytalys.technikon.dto.ReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReportRepository  extends JpaRepository<Report, Long> {
    @Query("""
            select r from Report r
                    where r.reportDate >= :from and r.reportDate <= :to
            """)
    Optional<List<ReportDto>> reportsFromRange(Date from, Date to);
}
