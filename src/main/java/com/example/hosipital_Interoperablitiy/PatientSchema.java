package com.example.hosipital_Interoperablitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phone;
    private String problem;
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setProblem(String problem){
        this.problem = problem;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }

    public String getProblem() {
        return problem;
    }
}
