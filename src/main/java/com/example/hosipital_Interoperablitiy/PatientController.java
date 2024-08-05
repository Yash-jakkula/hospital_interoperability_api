package com.example.hosipital_Interoperablitiy;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    private Patient patient;
    public PatientController(Patient patient){
        this.patient = patient;
    }
    @PostMapping("/add")
    public @ResponseBody String addPatient(@RequestParam String name, @RequestParam String phone, @RequestParam int id,@RequestParam String problem){
        PatientSchema p1= new PatientSchema();
        p1.setId(id);
        p1.setName(name);
        p1.setPhone(phone);
        p1.setProblem(problem);
        patient.save(p1);
        return "saved";

    }
}
