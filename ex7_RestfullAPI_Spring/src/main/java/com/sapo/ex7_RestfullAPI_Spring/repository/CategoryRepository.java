package com.sapo.ex7_RestfullAPI_Spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
	  List<CategoryEntity> findByCategoryNameLike(String name);
    
}
