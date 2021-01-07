package com.vencent.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vencent.hotelmanagement.entity.Employee;
import com.vencent.hotelmanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee saveData(Employee e) {
			return empRepo.save(e);
	}
	
		public List<Employee> saveAll(List<Employee> e) {
			return empRepo.saveAll(e);
		}
		
		public List<Employee> getData(){
			return empRepo.findAll();
		}
		
		public Employee getDataById(int id){
			return empRepo.findById(id).orElse(null);
		}
		
		public String deleteData(int id) {
			empRepo.deleteById(id);
			return "Employee Removed with ID: "+id;
		}
		
		public Employee updateData(Employee e) {
			Employee existingData=empRepo.findById(e.getEmpId()).orElse(null);
			existingData.setName(e.getName());
			existingData.setMobileNo(e.getMobileNo());
			existingData.setAddress(e.getAddress());
			existingData.setEmail(e.getEmail());
			existingData.setDepartment(e.getDepartment());
			existingData.setRole(e.getRole());
			existingData.setStatus(e.getStatus());
			existingData.setUser(e.getUser());
			existingData.setSalary(e.getSalary());
			return empRepo.save(existingData);
		}
		
}

