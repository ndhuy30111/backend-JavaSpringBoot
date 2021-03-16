package com.springboot.apiwebsite.controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.entity.UploadFileEntity;
import com.springboot.apiwebsite.service.FileStorageService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ImageUploadController {
	 private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);

	    @Autowired
	    private FileStorageService fileStorageService;
	    
	    @PostMapping("/uploadFile")
	    public UploadFileEntity uploadFile(@Valid @RequestParam("file") MultipartFile file,@RequestParam("color") String color) throws JsonMappingException, JsonProcessingException {
	        String fileName = fileStorageService.storeFile(file);
	        ColorEntity colorNew;
			colorNew = new ObjectMapper().readValue(color,ColorEntity.class);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/downloadFile/")
	                .path(fileName)
	                .toUriString();
	        return new UploadFileEntity(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	    
	    }

	    @PostMapping("/uploadMultipleFiles")
	    public List<UploadFileEntity> uploadMultipleFiles(@Valid @RequestParam("files") MultipartFile[] files,@RequestParam("Color") String color) {
	    	
	    	return Arrays.asList(files)
	                .stream()
	                .map(file -> {
						try {
							return uploadFile(file,color);						
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					})
	                .collect(Collectors.toList());
	    }

	    @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	            logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }
	
}
