package com.leap.app.appointment.AppointmentServise;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentCommand;
import com.leap.app.appointment.AppointmentDTO;
import com.leap.app.appointment.AppointmentRepository;
import com.leap.app.appointment.AppointmentTable;


@Service
public class UpdateAppointment implements AppointmentCommand<UpdateAppointmentCommand,AppointmentDTO> {
    private final AppointmentRepository appointmentRepository;

    public UpdateAppointment(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    @Override
    public ResponseEntity<AppointmentDTO> execute(UpdateAppointmentCommand input) {
        Optional<AppointmentTable> data=appointmentRepository.findById(input.getAppointmentID());
        if (data.isPresent()) {
            AppointmentTable appointmentTable=input.getAppointmentTable();
            appointmentTable.setAppointmentID(input.getAppointmentID());
            appointmentRepository.save(appointmentTable);
            return ResponseEntity.ok().body(new AppointmentDTO(appointmentTable));
        }
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
