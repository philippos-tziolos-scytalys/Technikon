package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReportRepository extends JpaRepository<Report, Long> {

    }