package com.example.hosipital_Interoperablitiy.patient;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_meta_data")
public class PatientMetaDataSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String doctor;
    int bp,sugar,cholostral,diabetes;
    String patient_id;
    public String getId(String id){
        return id;
    }
    public String getDoctor(String doctor){
        return doctor;
    }
    public int getBp(int bp){
        return bp;
    }

    public int getSugar(int sugar){
        return sugar;
    }

    public int getCholostral(int cholostral){
        return cholostral;
    }

    public String getPatient_id(String patient_id){
        return patient_id;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    public void setBp(int bp){
        this.bp = bp;
    }
    public void setPatient_id(String patient_id){
        this.patient_id = patient_id;
    }
    public void setSugar(int sugar){
        this.sugar = sugar;
    }
    public void setCholostral(int cholostral){
        this.cholostral = cholostral;
    }
    public void setDiabetes(int diabetes){
        this.diabetes = diabetes;
    }
}
