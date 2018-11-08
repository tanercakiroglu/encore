package com.encore.iservices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ILoginService {
    boolean getUserByUsername(String username);
}
