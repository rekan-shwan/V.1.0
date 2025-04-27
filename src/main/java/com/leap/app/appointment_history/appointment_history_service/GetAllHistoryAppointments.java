package com.leap.app.appointment_history.appointment_history_service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment_history.AppointmentHistoryDTO;
import com.leap.app.appointment_history.AppointmentHistoryQuery;
import com.leap.app.appointment_history.AppointmentHistoryRepository;
import com.leap.app.appointment_history.AppointmentHistoryTable;

@Service
public class GetAllHistoryAppointments implements AppointmentHistoryQuery<Void,List<AppointmentHistoryDTO>> {

    final AppointmentHistoryRepository appointmentHistoryRepository;

    public GetAllHistoryAppointments(AppointmentHistoryRepository appointmentHistoryRepository){
        this.appointmentHistoryRepository=appointmentHistoryRepository;
    }

    @Override
    public ResponseEntity<List<AppointmentHistoryDTO>> execute(Void input) {
        List<AppointmentHistoryTable> appointmentHistoryTables=appointmentHistoryRepository.findAll();
        List<AppointmentHistoryDTO> appointmentHistoryDTOs=appointmentHistoryTables.stream().map(AppointmentHistoryDTO::new).collect(Collectors.toList());

    return ResponseEntity.ok().body(appointmentHistoryDTOs);
    }
    
}
