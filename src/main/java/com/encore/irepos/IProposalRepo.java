package com.encore.irepos;

import com.encore.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProposalRepo extends JpaRepository<Proposal,Long> {
}
