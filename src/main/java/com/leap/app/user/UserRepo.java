package com.leap.app.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserTable,String> {
    
}
