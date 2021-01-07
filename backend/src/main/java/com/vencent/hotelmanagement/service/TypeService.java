package com.vencent.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencent.hotelmanagement.entity.Type;
import com.vencent.hotelmanagement.repository.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepo;
	
	public Type saveType(Type t) {
		return typeRepo.save(t);
	}
	
	public List<Type> getall(){
		return typeRepo.findAll();
	}
	
	public Type getAddressById(int id){
		return typeRepo.findById(id).orElse(null);
	}
	
	public String deleteType(int id) {
		typeRepo.deleteById(id);
		return "Type Deleted with ID: "+id;
	}
	
	public Type updateType(Type t) {
		Type existingType=typeRepo.findById(t.getTypeId()).orElse(null);
		existingType.setTypeName(t.getTypeName());
		return typeRepo.save(existingType);
	}
	
}

