package com.bookstore.service;

import com.bookstore.domain.Users;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;

import java.util.Set;

/**
 * Created by reddevil on 3/7/2017.
 */
public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final Users user, final String token);

    public Users findByUsername(String username);
    public Users findByEmail(String email);
    Users createUser(Users users, Set<UserRole> userRoles) throws Exception;
}
