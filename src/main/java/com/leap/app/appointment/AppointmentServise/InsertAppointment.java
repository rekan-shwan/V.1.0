package com.leap.app.appointment.AppointmentServise;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentCommand;
import com.leap.app.appointment.AppointmentDTO;
import com.leap.app.appointment.AppointmentRepository;
import com.leap.app.appointment.AppointmentTable;

@Service
public class InsertAppointment implements AppointmentCommand<AppointmentTable,AppointmentDTO> {

    private final AppointmentRepository appointmentRepository;
    public InsertAppointment(
        AppointmentRepository appointmentRepository
    ){
        this.appointmentRepository=appointmentRepository;
    }
    @Override
    public ResponseEntity<AppointmentDTO> execute(AppointmentTable input) {
        AppointmentTable appointmentTable=appointmentRepository.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AppointmentDTO(appointmentTable));
    }
    
}
