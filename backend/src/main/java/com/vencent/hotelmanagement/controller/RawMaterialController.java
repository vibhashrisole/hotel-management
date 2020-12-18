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

import com.vencent.hotelmanagement.entity.RawMaterial;
import com.vencent.hotelmanagement.service.RawMaterialService;

// This file consist of all the rest api end points
@RequestMapping("/app-hotel-management/raw-material")
@RestController
public class RawMaterialController {
	
	@Autowired
	private RawMaterialService service;
	
	@PostMapping("")
	public RawMaterial addMaterial(@RequestBody  RawMaterial v) {
		return service.saveMaterial(v);
	}
	
	@PostMapping("/addall")
	public List<RawMaterial> addMaterials(@RequestBody  List<RawMaterial> vs) {
		return service.saveMaterials(vs);
	}

	@GetMapping("")
	public List<RawMaterial> findAllMaterials(){
		return service.getMaterial();
	}
	
	@GetMapping("/{id}")
	public RawMaterial findMaterialById(@PathVariable int id) {
		return service.getMaterialById(id);	
	}
	
	/*@GetMapping("/{name}")
	public RawMaterial findMaterialByName(@PathVariable String name) {
		return service.getMaterialByName(name);	
	}*/
	
	@PutMapping("")
	public RawMaterial updateMaterial(@RequestBody  RawMaterial v) {
		return service.updateMaterial(v);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMaterial(@PathVariable int id) {
		return service.deleteMaterial(id);
	}
	
	/*@DeleteMapping("/deleteName/{name}")
	public String deleteMaterial(@PathVariable String name) {
		return service.deleteMaterialByName(name);
	}*/
	
}
