package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.Property;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
>>>>>>> origin/Pavlos

}
