package com.vencent.hotelmanagement.controller;

import java.util.*;
import com.vencent.hotelmanagement.entity.User;
import com.vencent.hotelmanagement.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public User  addData(@RequestBody User d) {
		return userService.saveUser(d);
	}
	
	@PostMapping("/addall")
	public List<User> addAll(@RequestBody List<User> emp) {
		return userService.saveall(emp);
	}
	
	@GetMapping("")
	public List<User> findAll(){
		return userService.getall();
	}
	
	@GetMapping("getById/{id}")
	public User findEmployeeById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@PutMapping("")
	public User update(@RequestBody User d) {
		return userService.updateUser(d);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteDept(@PathVariable int id){
		return userService.deleteUser(id);
	}
	
}
