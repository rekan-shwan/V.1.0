package com.leap.app.appointment;

import org.springframework.http.ResponseEntity;

public interface AppointmentQuery<I,O> {


    public ResponseEntity<O>execute(I input);
}
