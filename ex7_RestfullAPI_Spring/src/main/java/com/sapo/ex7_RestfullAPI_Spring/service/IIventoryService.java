package com.sapo.ex7_RestfullAPI_Spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sapo.ex7_RestfullAPI_Spring.dto.InventoryDTO;

public interface IIventoryService {
    List<InventoryDTO> findAll();
    List<InventoryDTO> findAll(Pageable pageable);

    InventoryDTO findById(Integer id);

    int totalItem();

    List<InventoryDTO> findByNameLike(String name);

    InventoryDTO save(InventoryDTO model);

    void delete(int[] ids);
}
