package com.encore.services;

import com.encore.entities.UserRole;
import com.encore.irepos.IUserRoleRepo;
import com.encore.iservices.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRoleRepo userRoleRepo;

    @Override
    public UserRole findByUsername(String username) {
        return userRoleRepo.findByUsername(username);
    }
}
