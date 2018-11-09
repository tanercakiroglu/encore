package com.encore.irepos;

import com.encore.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<Token,Long> {

    Token findByJwtUuid(String uuid);
}
