package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

}
