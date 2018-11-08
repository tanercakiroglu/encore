package configuration;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String INTERCEPTOR_PROCESS_URL = "/**";

    protected AuthenticationFilter() {
        super(INTERCEPTOR_PROCESS_URL);
    }


    /**
     * check jwt token
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Authentication authResult = null;
        String stringToken = null;
        try {
            stringToken = request.getHeader("Authorization");
            if (stringToken == null) {
                throw new BadCredentialsException("Authorization header not found");
            }
            String authorizationSchema = "Bearer";
            if (stringToken.indexOf(authorizationSchema) == -1) {
                throw new BadCredentialsException("Authorization schema not found");
            }
            stringToken = stringToken.substring(authorizationSchema.length()).trim();

            authResult = tryParseToken(response, stringToken);
        } catch (AuthenticationException e) {
            SecurityContextHolder.clearContext();
            unsuccessfulAuthentication(request, response, e);
        }
        return authResult;
    }

    private Authentication tryParseToken(HttpServletResponse response, String stringToken) {
        Authentication authResult = null;
        try {
            JWT jwt = JWTParser.parse(stringToken);
            JWTToken token = new JWTToken(jwt);
            authResult = this.getAuthenticationManager().authenticate(token);
            response.addHeader("Authorization", "Bearer " + stringToken);
            SecurityContextHolder.getContext().setAuthentication(authResult);
        } catch (ParseException e) {
            throw new BadCredentialsException("Invalid token");
        }
        return authResult;
    }
}
