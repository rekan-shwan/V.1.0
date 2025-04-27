package com.leap.app.patient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leap.app.appointment.AppointmentRepository;
import com.leap.app.appointment_history.AppointmentHistoryRepository;
import com.leap.app.patient.p_servise.DeletePatient;
import com.leap.app.patient.p_servise.GetAllPatients;
import com.leap.app.patient.p_servise.GetPatientByDate;
import com.leap.app.patient.p_servise.InsertPatient;
import com.leap.app.patient.p_servise.SearchByName;
import com.leap.app.patient.p_servise.SearchByPhoneNumber;
import com.leap.app.patient.p_servise.UpdatePatient;
import com.leap.app.patient.p_servise.UpdatePatientCommand;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






@RestController
@RequestMapping("/patients")

public class PController {

   
    private final GetAllPatients getAllPatients;
    private final SearchByName searchByName;
    private final SearchByPhoneNumber searchByPhoneNumber;
    private final UpdatePatient updatePatient;
    private final InsertPatient insertPatient;
    private final GetPatientByDate getPatientByDate;
    // private final DeletePatient deletePatient;

    @Autowired
    DeletePatient deletePatient;

    @Autowired 
    PRepository PRepository;

   

    public PController(
                        GetAllPatients getAllPatients,
                        SearchByName searchByName,
                        SearchByPhoneNumber searchByPhoneNumber,
                        UpdatePatient updatePatient,
                        InsertPatient insertPatient,
                        
                        GetPatientByDate getPatientByDate
                        ){
        this.getAllPatients=getAllPatients;
        this.insertPatient=insertPatient;
        this.searchByName=searchByName;
        this.searchByPhoneNumber=searchByPhoneNumber;
        this.updatePatient=updatePatient;
        this.getPatientByDate=getPatientByDate;
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<PDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(PRepository.findById(id).map(PDTO::new).orElse(null));
    }

    @GetMapping("/getAll")
  
    public ResponseEntity<List<PDTO>> getPatients() {
        return getAllPatients.execute(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return deletePatient.execute(id);
    }

    @GetMapping("/getByDate")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PDTO>> getMethodName() {
        return getPatientByDate.execute(null);
    }
    

    @GetMapping("/searchName")
    public ResponseEntity<List<PDTO>> getByName(@RequestParam String param) {
        return searchByName.execute(param);
    }

    @GetMapping("/searchPhone")
    public ResponseEntity<PDTO> searchByPhone(@RequestParam String param) {
        return searchByPhoneNumber.execute(param);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PDTO> update(@PathVariable int id, @RequestBody PTable entity) {
        return updatePatient.execute(new UpdatePatientCommand(id, entity));
    }

    @PostMapping("/insert")
    public ResponseEntity<PDTO> insert(@RequestBody PTable entity) {
        return insertPatient.execute(entity);
    }
    
}
