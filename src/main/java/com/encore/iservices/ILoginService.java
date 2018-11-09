package com.encore.iservices;

import com.encore.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ILoginService {
    boolean getUserByUsername(String username);
    User getUserByUsernameAndPassword(String username,String password);
}
