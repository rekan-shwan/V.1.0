package com.leap.app.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "user_table")
@Entity
@Data
public class UserTable {
    public UserTable() {
    }

    public UserTable(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    

    /*
     * private int userID;

    private String userName;

    private String userPassword;

    private String userRole;
     */
    
}
