package com.leap.app.appointment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leap.app.appointment.AppointmentServise.DeleteAppointment;
import com.leap.app.appointment.AppointmentServise.GetAllAppointments;
import com.leap.app.appointment.AppointmentServise.InsertAppointment;
import com.leap.app.appointment.AppointmentServise.UpdateAppointment;
import com.leap.app.appointment.AppointmentServise.UpdateAppointmentCommand;

import java.applet.Applet;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final InsertAppointment insertAppointment;
    private final UpdateAppointment updateAppointment;
    private final GetAllAppointments getAllAppointments;

    private final DeleteAppointment deleteAppointment;
    public AppointmentController(
        InsertAppointment insertAppointment,
        UpdateAppointment updateAppointment,
        GetAllAppointments getAllAppointments,
        DeleteAppointment deleteAppointment
    ){
        this.getAllAppointments=getAllAppointments;
        this.insertAppointment=insertAppointment;
        this.updateAppointment=updateAppointment;
        this.deleteAppointment=deleteAppointment;
    }
    

    @GetMapping("/getAll")

    public ResponseEntity<List<AppointmentDTO>> getAll() {
        return getAllAppointments.execute(null);
    }

    @PostMapping("/insert")
    public ResponseEntity<AppointmentDTO> postMethodName(@RequestBody AppointmentTable entity) {
        
        return insertAppointment.execute(entity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentDTO> putMethodName(@PathVariable int id, @RequestBody AppointmentTable entity) {
       
        
        return updateAppointment.execute(new UpdateAppointmentCommand(id, entity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteing(@PathVariable Integer id){
        return deleteAppointment.execute(id);
    }

    
    
}
