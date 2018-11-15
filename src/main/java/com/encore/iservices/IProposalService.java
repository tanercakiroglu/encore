package com.encore.iservices;

import com.encore.entities.Proposal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface IProposalService {

    List<Proposal> getAllProposal();
}
