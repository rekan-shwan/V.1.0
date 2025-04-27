package com.leap.app.appointment;

import java.sql.Date;

import lombok.Data;

@Data
public class AppointmentDTO {
    
    private int appointmentID;
    
    private int patientID;

    private Date appointmentDate;
    

    public AppointmentDTO(AppointmentTable appointmentTable){
        this.appointmentID=appointmentTable.getAppointmentID();
        this.patientID=appointmentTable.getPatientID();
        this.appointmentDate=appointmentTable.getAppointmentDate();
    }
}
