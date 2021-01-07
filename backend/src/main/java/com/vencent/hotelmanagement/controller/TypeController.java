package com.vencent.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vencent.hotelmanagement.entity.Type;
import com.vencent.hotelmanagement.service.TypeService;

@RequestMapping("/app-hotel-management/type")
@RestController
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@PostMapping("")
	public Type  addType(@RequestBody Type t) {
		return typeService.saveType(t);
	}
	
	@GetMapping("")
	public List<Type> findAll(){
		return typeService.getall();
	}
	
	@GetMapping("getById/{id}")
	public Type findTypeById(@PathVariable int id){
		return typeService.getAddressById(id);
	}
	
	@PutMapping("")
	public Type update(@RequestBody Type t) {
		return typeService.updateType(t);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteType(@PathVariable int id){
		return typeService.deleteType(id);
	}
}
