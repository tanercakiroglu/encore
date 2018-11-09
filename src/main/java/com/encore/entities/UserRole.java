package com.encore.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserRole implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    public UserRole() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
