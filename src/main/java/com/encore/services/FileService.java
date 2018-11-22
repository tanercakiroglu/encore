package com.encore.services;

import com.encore.entities.File;
import com.encore.irepos.IFileRepo;
import com.encore.iservices.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@Transactional
public class FileService implements IFileService {

    @Autowired
    private IFileRepo fileRepo;
    @Override
    public boolean saveFile(File file) {
        File savedFile = fileRepo.save(file);
        return true;
    }

    @Override
    public File getFileById(String id) {
        Optional<File> file = fileRepo.findById(Long.valueOf(id));
        return file.get();
    }
}
