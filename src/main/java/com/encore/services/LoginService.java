package com.encore.services;

import com.encore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.irepos.IUserRepo;
import com.encore.iservices.ILoginService;

@Service
@Transactional
@Qualifier("jhasd")
public class LoginService implements ILoginService {

    @Autowired
    IUserRepo userRepo;

    @Override
    public boolean getUserByUsername(String username) {
        return (userRepo.findByUsername(username)!=null);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username,password);
    }
}
