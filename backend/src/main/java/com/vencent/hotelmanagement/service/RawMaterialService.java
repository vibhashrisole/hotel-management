package com.vencent.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencent.hotelmanagement.entity.RawMaterial;
import com.vencent.hotelmanagement.repository.RawMaterialRepository;

import java.util.List;

@Service
public class RawMaterialService {
	
	@Autowired
	private RawMaterialRepository repo;
	
	//Post method for single material
	public RawMaterial saveMaterial(RawMaterial v) {
		return repo.save(v);
	}
	
	//Post method for multiple materials
	public List<RawMaterial> saveMaterials(List<RawMaterial> vs) {
		return repo.saveAll(vs);
	}
	
	//Get method for single material//returning all beg
	public List<RawMaterial> getMaterial(){
		return repo.findAll();
	}
	
	//Get method for multiple materials
	public RawMaterial getMaterialById(int id){
		return repo.findById(id).orElse(null);
	}
	
	/*/Get material by name
	public RawMaterial getMaterialByName(String name){
		return repo.findByName(name);
	}*/
	
	//for delete
	public String deleteMaterial(int id) {
		repo.deleteById(id);
		return "Vegetable Removed with: "+id;
	}
	
	//updating material fields
	public RawMaterial updateMaterial(RawMaterial v) {
		RawMaterial existingVegetable=repo.findById(v.getId()).orElse(null);
		existingVegetable.setName(v.getName());
		existingVegetable.setQuantity(v.getQuantity());
		existingVegetable.setPrice(v.getPrice());
		return repo.save(existingVegetable);
		
	}

	
}
