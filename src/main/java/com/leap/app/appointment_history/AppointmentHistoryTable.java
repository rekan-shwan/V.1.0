package com.leap.app.appointment_history;


import java.time.LocalDate;

import com.leap.app.patient.PTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "appointment_history")
public class AppointmentHistoryTable {
    

    @Id
    @Column(name = "appintment_history_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appintmentHistoryID;

    @Column(name = "patient_ID")
    private int patientID;

    @Column(name = "appointment_history_date")
    private LocalDate appointmentHistoryDate;

    @Column(name = "drug",columnDefinition = "LONGTEXT")
    private String drug;

    @Column(name = "appointment_detail",columnDefinition = "LONGTEXT")
    private String appointmentDetail;

    @Column(name = "is_visited")
    private Boolean isVisited;

    @Column(name = "tratment")
    private String tratment;




    

    

}
