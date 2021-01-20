package com.sapo.ex7_RestfullAPI_Spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sapo.ex7_RestfullAPI_Spring.dto.ProductDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;
import com.sapo.ex7_RestfullAPI_Spring.util.InvalidData;

public interface IProductService {
	  //lấy tất cả sản phẩm
	 List<ProductDTO> findAll();

	    List<ProductDTO> findAll(Pageable pageable);

	    ProductDTO findById(Integer id);

	    ProductDTO save(ProductDTO model);

	    int totalItem();

	    List<ProductDTO> findByNameLike(String name);

	    void delete(int[] ids);

	    void delete(int id);

}
