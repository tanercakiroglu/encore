package com.encore.iservices;

import com.encore.entities.UserRole;

public interface IUserRoleService {
   UserRole findByUsername(String username);
}
