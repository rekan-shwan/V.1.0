package com.leap.app.user;

import lombok.Data;

@Data
public class UserDTO {



    private String userName;

    private String userPassword;


    public UserDTO(UserTable userTable) {
     
        this.userName = userTable.getUserName();
        this.userPassword = userTable.getUserPassword();
        
    }

    
    
}
