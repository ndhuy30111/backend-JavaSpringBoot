package com.springboot.apiwebsite.service;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.apiwebsite.config.FileStorageProperties;
import com.springboot.apiwebsite.entity.UploadFileEntity;
import com.springboot.apiwebsite.exception.FileStorageException;
import com.springboot.apiwebsite.exception.MyFileNotFoundException;
import com.springboot.apiwebsite.repository.ImageRepository;
import com.springboot.apiwebsite.service.impl.ImageServiceImpl;


@Service
public class FileStorageService implements ImageServiceImpl{
	private final Path fileStorageLocation ;
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	 public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
        	
        	//  throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

	public String storeFile(MultipartFile file) {
        // Normalize file name 	
		int index = file.getOriginalFilename().lastIndexOf(".");
		String name =  file.getOriginalFilename().substring(index);
        String fileName =UUID.randomUUID()+name;
		
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            byte[] bytes = file.getBytes();
            Files.write(targetLocation, bytes);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource  loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource  resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
      
    }
    public UploadFileEntity save(@Valid UploadFileEntity uploadFileEntity)
    {
    	return imageRepository.save(uploadFileEntity);
    }
    public List<UploadFileEntity> saveAll(List<UploadFileEntity> t)
    {
    	return imageRepository.saveAll(t);
    }

	@Override
	public List<UploadFileEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UploadFileEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadFileEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UploadFileEntity findByIdOne(String id) {
		// TODO Auto-generated method stub
		return imageRepository.findByFileName(id);
	}


	
	


	 

	

}
