package com.encore.irepos;

import com.encore.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepo extends JpaRepository<Project,Long> {
}
