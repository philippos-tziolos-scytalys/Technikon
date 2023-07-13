package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

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

    List<Repair> findByRepairDate(Date repairDate);


    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);
}



