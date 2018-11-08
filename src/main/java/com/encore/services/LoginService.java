package com.encore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.irepos.IUserRepo;
import com.encore.iservices.ILoginService;

@Service
@Transactional
public class LoginService implements ILoginService {

    @Autowired
    IUserRepo userRepo;

    @Override
    public boolean getUserByUsername(String username) {
        return (userRepo.findByUsername(username)!=null);
    }
}
