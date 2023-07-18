package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("""
            select p from Property p
                    where p.pinNumber = :pin
            """)
    Property findByPin(Long pin);

//    @Query("""
//            select p from Property p
//                    where p.user.tinNumber = :tin
//            """)
//    Optional<List<Property>> findByTin(Long tin);

    Optional<List<Property>> findByUserId(Long userId);


    @Query("""
            select p from Property p
                    where p.propertyType = :propertyType
            """)
    Optional<List<Property>> findByPropertyType(String propertyType);

    @Query("""
            select p from Property p
                    where p.yearOfConstruction >= :yearFrom and p.yearOfConstruction <= :yearTo
            """)
    Optional<List<Property>> findByConstructionYearRange(int yearFrom, int yearTo);
}