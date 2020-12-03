package com.vencent.hotelmanagement.controller;

import java.util.*;
import com.vencent.hotelmanagement.service.RoleService;
import com.vencent.hotelmanagement.entity.Role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/app-hotel-management/role")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("")
	public Role  addData(@RequestBody Role d) {
		return roleService.saveRole(d);
	}
	
	@PostMapping("/addall")
	public List<Role> addAll(@RequestBody List<Role> r) {
		return roleService.saveall(r);
	}
	
	@GetMapping("")
	public List<Role> findAll(){
		return roleService.getall();
	}
	
	@GetMapping("getById/{id}")
	public Role findEmployeeById(@PathVariable int id){
		return roleService.getDataById(id);
	}
	
	@PutMapping("")
	public Role update(@RequestBody Role d) {
		return roleService.updateRole(d);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteDept(@PathVariable int id){
		return roleService.deleteRole(id);
	}
	
}
