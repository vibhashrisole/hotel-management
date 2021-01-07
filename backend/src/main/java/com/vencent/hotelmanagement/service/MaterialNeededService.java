package com.vencent.hotelmanagement.service;

import java.util.List;
import com.vencent.hotelmanagement.repository.MaterialNeededRepository;
import com.vencent.hotelmanagement.entity.MaterialNeeded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaterialNeededService {
	
	@Autowired
	private MaterialNeededRepository MaterialNeededRepo;
	
	public MaterialNeeded saveMaterialNeeded(MaterialNeeded d) {
		return MaterialNeededRepo.save(d);
	}
	
	public List<MaterialNeeded> saveall(List<MaterialNeeded> d) {
		return MaterialNeededRepo.saveAll(d);
	}
	
	public List<MaterialNeeded> getall(){
		return MaterialNeededRepo.findAll();
	}
	
	public MaterialNeeded getMaterialById(int id){
		return MaterialNeededRepo.findById(id).orElse(null);
	}
	public String deleteItems(int id) {
	MaterialNeededRepo.deleteById(id);
		return "Items Removed with ID: "+id;
	}
	
	public MaterialNeeded updateMaterialNeeded(MaterialNeeded d) {
		MaterialNeeded existingMaterial=MaterialNeededRepo.findById(d.getId()).orElse(null);
		existingMaterial.setStatus(d.getStatus());
		return MaterialNeededRepo.save(existingMaterial);
	}
	
}
