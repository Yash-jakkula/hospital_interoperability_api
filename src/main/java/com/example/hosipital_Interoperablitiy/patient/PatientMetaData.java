package com.example.hosipital_Interoperablitiy.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientMetaData extends CrudRepository<PatientMetaDataSchema,Integer> {
    @Query(value = "select * from patient_meta_data where patient_id = ?1",nativeQuery = true)
    Optional<PatientMetaDataSchema> find_meta_data(String id);
}
