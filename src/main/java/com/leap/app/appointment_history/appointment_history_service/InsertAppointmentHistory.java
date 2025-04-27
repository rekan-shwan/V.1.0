package com.leap.app.appointment_history.appointment_history_service;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment_history.AppointmentHistoryCommand;
import com.leap.app.appointment_history.AppointmentHistoryDTO;

import com.leap.app.appointment_history.AppointmentHistoryRepository;
import com.leap.app.appointment_history.AppointmentHistoryTable;

@Service
public class InsertAppointmentHistory implements AppointmentHistoryCommand<AppointmentHistoryTable, AppointmentHistoryDTO> {

    private final AppointmentHistoryRepository appointmentHistoryRepository;

    public InsertAppointmentHistory(AppointmentHistoryRepository appointmentHistoryRepository){
        this.appointmentHistoryRepository=appointmentHistoryRepository;
    }

    @Override
    public ResponseEntity<AppointmentHistoryDTO> execute(AppointmentHistoryTable input) {
       AppointmentHistoryTable data=appointmentHistoryRepository.save(input);
       return ResponseEntity.status(HttpStatus.CREATED).body(new AppointmentHistoryDTO (data));
    }
    
}
