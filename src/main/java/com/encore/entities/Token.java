package com.encore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class  Token implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "JWT_UUID")
    private String jwtUuid;

    @Column(name = "SECRET_KEY")
    private String secretKey;

    @Column(name = "USER_NAME")
    private String userEmail;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "EXPIRED_DATE")
    private Date expireDate;

    public Token() {}

    public Token( String jwtUuid, String secretKey, String userEmail, Date createdDate, Date expireDate) {
        this.jwtUuid = jwtUuid;
        this.secretKey = secretKey;
        this.userEmail = userEmail;
        this.createdDate = createdDate;
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJwtUuid() {
        return jwtUuid;
    }

    public void setJwtUuid(String jwtUuid) {
        this.jwtUuid = jwtUuid;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }



}
