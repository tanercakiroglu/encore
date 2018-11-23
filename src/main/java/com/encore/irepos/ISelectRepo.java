package com.encore.irepos;

import com.encore.entities.SelectOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISelectRepo extends JpaRepository<SelectOption,Long> {
}