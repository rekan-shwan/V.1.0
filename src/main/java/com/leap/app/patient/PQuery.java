package com.leap.app.patient;

import org.springframework.http.ResponseEntity;

public interface PQuery<I,O> {

    public ResponseEntity<O> execute(I input);
    
}
