package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    @Query("""
            select r from Repair r
            join r.property p
            join p.user u
            where u.id = :userId
            order by r.repairDate
            """)

    List<Repair> findRepairByUserId(Long userId);

    List<Repair> findByRepairDate(Date repairDate);

    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);
}



