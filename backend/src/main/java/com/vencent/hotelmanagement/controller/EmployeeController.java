package com.vencent.hotelmanagement.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vencent.hotelmanagement.entity.Employee;
import com.vencent.hotelmanagement.service.EmployeeService;

@RequestMapping("/app-hotel-management/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService emp_service;
	
	@PostMapping("")
	public Employee addData(@RequestBody Employee emp) {
		return emp_service.saveData(emp);
	}
	
	@PostMapping("/addall")
	public List<Employee> addAll(@RequestBody List<Employee> emp) {
		return emp_service.saveAll(emp);
	}
	
	@GetMapping("")
	public List<Employee> findAll(){
		return emp_service.getData();
	}
	
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable int id){
		return emp_service.getDataById(id);
	}
	
	@PutMapping("")
	public Employee update(@RequestBody Employee emp) {
		return emp_service.updateData(emp);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id){
		return emp_service.deleteData(id);
	}
	
}

