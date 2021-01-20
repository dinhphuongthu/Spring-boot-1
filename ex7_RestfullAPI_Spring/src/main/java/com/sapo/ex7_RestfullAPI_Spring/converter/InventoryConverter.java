package com.sapo.ex7_RestfullAPI_Spring.converter;

import org.springframework.stereotype.Component;

import com.sapo.ex7_RestfullAPI_Spring.dto.InventoryDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.InventoryEntity;

@Component
public class InventoryConverter implements IConverter<InventoryEntity,InventoryDTO>{

	@Override
	public InventoryEntity toEntity(InventoryDTO dto) {
		InventoryEntity entity = new InventoryEntity();
		entity.setInventoryCode(dto.getInventoryCode());
		entity.setInventoryName(dto.getInventoryName());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}

	@Override
	public InventoryDTO toDTO(InventoryEntity entity) {
		InventoryDTO dto = new InventoryDTO();
		if(entity.getId()>0) {
			dto.setId(entity.getId());
		}
		dto.setInventoryCode(entity.getInventoryCode());
		dto.setInventoryName(entity.getInventoryName());
		dto.setAddress(entity.getAddress());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}

	@Override
	public InventoryEntity toEntity(InventoryEntity entity, InventoryDTO dto) {
		entity.setInventoryCode(dto.getInventoryCode());
		entity.setInventoryName(dto.getInventoryName());
		entity.setAddress(dto.getAddress());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}

	
       
}
