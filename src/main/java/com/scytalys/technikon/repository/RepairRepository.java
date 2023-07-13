package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    //    @Query("""
//            select r from Repair r
//            join r.property p
//            join fetch p.user u
//            where u.id = :userId
//            order by r.repairDate
//            """)
    @Query("""
            select r from Repair r
            join r.property p
            join p.user u
            where u.id = :userId
            order by r.repairDate
            """)
    List<Repair> findRepairByUserId(Long userId);

    @Query("""
            select r from Repair r
                    where r.repairDate = :repairDate
            """)
    Optional<List<Repair>> findByRepairDate(Date repairDate);


//    Optional<List<Repair>> findByRangeOfRepairDates(Date startRepairDate, Date endRepairDate);

}



