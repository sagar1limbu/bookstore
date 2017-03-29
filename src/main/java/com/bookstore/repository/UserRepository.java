package com.bookstore.repository;

import com.bookstore.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by reddevil on 3/6/2017.
 */

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
    Users findByUsername(String username);
    Users findByEmail(String email);
}
