package com.bookstore.repository;

import com.bookstore.domain.Users;
import com.bookstore.domain.security.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

/**
 * Created by reddevil on 3/7/2017.
 */
public interface PasswordResetTokenRepository  extends JpaRepository<PasswordResetToken,Long>{



    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(Users user);

    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);

}
