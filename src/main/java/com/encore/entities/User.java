package com.encore.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "enabled")
    int enabled;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
