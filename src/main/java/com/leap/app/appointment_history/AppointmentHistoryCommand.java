package com.leap.app.appointment_history;

import org.springframework.http.ResponseEntity;

public interface  AppointmentHistoryCommand<I,O> {
    public ResponseEntity<O> execute(I input);
}
