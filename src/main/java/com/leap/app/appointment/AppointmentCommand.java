package com.leap.app.appointment;

import org.springframework.http.ResponseEntity;

public interface AppointmentCommand<I,O> {
    public ResponseEntity<O>execute(I input);
}
