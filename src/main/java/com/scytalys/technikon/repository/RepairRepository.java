package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
//    @Query("""
//            select r from Repair r
//                     join fetch r.property p
//                     join fetch p.user
//                     group by p
//                     order by r.repairDate
//            """)
//    Optional<List<Repair>> findRepairsByUserId;

    @Query("""
            select r from Repair r where r.repairDate = :repairDate
            """)
    List<Repair> findByRepairDate(Date repairDate);


    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);
}



