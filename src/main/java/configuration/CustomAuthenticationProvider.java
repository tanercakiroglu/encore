package configuration;

import com.encore.entities.Token;
import com.encore.services.TokenService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;


import java.util.Date;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private JWSVerifier verifier;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean supports(Class<?> authentication) {
        return configuration.JWTToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication) {

        configuration.JWTToken jwtToken = (configuration.JWTToken) authentication;
        JWT jwt = jwtToken.getJwt();
        JWTClaimsSet claims = jwtToken.getClaims();

        Token token = tokenService.getTokenByUuid(claims.getJWTID());
        if (token != null) {
            try {
                this.verifier = new MACVerifier(token.getSecretKey());
            } catch (JOSEException e) {
                throw new BadCredentialsException("Invalid Token");
            }
            checkJWTTypeAndVerify(jwt);

            Date referenceTime = new Date();

            checkTokenExpiration(claims, referenceTime);
            checkTokenExpirationFromDb(token, referenceTime);
            checkTokenSubjectFromDb(token,claims);
            checkNotBeforeTime(claims, referenceTime);
            checkIssuer(claims);

            jwtToken.setAuthenticated(true);
            return jwtToken;
        }else{
            throw new BadCredentialsException("Invalid Token");
        }
    }

    private void checkTokenSubjectFromDb(Token token, JWTClaimsSet claims) {
        String subject = claims.getSubject();
        if(!token.getUserEmail().equals(subject)){
            throw new BadCredentialsException("User-Token is not matched");
        }
    }

    private void checkTokenExpirationFromDb(Token token, Date referenceTime) {
        Date expirationTime = token.getExpireDate();
        if (expirationTime == null || expirationTime.before(referenceTime)) {
            throw new BadCredentialsException("The token is expired");
        }
    }

    private void checkIssuer(JWTClaimsSet claims) {
        String issuerReference = "encore.com.tr";
        String issuer = claims.getIssuer();
        if (!issuerReference.equals(issuer)) {
            throw new BadCredentialsException("Invalid issuer");
        }
    }

    private void checkNotBeforeTime(JWTClaimsSet claims, Date referenceTime) {
        Date notBeforeTime = claims.getNotBeforeTime();
        if (notBeforeTime == null || notBeforeTime.after(referenceTime)) {
            throw new BadCredentialsException("Not before is after sysdate");
        }
    }

    private void checkTokenExpiration(JWTClaimsSet claims, Date referenceTime) {
        Date expirationTime = claims.getExpirationTime();
        if (expirationTime == null || expirationTime.before(referenceTime)) {
            throw new BadCredentialsException("The token is expired");
        }
    }

    private void checkJWTTypeAndVerify(JWT jwt) {
        // Check type of the parsed JOSE object
        if (jwt instanceof PlainJWT) {
            handlePlainToken((PlainJWT) jwt);
        } else if (jwt instanceof SignedJWT) {
            handleSignedToken((SignedJWT) jwt);
        } else if (jwt instanceof EncryptedJWT) {
            handleEncryptedToken((EncryptedJWT) jwt);
        } else {
            throw new BadCredentialsException("Undefined Token Type");
        }
    }

    private void handleSignedToken(SignedJWT jwt) {
        try {
            if (!jwt.verify(verifier)) {
                throw new BadCredentialsException("Signature validation failed");
            }
        } catch (JOSEException e) {
            throw new BadCredentialsException("Signature validation failed");
        }
    }

    private void handlePlainToken(PlainJWT jwt) {
        throw new BadCredentialsException(jwt +"Unsecured plain tokens are not supported");
    }

    private void handleEncryptedToken(EncryptedJWT jwt) {
        throw new UnsupportedOperationException(jwt+"Unsupported token type");
    }

}
