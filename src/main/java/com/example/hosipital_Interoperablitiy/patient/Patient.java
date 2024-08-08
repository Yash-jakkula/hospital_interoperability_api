package com.example.hosipital_Interoperablitiy.patient;

import org.springframework.data.repository.CrudRepository;

public interface Patient extends CrudRepository<PatientSchema,Integer> {
}
