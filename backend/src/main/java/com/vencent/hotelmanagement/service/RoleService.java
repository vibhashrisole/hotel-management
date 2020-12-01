package com.vencent.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vencent.hotelmanagement.repository.RoleRepository;
import com.vencent.hotelmanagement.entity.Role;
@Service
public class RoleService {
	
	@Autowired
	private RoleRepository rollRepo;
	
	public Role saveRole(Role d) {
		return rollRepo.save(d);
	}
	
	public List<Role> saveall(List<Role> d) {
		return rollRepo.saveAll(d);
	}
	
	public List<Role> getall(){
		return rollRepo.findAll();
	}
	
	public Role getDataById(int id){
		return rollRepo.findById(id).orElse(null);
	}
	
	public String deleteRole(int id) {
		rollRepo.deleteById(id);
		return "Department Deleted with ID: "+id;
	}
	
	public Role updateRole(Role d) {
		Role existingRole=rollRepo.findById(d.getRole_id()).orElse(null);
		existingRole.setRole_name(d.getRole_name());
		return rollRepo.save(existingRole);
	}
	
}
