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
import com.vencent.hotelmanagement.entity.MenuCard;
import com.vencent.hotelmanagement.service.MenuCardService;

// This file consist of all the rest api end points
@RequestMapping("/menucard")
@RestController
public class MenuCardController {
	
	@Autowired
	private MenuCardService service;
	
	@PostMapping("")
	public MenuCard addItems(@RequestBody  MenuCard v) {
		return service.saveItems(v);
	}
	
	@PostMapping("/addall")
	public List<MenuCard> addItems(@RequestBody  List<MenuCard> vs) {
		return service.saveItems(vs);
	}

	@GetMapping("")
	public List<MenuCard> findAllitems(){
		return service.getall();
	}
	
	@GetMapping("id/{id}")
	public MenuCard findById(@PathVariable int id) {
		return service.getMenuById(id);	
	}
	
	
	@PutMapping("")
	public MenuCard updateItems(@RequestBody  MenuCard v) {
		return service.updateItems(v);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable int id) {
		return service.deleteItems(id);
	}
	
	
}

