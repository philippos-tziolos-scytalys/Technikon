package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Property;
import com.scytalys.technikon.dto.PropertyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("""
            select p from Property p
                    where p.pinNumber = :pin
            """)
    PropertyDto findByPin(Long pin);

    @Query("""
            select p from Property p
                    where p.user.tinNumber = :tin
            """)
    Optional<List<PropertyDto>> findByTin(Long tin);

    @Query("""
            select p from Property p
                    where p.propertyType = :property_type
            """)
    Optional<List<PropertyDto>> findByPropertyType(String property_type);

    @Query("""
            select p from Property p
                    where p.yearOfConstruction >= :yearFrom and p.yearOfConstruction <= :yearTo
            """)
    Optional<List<PropertyDto>> findByConstructionYearRange(int yearFrom, int yearTo);
}