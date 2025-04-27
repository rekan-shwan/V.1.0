package com.leap.app.user;

import org.springframework.http.ResponseEntity;

public interface UserQuery<I,O> {
    public ResponseEntity<O> execute(I input);
}
