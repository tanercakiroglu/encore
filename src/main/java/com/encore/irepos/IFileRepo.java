package com.encore.irepos;

import com.encore.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFileRepo extends JpaRepository<File,Long> {
}
