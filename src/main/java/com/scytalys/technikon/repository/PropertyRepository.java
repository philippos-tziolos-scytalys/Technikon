package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
    @Query("""
            select p from Property p
                    where p.pinNumber = :pin
            """)
    Property findByPin(Long pin);

    @Query("""
            select p from Property p
                    where p.ownerTin = :tin
            """)
    Optional<List<Property>> findByTin(Long tin);

    @Query("""
            select p from Property p
                    where p.propertyType = :property_type
            """)
    Optional<List<Property>> findByPropertyType(String property_type);

    @Query("""
            select p from Property p
                    where p.yearOfConstruction >= :yearFrom and p.yearOfConstruction <= :yearTo
            """)
    Optional<List<Property>> findByConstructionYearRange(int yearFrom, int yearTo);
}
