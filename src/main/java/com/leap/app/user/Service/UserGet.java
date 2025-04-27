package com.leap.app.user.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.user.UserDTO;
import com.leap.app.user.UserQuery;
import com.leap.app.user.UserRepo;
import com.leap.app.user.UserTable;

@Service
public class UserGet implements UserQuery<Void,List<UserDTO>> {

    @Autowired
    UserRepo userRepo;

    @Override
    public ResponseEntity<List<UserDTO>> execute(Void input) {
        
        List<UserTable> userTables=userRepo.findAll();
        List<UserDTO> userDTOs=userTables.stream().map(UserDTO::new).collect(Collectors.toList());

        
        return ResponseEntity.ok().body(userDTOs);
    }

    
    
}
