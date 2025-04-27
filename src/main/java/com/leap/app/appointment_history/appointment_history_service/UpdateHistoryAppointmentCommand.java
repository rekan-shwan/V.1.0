package com.leap.app.appointment_history.appointment_history_service;

import com.leap.app.appointment.AppointmentTable;
import com.leap.app.appointment_history.AppointmentHistoryCommand;
import com.leap.app.appointment_history.AppointmentHistoryTable;

import lombok.Getter;

@Getter
public class UpdateHistoryAppointmentCommand {
    AppointmentHistoryTable appointmentHistoryTable;
    int appintment_history_ID;

    public UpdateHistoryAppointmentCommand(AppointmentHistoryTable appointmentHistoryTable,
    int appintment_history_ID){
        this.appintment_history_ID=appintment_history_ID;
        this.appointmentHistoryTable=appointmentHistoryTable;
    }
}
