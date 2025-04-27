package com.leap.app.user;

import org.springframework.http.ResponseEntity;

public interface UserCommand<I,O> {

  public ResponseEntity<O>execute(I input);
} 
