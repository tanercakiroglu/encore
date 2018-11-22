package configuration;

import com.encore.entities.Employee;
import com.encore.entities.User;
import com.encore.entities.UserRole;
import com.encore.irepos.IUserRoleRepo;
import com.encore.services.EmployeeService;
import com.encore.services.LoginService;
import com.encore.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User userDb = loginService.getUserByUsernameAndPassword(username, password);
        if (userDb != null) {
            UserRole role = userRoleService.findByUsername(userDb.getUsername());
            if (role != null) {
                String[] splitRoles = role.getRole().split(",");
                Collection<SimpleGrantedAuthority> grantedAuth = new ArrayList<>();
                for (String item : splitRoles) {
                    grantedAuth.add(new SimpleGrantedAuthority(item));
                }
                Employee employee = employeeService.getEmployeeByEmail(username);
                if (employee != null)
                    return new UsernamePasswordAuthenticationToken(employee, password, grantedAuth);
                else {
                    throw new BadCredentialsException("Bad Credentials");
                }
            } else {
                throw new BadCredentialsException("Bad Credentials");
            }
        }
        throw new BadCredentialsException("Bad Credential");
    }
}
