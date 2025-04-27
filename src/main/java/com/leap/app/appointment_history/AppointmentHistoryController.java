package com.leap.app.appointment_history;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leap.app.appointment.AppointmentServise.UpdateAppointmentCommand;
import com.leap.app.appointment_history.appointment_history_service.GetAllHistoryAppointments;
import com.leap.app.appointment_history.appointment_history_service.InsertAppointmentHistory;
import com.leap.app.appointment_history.appointment_history_service.UpdateHistoryAppointmentCommand;
import com.leap.app.appointment_history.appointment_history_service.UpdateHistoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/history-appointment")
public class AppointmentHistoryController {

    @Autowired
    AppointmentHistoryRepository appointmentHistoryRepository;
    
    private GetAllHistoryAppointments getAllHistoryAppointments;
    private InsertAppointmentHistory insertAppointmentHistory;
    private UpdateHistoryService updateHistoryService;

    public AppointmentHistoryController(
        GetAllHistoryAppointments getAllHistoryAppointments,
        InsertAppointmentHistory insertAppointmentHistory,
        UpdateHistoryService updateHistoryService
    ){
        this.getAllHistoryAppointments=getAllHistoryAppointments;
        this.insertAppointmentHistory=insertAppointmentHistory;
        this.updateHistoryService=updateHistoryService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AppointmentHistoryDTO>> getAllAppointment() {
        return getAllHistoryAppointments.execute(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentHistoryDTO> putMethodName(@PathVariable int id, @RequestBody AppointmentHistoryTable entity) {
        
        
        return updateHistoryService.execute(new UpdateHistoryAppointmentCommand(entity, id));
    }

    @PostMapping("/insert")
    public ResponseEntity<AppointmentHistoryDTO> postMethodName(@RequestBody AppointmentHistoryTable entity) {
        
        
        return insertAppointmentHistory.execute(entity);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteMethodName(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteM(@PathVariable int id) {
        appointmentHistoryRepository.deleteAllByPatientID(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
