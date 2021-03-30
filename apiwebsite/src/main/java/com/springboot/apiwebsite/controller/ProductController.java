package com.springboot.apiwebsite.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.entity.SizeEntity;
import com.springboot.apiwebsite.entity.UploadFileEntity;
import com.springboot.apiwebsite.exception.BadRequestEx;
import com.springboot.apiwebsite.exception.ProductEx;
import com.springboot.apiwebsite.service.CategoryService;
import com.springboot.apiwebsite.service.ColorService;
import com.springboot.apiwebsite.service.FileStorageService;
import com.springboot.apiwebsite.service.ProductService;
import com.springboot.apiwebsite.service.SizeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
public class ProductController {
	@Autowired
	FileStorageService fileStorageService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/{url}")
	public ResponseEntity<?> findByUrl(@PathVariable String url) {
		return new ResponseEntity<>(productService.findtByUrlOne(url), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAll(@Valid @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		return new ResponseEntity<>(productService.findPage(page, size), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ProductEntity productEntity, @PathVariable("id") Long id)
			throws ProductEx {
		{
			return new ResponseEntity<>(productService.save(productEntity), HttpStatus.OK);
		}
	}

	@PostMapping
	@Transactional(rollbackFor = BadRequestEx.class)
	public ResponseEntity<?> save(@RequestParam(value = "product") String product,
			@RequestParam(name = "file", required = true) MultipartFile[] file)
			throws Exception, ValidationException, ValidationException ,BadRequestEx{
		try {
		
			ProductEntity productEntity = new ObjectMapper().readValue(product, ProductEntity.class);
			ProductEntity productFind = productService.findOneByName(productEntity.getName());
			if(productFind==null) {
				ProductEntity productnew = productService.save(productEntity);
				try {
					for (ColorEntity itemColor : productnew.getColor()) {
						itemColor.setProduct(productnew);
						ColorEntity colorNew = colorService.save(itemColor);
						for (SizeEntity itemSize : colorNew.getSize()) {
							itemSize.setColor(colorNew);
							sizeService.save(itemSize);
						}
						try {
							for (MultipartFile itemFile : file) {
								if(itemFile==null) {
									return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
								}
								UploadFileEntity fileEntity1 = fileStorageService
										.findByIdOne(itemFile.getOriginalFilename());
								if (itemColor.getImage().indexOf(fileEntity1) > -1) {
									String fileName = fileStorageService.storeFile(itemFile);
									fileEntity1.setFileType(itemFile.getContentType());
									fileEntity1.setSize(itemFile.getSize());
									fileEntity1.setFileName(fileName);
									String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
											.path("/api/downloadFile/").path(fileName).toUriString();
									fileEntity1.setFileDownloadUri(fileDownloadUri);
									fileStorageService.save(fileEntity1);
								}
							}
						} catch (BadRequestEx ex) {
							return new ResponseEntity<>(new BadRequestEx("Lỗi File hình ảnh"), HttpStatus.BAD_REQUEST);
						}
					}
				} catch (BadRequestEx ex) {
					return new ResponseEntity<>(new BadRequestEx("Lỗi Màu sắc"), HttpStatus.BAD_REQUEST);
				}
				try {
					for (CategoryEntity categoryItem : productEntity.getCategory()) {
						CategoryEntity categoryFind = categoryService.findByIdOne(categoryItem.getId());
						if (categoryFind != null) {
							categoryFind.getProduct().add(productnew);
						}
						categoryService.save(categoryFind);
					}
			}
				catch(BadRequestEx ex) {

					return new ResponseEntity<>(new BadRequestEx("Lỗi Danh mục"), HttpStatus.BAD_REQUEST);
				}
				
				return new ResponseEntity<>(productnew, HttpStatus.CREATED);
			}
		} catch (BadRequestEx e) {
			return new ResponseEntity<>(new BadRequestEx("Lỗi không thể thêm sản phẩm"), HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(new BadRequestEx("Trùng tên sản phẩm"),HttpStatus.BAD_REQUEST);
	}

}
