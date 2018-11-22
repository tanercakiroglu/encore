package com.encore.services;

import com.encore.entities.SelectOption;
import com.encore.irepos.ISelectRepo;
import com.encore.iservices.ISelectOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SelectOptionsService implements ISelectOptionService {

    @Autowired
    private ISelectRepo selectRepo;

    @Override
    public List<SelectOption> getAllSelectOptions() {
        return selectRepo.findAll();
    }
}
