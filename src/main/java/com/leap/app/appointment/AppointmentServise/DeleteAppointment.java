package com.leap.app.appointment.AppointmentServise;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentCommand;
import com.leap.app.appointment.AppointmentRepository;


@Service
public class DeleteAppointment implements AppointmentCommand<Integer,Void> {

    private final AppointmentRepository appointmentRepository;
    public DeleteAppointment(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        if (appointmentRepository.existsById(input)) {
            appointmentRepository.deleteById(input);
            return ResponseEntity.noContent().build();
        }
      
        return ResponseEntity.badRequest().build();
    }
    
}
