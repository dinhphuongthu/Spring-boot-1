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

import com.sapo.ex7_RestfullAPI_Spring.api.output.CategoryOutput;
import com.sapo.ex7_RestfullAPI_Spring.dto.CategoryDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
import com.sapo.ex7_RestfullAPI_Spring.service.ICategoryService;
import com.sapo.ex7_RestfullAPI_Spring.util.InvalidData;
import org.springframework.util.StringUtils;


@RestController
@RequestMapping("/admin")
public class CategoryAPI {
    @Autowired
	ICategoryService categoryService;
    

			
  //Hien thi loai sp, phan trang va theo name
    @GetMapping(value = "/categories")
    public ResponseEntity<CategoryOutput> showCategories(@RequestParam(value = "page", required = false) Integer page,
                                                         @RequestParam(value = "limit", required = false) Integer limit,
                                                         @RequestParam(value = "name", defaultValue = "NONE") String name) {
        CategoryOutput result = new CategoryOutput();
        
        if (page != null && limit != null) {
            result.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            result.setTotalPage((int) Math.ceil((double) (categoryService.totalItem()) / limit));
            result.setListResult(categoryService.findAll(pageable));
         
        }
        else if (!name.equals("NONE")) {
            result.setListResult(categoryService.findByNameLike(name));
        }
        else {
            result.setListResult(categoryService.findAll());
        }
       
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	//hiển thị loại sản phẩm theo id
	@GetMapping(value="/categories/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") Integer id){
	    CategoryDTO categoryDTO = categoryService.findById(id);
		return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
	}
	//thêm mới 1 category
	@PostMapping(value = "/categories")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO model) {
        CategoryDTO categoryDTO = categoryService.save(model);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }
	
	//sửa 1 category
	 @PutMapping(value = "/categories/{id}")
	    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO model, @PathVariable("id") Integer id) {
	        CategoryDTO categoryDTO;
	        model.setId(id);
	        categoryDTO = categoryService.save(model);
	        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	    }
    
}
