package com.vencent.hotelmanagement.controller;

import java.util.*;
import com.vencent.hotelmanagement.entity.MaterialNeeded;
import com.vencent.hotelmanagement.service.MaterialNeededService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/MaterialNeeded")
@RestController
public class MaterialNeededController {

	@Autowired
	private MaterialNeededService MaterialNeededService;
	
	@PostMapping("")
	public MaterialNeeded  addMaterial(@RequestBody MaterialNeeded d) {
		return MaterialNeededService.saveMaterialNeeded(d);
	}
	
	@PostMapping("/addall")
	public List<MaterialNeeded> addAll(@RequestBody List<MaterialNeeded> Material) {
		return MaterialNeededService.saveall(Material);
	}
	
	@GetMapping("")
	public List<MaterialNeeded> findAll(){
		return MaterialNeededService.getall();
	}
	
	@GetMapping("getById/{id}")
	public MaterialNeeded findMaterialById(@PathVariable int id){
		return MaterialNeededService.getMaterialById(id);
	}
	
	@PutMapping("")
	public MaterialNeeded update(@RequestBody MaterialNeeded d) {
		return MaterialNeededService.updateMaterialNeeded(d);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteItems(@PathVariable int id){
		return MaterialNeededService.deleteItems(id);
	}
	
	
}
