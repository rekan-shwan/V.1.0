package com.leap.app.appointment.AppointmentServise;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.appointment.AppointmentDTO;
import com.leap.app.appointment.AppointmentQuery;
import com.leap.app.appointment.AppointmentRepository;
import com.leap.app.appointment.AppointmentTable;

@Service
public class GetAllAppointments implements  AppointmentQuery<Void,List<AppointmentDTO>> {

    private final AppointmentRepository appointmentRepository;
    public GetAllAppointments(
        AppointmentRepository appointmentRepository
    ){
        this.appointmentRepository=appointmentRepository;
    }

    @Override
    public ResponseEntity<List<AppointmentDTO>> execute(Void input) {
        List<AppointmentTable> list=appointmentRepository.findAll();
        List<AppointmentDTO>list2=list.stream().map(AppointmentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list2);
    }
    
}
