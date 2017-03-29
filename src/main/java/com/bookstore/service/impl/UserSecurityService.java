package com.bookstore.service.impl;

import com.bookstore.domain.Users;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by reddevil on 3/6/2017.
 */
@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users user = userRepository.findByUsername(username);
        if(null== user){
            throw  new UsernameNotFoundException("Username Not Found");
        }
        return user;
    }

}
