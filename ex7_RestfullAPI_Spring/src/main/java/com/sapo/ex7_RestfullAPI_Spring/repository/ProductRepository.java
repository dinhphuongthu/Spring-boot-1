package com.sapo.ex7_RestfullAPI_Spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer>{
	 List<ProductEntity> findByProductNameLike(String name);
	 List<ProductEntity> findByCategoryId(Integer categoryId);
}
