package com.springboot.apiwebsite.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.repository.CategoryRepository;
import com.springboot.apiwebsite.repository.ProductRepository;
import com.springboot.apiwebsite.service.impl.CategoryServiceImpl;
import com.springboot.apiwebsite.util.SlugUtil;

@Service
public class CategoryService implements CategoryServiceImpl {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<CategoryEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public CategoryEntity save(CategoryEntity t) {
		return categoryRepository.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public CategoryEntity category_prodcut(CategoryEntity t) {
		CategoryEntity categoryFind = categoryRepository.findById(t.getId()).get();
		if (categoryFind != null) {
			for (ProductEntity productItem : t.getProduct()) {
				ProductEntity productFind = productRepository.findById(productItem.getId()).get();
				if (productFind != null) {
					if (categoryFind.getProduct().indexOf(productItem) == -1) {
						categoryFind.getProduct().add(productItem);
					}
				}
				if(productFind!=null) {
				if(categoryFind.getProduct().indexOf(productItem)==-1) {
					categoryFind.getProduct().add(productItem);
				}}
			}
			return categoryRepository.saveAndFlush(categoryFind);
		}

		return null;
	}

	@Override
	public CategoryEntity findByUrlOne(String url) {
		
		return categoryRepository.findOneByUrl(url);
	}

}
