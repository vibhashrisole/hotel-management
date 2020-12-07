package com.vencent.hotelmanagement.service;

import java.util.List;
import com.vencent.hotelmanagement.repository.UserRepository;
import com.vencent.hotelmanagement.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User d) {
		return userRepo.save(d);
	}
	
	public List<User> saveall(List<User> d) {
		return userRepo.saveAll(d);
	}
	
	public List<User> getall(){
		return userRepo.findAll();
	}
	
	public User getUserById(int id){
		return userRepo.findById(id).orElse(null);
	}
	
	public String deleteUser(int id) {
		userRepo.deleteById(id);
		return "User Deleted with ID: "+id;
	}
	
	public User updateUser(User d) {
		User existinguser=userRepo.findById(d.getUser_id()).orElse(null);
		existinguser.setUser_name(d.getUser_name());
		return userRepo.save(existinguser);
	}
	
}
