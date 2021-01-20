package com.sapo.ex7_RestfullAPI_Spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.ex7_RestfullAPI_Spring.api.output.ProductOutput;
import com.sapo.ex7_RestfullAPI_Spring.dto.ProductDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;
import com.sapo.ex7_RestfullAPI_Spring.service.IProductService;
import com.sapo.ex7_RestfullAPI_Spring.util.InvalidData;

@RestController
@RequestMapping("/admin")
public class ProductAPI {
	@Autowired
	IProductService productService;

	// api hien thi tất cả sản phẩm phân trang và lọc theo tên
	@GetMapping(value = "/products")
	public ResponseEntity<ProductOutput> showProduct(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "name", defaultValue = "NONE") String name) {
		ProductOutput result = new ProductOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit);
			result.setListResult(productService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (productService.totalItem()) / limit));
		} else if (!name.equals("NONE")) {
			result.setListResult(productService.findByNameLike("%" + name + "%"));
		} else {
			result.setListResult(productService.findAll());
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// api thêm mới 1 sản phẩm

	@PostMapping(value = "/products")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO model) {
		ProductDTO product = productService.save(model);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	// api sửa sản phẩm

	@PutMapping(value = "/products/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO model, @PathVariable("id") Integer id) {
		model.setId(id);
		ProductDTO product = productService.save(model);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	// api lọc theo id sản phẩm

	@GetMapping(value = "/products/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Integer id) {
		ProductDTO product = productService.findById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	
}
