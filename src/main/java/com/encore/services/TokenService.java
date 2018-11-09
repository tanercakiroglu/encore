package com.encore.services;

import com.encore.entities.Token;
import com.encore.entities.UserRole;
import com.encore.irepos.ITokenRepo;
import com.encore.irepos.IUserRoleRepo;
import com.encore.iservices.ITokenService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TokenService implements ITokenService {

    @Autowired
    private ITokenRepo tokenRepo;

    @Autowired
    private IUserRoleRepo userRoleRepo;

    @Override
    public Token getTokenByUuid(String uuid) {
        return tokenRepo.findByJwtUuid(uuid);
    }

    @Override
    public String createAndSaveToken(String username) {
        String token = null;
        StringBuilder strbuild =null;
        String secretKey = UUID.randomUUID().toString();
        token = signAndSerializeJWT((createJWT(username)), secretKey);
        if (token != null) {
            strbuild = new StringBuilder();
            strbuild.append("Bearer ");
            strbuild.append(token);
        }else{
            throw new BadCredentialsException("Token could not created");
        }
        return strbuild.toString();
    }

    private JWTClaimsSet createJWT(String username) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 5);
        List<String> roles = new ArrayList<>();

        UserRole role = userRoleRepo.findByUsername(username);
        roles.add(role.getRole());
        return new JWTClaimsSet
                .Builder()
                .subject(username)
                .expirationTime(cal.getTime())
                .claim("roles", roles)
                .issuer("tr.com.anadolusigorta")
                .issueTime(new Date())
                .notBeforeTime(new Date())
                .jwtID(UUID.randomUUID().toString()).build();
    }

    private String signAndSerializeJWT(JWTClaimsSet claimsSet, String secretKey) {

        JWSSigner signer = null;

        try {
            signer = new MACSigner(secretKey);
        } catch (KeyLengthException e1) {
            return null;
        }
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
        try {
            signedJWT.sign(signer);
            tokenRepo.save(new Token(claimsSet.getJWTID(),secretKey,claimsSet.getSubject(),new Date(),claimsSet.getExpirationTime()));
            return signedJWT.serialize();
        } catch (JOSEException e) {
            return null;
        }
    }

}
