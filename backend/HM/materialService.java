package com.hotel_management.HM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class materialService {
	@Autowired
	private Vegetable_Repository repository;
	
	
	//Post method for single material
	public rawMaterial saveMaterial(rawMaterial v) {
		return repository.save(v);
	}
	
	//Post method for multiple materials
	public List<rawMaterial> saveMaterials(List<rawMaterial> vs) {
		return repository.saveAll(vs);
	}
	
	//Get method for single material//returning all beg
	public List<rawMaterial> getMaterial(){
		return repository.findAll();
	}
	
	//Get method for multiple materials
	public rawMaterial getMaterialById(int id){
		return repository.findById(id).orElse(null);
	}
	
	//Get material by name
	public rawMaterial getMaterialByName(String name){
		return repository.findByName(name);
	}
	
	//for delete
	public String deleteMaterial(int id) {
		repository.deleteById(id);
		return "Vegetable Removed"+id;
	}
	//deleting by name
	public String deleteMaterialByName(String name) {
		rawMaterial existingVegetable=repository.findByName(name);
		int temp_id=existingVegetable.getId();
		repository.deleteById(temp_id);
		return null;
	}
	
	//updating material fields
	public rawMaterial updateMaterial(rawMaterial v) {
		rawMaterial existingVegetable=repository.findById(v.getId()).orElse(null);
		existingVegetable.setName(v.getName());
		existingVegetable.setQuantity(v.getQuantity());
		existingVegetable.setPrice(v.getPrice());
		return repository.save(existingVegetable);
		
	}

	
}
