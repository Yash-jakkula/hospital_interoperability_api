package com.example.hosipital_Interoperablitiy.patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);
    private final Patient patient;

    private PatientController(Patient patient) {
        this.patient = patient;
    }

    @PostMapping("/addpatient")
    private ResponseEntity<String> addPatient(@RequestBody PatientSchema patientData){
        patient.save(patientData);
        return ResponseEntity.ok("user saved");
    }

    @GetMapping("/getpatient/{id}")
    private ResponseEntity<Optional<PatientSchema>> getPatient(@PathVariable Integer id){
        Optional<PatientSchema> patientInfo = patient.findById(id);
        if (patientInfo.isPresent()) {
            return ResponseEntity.ok(patientInfo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getallpatient")
    private ResponseEntity<Iterable<PatientSchema>>  getAllPatients(){
        Iterable<PatientSchema> patients = patient.findAll();
        return ResponseEntity.ok(patients);
    }

    @PutMapping("/removepatient/{id}")
    private ResponseEntity<Boolean> removePatient(@PathVariable Integer id){
        patient.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update/{id}")
    private ResponseEntity<Boolean> updatePatient(@RequestBody PatientSchema patientData){
        patient.save(patientData);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/removeallpatient")
    private ResponseEntity<Boolean> removeAllPatient(){
        patient.deleteAll();
        return ResponseEntity.ok(true);
    }

//    public String longestPalindrome() {
//        String s = "abababscceadfkaskdfjakkkkkkkreeefadfase";
//        StringBuilder sb = new StringBuilder(s);
//        if(s.equals(sb.reverse().toString())) return s;
//        if(s.length() == 1) return s;
//        int len = s.length()-1;
//        String s2="";
//        for(int k=len-1;k>0;k--){
//            for(int i=0;i+k<=len;i++){
//                s2 = s.substring(i,i+k+1);
//                StringBuilder check = new StringBuilder(s2);
//                if(s2.equals(check.reverse().toString())){
//                    if(!s2.equals(""))
//                        return s2;
//                }
//            }
//        }
//        return Character.toString(s.charAt(0));
//    }
//    public String longestPalindrome() {
//        String s = "abababscceadfkaskdfjakkkkkkkreeefadfase";
//
//        StringBuilder sb = new StringBuilder(s);
//        if(s.equals(sb.reverse().toString())) return s;
//        if(s.length() == 1) return s;
//        int k = s.length()-1;
//        String s2="";
//        for(int i=k;i>=0;i--){
//            for(int j=0;j<s.length();j++){
//                for(int l=j+i;l<=s.length();l++){
//                    s2 = s.substring(j,l);
//                    StringBuilder check = new StringBuilder(s2);
//                    if(s2.equals(check.reverse().toString())){
//                        if(!s2.equals(""))
//                            return s2;
//                    }
//                }
//            }
//        }
//        return Character.toString(s.charAt(0));
//    }

}


