package com.example.hosipital_Interoperablitiy.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Patient extends CrudRepository<PatientSchema,Integer> {
    @Query(value = "select * from patient_schema where id = ?1", nativeQuery = true)
    Optional<PatientSchema> patient_meta_data(String id);


}
