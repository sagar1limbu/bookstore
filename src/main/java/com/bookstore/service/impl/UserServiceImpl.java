package com.bookstore.service.impl;

import com.bookstore.domain.Users;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by reddevil on 3/7/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static Logger LOG = LoggerFactory.getLogger(UserService.class);

    public PasswordResetToken getPasswordResetToken(final String token){
        return passwordResetTokenRepository.findByToken(token);
    }

    public void createPasswordResetTokenForUser(final Users user, final String token){
        final PasswordResetToken myToken = new PasswordResetToken(token,user);
        passwordResetTokenRepository.save(myToken);
    }

    public Users findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Users findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Users createUser(Users users, Set<UserRole> userRoles) throws Exception{
        Users localUser = userRepository.findByUsername(users.getUsername());
        Users userByEmail = userRepository.findByEmail(users.getEmail());
        if(localUser != null){
            LOG.info("user {} already exist" +
                    ". so nothing will be done",users.getUsername());
        }
        else {
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            users.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(users);
        }
        return localUser;
    }

}
