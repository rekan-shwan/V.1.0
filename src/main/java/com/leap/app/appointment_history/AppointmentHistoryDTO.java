package com.leap.app.appointment_history;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AppointmentHistoryDTO {
    private int appintmentHistoryID;

   
    private int patientID;

    private LocalDate appointmentHistoryDate;


    private String drug;

    private String appointmentDetail;

    private Boolean isVisited;

    private String tratment;

    public AppointmentHistoryDTO(
        AppointmentHistoryTable appointmentHistoryTable
    ){
        this.appintmentHistoryID=appointmentHistoryTable.getAppintmentHistoryID();
        this.appointmentHistoryDate=appointmentHistoryTable.getAppointmentHistoryDate();
        this.tratment=appointmentHistoryTable.getTratment();
        this.drug=appointmentHistoryTable.getDrug();
        this.appointmentDetail=appointmentHistoryTable.getAppointmentDetail();
        this.isVisited=appointmentHistoryTable.getIsVisited();
        this.patientID=appointmentHistoryTable.getPatientID();
    }
}
