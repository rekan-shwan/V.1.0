package com.leap.app.app_security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.leap.app.user.UserRepo;
import com.leap.app.user.UserTable;

@Service
public class LoadUser implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTable user = userRepo.findById(username).get();
        return User.withUsername(user.getUserName() ).password(user.getUserPassword()).build();
                
    }
}