package com.leap.app.appointment.AppointmentServise;

import com.leap.app.appointment.AppointmentTable;
import com.leap.app.appointment_history.AppointmentHistoryTable;

import lombok.Getter;

@Getter
public class UpdateAppointmentCommand {
    
    private int appointmentID;
    private AppointmentTable appointmentTable;

    public UpdateAppointmentCommand(
        int appointmentID,
        AppointmentTable appointmentTable
    ){
        this.appointmentID=appointmentID;
        this.appointmentTable=appointmentTable;
    }
}
