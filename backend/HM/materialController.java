package com.hotel_management.HM;
//This file consist of all the rest api end points
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class materialController {
	
	@Autowired
	private materialService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addMaterial")
	public rawMaterial addMaterial(@RequestBody  rawMaterial v) {
		return service.saveMaterial(v);
	}
	
	@PostMapping("/addMaterials")
	public List<rawMaterial> addMaterials(@RequestBody  List<rawMaterial> vs) {
		return service.saveMaterials(vs);
	}

	@GetMapping("/materials")
	public List<rawMaterial> findAllMaterials(){
		return service.getMaterial();
	}
	
	@GetMapping("/materialById/{id}")
	public rawMaterial findMaterialById(@PathVariable int id) {
		return service.getMaterialById(id);	
	}
	
	@GetMapping("/materialByName/{name}")
	public rawMaterial findMaterialByName(@PathVariable String name) {
		return service.getMaterialByName(name);	
	}
	
	@PutMapping("/update")
	public rawMaterial updateMaterial(@RequestBody  rawMaterial v) {
		return service.updateMaterial(v);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMaterial(@PathVariable int id) {
		return service.deleteMaterial(id);
	}
	@DeleteMapping("/deleteByName/{name}")
	public String deleteMaterial(@PathVariable String name) {
		return service.deleteMaterialByName(name);
	}
	
	
}
