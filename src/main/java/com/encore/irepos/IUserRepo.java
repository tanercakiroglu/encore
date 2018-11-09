package com.encore.irepos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encore.entities.User;

@Repository
public interface IUserRepo extends JpaRepository<User, String>{
    User findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);
}
