package com.bae.universalapp.security;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.persistence.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * AppUserDetailsService
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
 
    @Override
    public UserDetails loadUserByUsername(String email) {
        
        User user = userRepo.findUserByEmail(email);
        
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new AppUserDetails(user);
    }

    
}