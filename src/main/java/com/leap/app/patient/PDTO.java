package com.leap.app.patient;

import java.util.List;

import com.leap.app.appointment.AppointmentTable;
import com.leap.app.appointment_history.AppointmentHistoryTable;

import lombok.Data;

@Data
public class PDTO {

    private int pId;

    private String pName;
    
    // private String pEmail;

    private String pPhone;

    private String pLocation;

    private String pNote;

    private String pGender;

    private String pDisease;
    
    private String pAge;

    private String allergies;

    private String skintype;
    private String pSecondName;

    private List<AppointmentTable> nextAppointment;

    private List<AppointmentHistoryTable> historyAppointment;

    public PDTO(PTable pTable){
        this.pId=pTable.getPId();
        this.pName=pTable.getPName();
        // this.pEmail=pTable.getPEmail();
        this.skintype=pTable.getSkinType();
        this.allergies=pTable.getAllergies();
        this.pPhone=pTable.getPPhone();
        this.pLocation=pTable.getPLocation();
        this.pNote=pTable.getPNote();
        this.pSecondName=pTable.getPSecondName();
        this.pGender=pTable.getPGender();
        this.pDisease=pTable.getPDisease();
        this.pAge=pTable.getPAge();
        this.nextAppointment=pTable.getNextAppointment();
        this.historyAppointment=pTable.getHistoryAppointment();
    }

}
