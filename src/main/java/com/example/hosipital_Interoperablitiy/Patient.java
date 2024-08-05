package com.example.hosipital_Interoperablitiy;

import org.springframework.data.repository.CrudRepository;

public interface Patient extends CrudRepository<PatientSchema,Integer> {
}
