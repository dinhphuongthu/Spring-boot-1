package com.sapo.ex7_RestfullAPI_Spring.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapo.ex7_RestfullAPI_Spring.converter.CategoryConverter;
import com.sapo.ex7_RestfullAPI_Spring.dto.CategoryDTO;
import com.sapo.ex7_RestfullAPI_Spring.dto.ProductDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;
import com.sapo.ex7_RestfullAPI_Spring.repository.CategoryRepository;
import com.sapo.ex7_RestfullAPI_Spring.util.InvalidData;

@Service
public class CategoryService implements ICategoryService{
    @Autowired     
	CategoryRepository categoryRepository;
    @Autowired
    CategoryConverter categoryConverter;    
    //lấy tất cả dữ liệu category
    @Override
    public List<CategoryDTO> findAll(Pageable pageable) {
        List<CategoryDTO> list = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
        for (CategoryEntity item : entities) {
            CategoryDTO categoryDTO = categoryConverter.toDTO(item);
            list.add(categoryDTO);
        }
        return list;
    }
	
    @Override
    public int totalItem() {
        return (int) categoryRepository.count();
    }
	
    @Override
    @Transactional
    public CategoryDTO save(CategoryDTO model) {
        CategoryEntity entity;
        if (model.getId() > 0) {
            CategoryEntity odlCategory = categoryRepository.findById(model.getId()).orElseThrow();
            model.setModifiedDate(new Date(System.currentTimeMillis()));
            model.setCreatedDate(odlCategory.getCreatedDate());
            entity = categoryConverter.toEntity(odlCategory, model);
        } else {
            model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            entity = categoryConverter.toEntity(model);
        }
        entity = categoryRepository.save(entity);
        return categoryConverter.toDTO(entity);
    }

	
	//Tìm category theo id
	@Override
	public CategoryDTO findById(Integer id)  {
		CategoryEntity entity = categoryRepository.findById(id).orElseThrow();
		return categoryConverter.toDTO(entity);
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> list = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity item : entities) {
            CategoryDTO categoryDTO = categoryConverter.toDTO(item);
            list.add(categoryDTO);
        }
        return list;
	}	
	@Override
    public List<CategoryDTO> findByNameLike(String name) {
        List<CategoryDTO> list = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findByCategoryNameLike("%" + name + "%");
        for (CategoryEntity item : entities) {
            CategoryDTO categoryDTO = categoryConverter.toDTO(item);
            list.add(categoryDTO);
        }
        return list;
    }	
	
}
