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
import com.vencent.hotelmanagement.service.DepartmentService;
import com.vencent.hotelmanagement.entity.Department;

@RequestMapping("/app-hotel-management/department")
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService dept;
	
	@PostMapping("")
	public Department  addData(@RequestBody Department d) {
		return dept.saveDepartment(d);
	}
	
	@PostMapping("/addall")
	public List<Department> addAll(@RequestBody List<Department> emp) {
		return dept.saveall(emp);
	}
	
	@GetMapping("")
	public List<Department> findAll(){
		return dept.getall();
	}
	
	@GetMapping("getById/{id}")
	public Department findEmployeeById(@PathVariable int id){
		return dept.getDataById(id);
	}
	
	@PutMapping("")
	public Department update(@RequestBody Department d) {
		return dept.updateDepartment(d);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteDept(@PathVariable int id){
		return dept.deleteDepartment(id);
	}
	
}
