package com.tcs.check_in_check_out_system.repository;

import com.tcs.check_in_check_out_system.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {

}
