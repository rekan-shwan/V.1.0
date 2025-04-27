package com.leap.app.app_security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.leap.app.user.UserRepo;
import com.leap.app.user.UserTable;

@Configuration
public class DatabaseIn {

    @Bean
    public CommandLineRunner initDatabase(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            UserTable user = new UserTable("123", passwordEncoder.encode("123"));
            userRepo.save(user);
        };
    }
}