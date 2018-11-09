package com.encore.iservices;

import com.encore.entities.Token;

public interface ITokenService {

    Token getTokenByUuid(String uuid);
    String createAndSaveToken(String userName);
}
