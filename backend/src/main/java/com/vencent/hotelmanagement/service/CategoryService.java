package com.vencent.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vencent.hotelmanagement.repository.CategoryRepository;
import com.vencent.hotelmanagement.entity.Category;
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category saveCategory( Category d) {
		return categoryRepo.save(d);
	}
	
	public List<Category> saveall(List<Category> d) {
		return categoryRepo.saveAll(d);
	}
	
	
	public List<Category> getall(){
		return categoryRepo.findAll();
	}
	
	public Category getDataById(int id){
		return categoryRepo.findById(id).orElse(null);
	}
	
	public String deleteCategory(int id) {
		categoryRepo.deleteById(id);
		return "Category Deleted with ID: "+id;
	}
	
	public Category updateCategory(Category d) {
		Category existingCat=categoryRepo.findById(d.getCategoryId()).orElse(null);
		existingCat.setCategoryType(d.getCategoryType());
		return categoryRepo.save(existingCat);
	}
	
}
