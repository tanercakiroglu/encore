package com.encore.services;

import com.encore.entities.Proposal;
import com.encore.irepos.IProposalRepo;
import com.encore.iservices.IProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProposalService implements IProposalService {
    @Autowired
    private IProposalRepo proposalRepo;

    @Override
    public List<Proposal> getAllProposal() {
        return proposalRepo.findAll();
    }
}
