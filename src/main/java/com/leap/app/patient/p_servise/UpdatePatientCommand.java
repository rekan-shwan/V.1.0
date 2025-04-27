package com.leap.app.patient.p_servise;

import com.leap.app.patient.PTable;

import lombok.Getter;

@Getter
public class UpdatePatientCommand {
    private int patientID;

    private PTable pTable;

    public UpdatePatientCommand(
        int patientID,
        PTable pTable
    ){
        this.pTable=pTable;
        this.patientID=patientID;
    }

}
