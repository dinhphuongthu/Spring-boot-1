package com.sapo.ex7_RestfullAPI_Spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapo.ex7_RestfullAPI_Spring.converter.ProductConverter;
import com.sapo.ex7_RestfullAPI_Spring.dto.ProductDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
import com.sapo.ex7_RestfullAPI_Spring.entity.InventoryEntity;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;
import com.sapo.ex7_RestfullAPI_Spring.repository.CategoryRepository;
import com.sapo.ex7_RestfullAPI_Spring.repository.ProductRepository;
import com.sapo.ex7_RestfullAPI_Spring.util.InvalidData;
@Service
public class ProductService implements IProductService {
     @Autowired
	 ProductRepository productRepository;
	 @Autowired
	 ProductConverter productConverter;
	 @Autowired
	 CategoryRepository categoryRepository;
//	public ProductService(ProductRepository productRepository) {
//		this.productRepository=productRepository;
//	}
	//lấy tất cả sản phẩm
	
     @Override
     public List<ProductDTO> findAll() {
         List<ProductDTO> list = new ArrayList<>();
         ProductDTO productDTO;
         List<ProductEntity> entities = productRepository.findAll();
         for (ProductEntity item : entities) {
             productDTO = productConverter.toDTO(item);
             productDTO.setCategory(item.getCategoryId());
             productDTO.setInventory(item.getInventoryId());
             list.add(productDTO);
         }
         return list;
     }
   //tong so san pham trong tb
     @Override
     public int totalItem() {
         return (int) productRepository.count();
     }
   //lấy sản phẩm theo id
     @Override
     public ProductDTO findById(Integer id) {
         ProductEntity entity = productRepository.findById(id).orElseThrow();
         ProductDTO productDTO = productConverter.toDTO(entity);
//         productDTO.setCategory(entity.getCategoryId());
//         productDTO.setInventory(entity.getInventoryId());
         return productDTO;
     }
   
	     @Override
	     public void delete(int[] ids) {
	         for (int id : ids) {
	             productRepository.deleteById(id);
	         }
	     }
	
	     @Override
	     public void delete(int id) {
	         productRepository.deleteById(id);
	     }
	    //hiển thị sản phẩm có phân trang
		@Override
		public List<ProductDTO> findAll(Pageable pageable) {
			List<ProductDTO> list = new ArrayList<>();
	        ProductDTO productDTO;
	        List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
	        for (ProductEntity item : entities) {
	            productDTO = productConverter.toDTO(item);
	            productDTO.setCategory(item.getCategoryId());
	            productDTO.setInventory(item.getInventoryId());
	            list.add(productDTO);
	        }
	        return list;
		
		}
		//thêm, sửa sản phẩm
		
		@Override
		public ProductDTO save(ProductDTO model) {
			ProductEntity entity;
	        if (model.getId() > 0) {
	            ProductEntity odlProduct = productRepository.findById(model.getId()).orElseThrow();
	            model.setModifiedDate(new Date(System.currentTimeMillis()));
	            model.setCreatedDate(odlProduct.getCreatedDate());
	            entity = productConverter.toEntity(odlProduct, model);
	        } else {
	            model.setCreatedDate(new Date(System.currentTimeMillis()));
	            entity = productConverter.toEntity(model);
	        }
//	        CategoryEntity categoryEntity = categoryRepository.getOne(model.getCategory());
//	        InventoryEntity inventoryEntity = inventoryRepository.getOne(model.getInventoryId());
//	        entity.setCategory(categoryEntity);
//	        entity.setInventory(inventoryEntity);
	        entity = productRepository.save(entity);
	        return productConverter.toDTO(entity);
		}
		
		//tìm kiếm theo tên		
		@Override
		public List<ProductDTO> findByNameLike(String name) {
			List<ProductDTO> list = new ArrayList<>();
			ProductDTO productDTO;
			List<ProductEntity> entities = productRepository.findByProductNameLike(name);
			for(ProductEntity item:entities) {
				productDTO = productConverter.toDTO(item);
				productDTO.setCategory(item.getCategoryId());
				productDTO.setInventory(item.getInventoryId());
			    list.add(productDTO);
			}
			return list;
		}
        
     
}
