package com.sapo.ex7_RestfullAPI_Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapo.ex7_RestfullAPI_Spring.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer>{
	List<InventoryEntity> findByInventoryNameLike(String name);
	
	
}
