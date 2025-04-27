package com.leap.app.appointment_history.appointment_history_service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentCommand;
import com.leap.app.appointment_history.AppointmentHistoryRepository;




@Service
public class DeleteHistoryAppointment implements AppointmentCommand<Integer,Void> {
    
    private final AppointmentHistoryRepository historyAppointmentRepository;

    public DeleteHistoryAppointment(AppointmentHistoryRepository historyAppointmentRepository) {
        this.historyAppointmentRepository = historyAppointmentRepository;
    }

    

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        if (historyAppointmentRepository.existsById(input)) {
            historyAppointmentRepository.deleteById(input);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
        
    }
    
}
