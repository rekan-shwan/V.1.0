package com.leap.app.appointment_history.appointment_history_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentCommand;
import com.leap.app.appointment_history.AppointmentHistoryDTO;
import com.leap.app.appointment_history.AppointmentHistoryRepository;
import com.leap.app.appointment_history.AppointmentHistoryTable;

@Service
public class UpdateHistoryService implements AppointmentCommand<UpdateHistoryAppointmentCommand,AppointmentHistoryDTO> {

    @Autowired
    AppointmentHistoryRepository appointmentHistoryRepository;
    @Override
    public ResponseEntity<AppointmentHistoryDTO> execute(UpdateHistoryAppointmentCommand entity) {
        Optional<AppointmentHistoryTable> optional = appointmentHistoryRepository.findById(entity.getAppintment_history_ID());
        if (optional.isPresent()) {
            AppointmentHistoryTable appointmentHistoryTable = entity.appointmentHistoryTable;
            appointmentHistoryTable.setAppintmentHistoryID(entity.appintment_history_ID);
            appointmentHistoryRepository.save(appointmentHistoryTable);
            return ResponseEntity.ok().body(new AppointmentHistoryDTO(appointmentHistoryTable));
        }
        return ResponseEntity.badRequest().build();

    }
   
    
}
