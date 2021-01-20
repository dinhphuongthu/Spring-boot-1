package com.sapo.ex7_RestfullAPI_Spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sapo.ex7_RestfullAPI_Spring.dto.CategoryDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
import com.sapo.ex7_RestfullAPI_Spring.repository.CategoryRepository;
import com.sapo.ex7_RestfullAPI_Spring.util.InvalidData;

public interface ICategoryService {
   // lấy tất cả dữ liệu của category
   List<CategoryDTO> findAll();
   
   //Tìm theo id
   CategoryDTO findById(Integer id) ;
      
   //Lưu model vào category
   CategoryDTO save(CategoryDTO model) ;
   
   //tổng item của category
   int totalItem();
   
   //CategoryDTO update(CategoryDTO model) throws InvalidData;

   List<CategoryDTO> findAll(Pageable page);
   //void delete(int[] ids);
   List<CategoryDTO> findByNameLike(String name);
   
   
	   
   
}
