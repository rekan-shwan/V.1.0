package com.leap.app.patient.p_servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentRepository;
import com.leap.app.appointment_history.AppointmentHistoryRepository;
import com.leap.app.patient.PCommand;
import com.leap.app.patient.PRepository;

@Service
public class DeletePatient implements PCommand<Integer,Void> {
     @Autowired
    AppointmentHistoryRepository appointmentHistoryRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    private final PRepository patientRepository;
    public DeletePatient(PRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        if (patientRepository.existsById(input)) {
            
            patientRepository.deleteById(input);
            return ResponseEntity.noContent().build();
        }
      
        return ResponseEntity.badRequest().build();
    }
    
}
