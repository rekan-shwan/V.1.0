package com.leap.app.user;

import org.springframework.web.bind.annotation.RestController;

import com.leap.app.app_security.JwtUtile;
import com.leap.app.user.Service.UserGet;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "*")
public class UserController {
   @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserGet userGet;
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getMethodName() {
        System.out.println("hiiiiiiiiiiiiiiiiiiii");
        return userGet.execute(null);
    }
    @PostMapping("/login")
   public ResponseEntity<String> postMethodName(@RequestBody UserTable entity) {
       UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(entity.getUserName(), entity.getUserPassword());
       Authentication auth = authenticationManager.authenticate(token);
       SecurityContextHolder.getContext().setAuthentication(auth);
       String jwtToken=JwtUtile.generateToken((User)auth.getPrincipal());
       return ResponseEntity.ok().body(jwtToken);
   }
}
