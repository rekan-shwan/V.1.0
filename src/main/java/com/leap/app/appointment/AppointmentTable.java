package com.leap.app.appointment;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "appointment")
public class AppointmentTable {
    

    @Id
    @Column(name = "appointment_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentID;
    
    @Column(name = "patient_ID")
    private int patientID;

    @Column(name = "appointment_date")
    private Date appointmentDate;

    

    

}


//     public int appointmentID;
    
//     public int patientID;

//     public Date appointmentDate;