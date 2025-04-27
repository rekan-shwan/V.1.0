package com.leap.app.patient;

import java.util.List;

import com.leap.app.appointment.AppointmentTable;
import com.leap.app.appointment_history.AppointmentHistoryTable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "patient") 
public class PTable {
    
    @Id
    @Column(name = "patient_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    @Column(name = "patient_name")
    private String pName;

    @Column(name = "patient_second_name")
    private String pSecondName;
    

    @Column(name = "patient_phone")
    private String pPhone;

    @Column(name = "patient_location")
    private String pLocation;

    @Column(name = "patient_note",columnDefinition = "LONGTEXT")
    private String pNote;

    @Column(name = "patient_gender")
    private String pGender;

    @Column(name = "patient_diseas")
    private String pDisease;
    
    @Column(name = "patient_age")
    private String pAge;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_ID",updatable = false, insertable = false)
    private List<AppointmentTable> nextAppointment;

    @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @JoinColumn(name = "patient_ID",updatable = false, insertable = false)
    private List<AppointmentHistoryTable> historyAppointment;

    @Column(name="skin_type")
    private String skinType;

    @Column(name="allergies")
    private String allergies;
}


// private int pId;

//     private String pName;
    
//     private String pEmail;

//     private String pPhone;

//     private String pLocation;

//     private String pNote;

//     private String pGender;

//     private String pDisease;
    
//     private String pAge;