package com.vencent.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vencent.hotelmanagement.repository.DepartmentRepository;
import com.vencent.hotelmanagement.entity.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	public Department saveDepartment(Department d) {
		return deptRepo.save(d);
	}
	
	public List<Department> saveall(List<Department> d) {
		return deptRepo.saveAll(d);
	}
	
	public List<Department> getall(){
		return deptRepo.findAll();
	}
	
	public Department getDataById(int id){
		return deptRepo.findById(id).orElse(null);
	}
	
	public String deleteDepartment(int id) {
		deptRepo.deleteById(id);
		return "Department Deleted with ID: "+id;
	}
	
	public Department updateDepartment(Department d) {
		Department existingDepartment=deptRepo.findById(d.getDept_id()).orElse(null);
		existingDepartment.setDept_name(d.getDept_name());
		return deptRepo.save(existingDepartment);
	}
	
}
