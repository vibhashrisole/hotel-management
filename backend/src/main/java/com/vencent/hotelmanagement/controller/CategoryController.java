package com.vencent.hotelmanagement.controller;


import java.util.*;
import com.vencent.hotelmanagement.service.CategoryService;
import com.vencent.hotelmanagement.entity.Category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/app-hotel-management/category")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("")
	public Category  addData(@RequestBody Category d) {
		return categoryService.saveCategory(d);
	}
	
	@PostMapping("/addall")
	public List<Category> addAll(@RequestBody List<Category> c) {
		return categoryService.saveall(c);
	}
	
	@GetMapping("")
	public List<Category> findAll(){
		return categoryService.getall();
	}
	
	@GetMapping("getById/{id}")
	public Category findCategoryById(@PathVariable int id){
		return categoryService.getDataById(id);
	}
	
	@PutMapping("")
	public Category update(@RequestBody Category d) {
		return categoryService.updateCategory(d);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteCategory(@PathVariable int id){
		return categoryService.deleteCategory(id);
	}
	
}
