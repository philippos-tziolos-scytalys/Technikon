package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
