package com.encore.irepos;

import com.encore.entities.UserRole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jhasdsad")
public interface IUserRoleRepo extends JpaRepository<UserRole,Long> {
      UserRole findByUsername(String username);
}
