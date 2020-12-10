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

import com.vencent.hotelmanagement.entity.Address;
import com.vencent.hotelmanagement.service.AddressService;

@RequestMapping("/app-hotel-management/address")
@RestController
public class AddressController {

	@Autowired
	private AddressService addService;
	
	@PostMapping("")
	public Address  addData(@RequestBody Address d) {
		return addService.saveAddress(d);
	}
	
	@GetMapping("")
	public List<Address> findAll(){
		return addService.getall();
	}
	
	@GetMapping("getById/{id}")
	public Address findAddressById(@PathVariable int id){
		return addService.getAddressById(id);
	}
	
	@PutMapping("")
	public Address update(@RequestBody Address d) {
		return addService.updateAddress(d);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteAddress(@PathVariable int id){
		return addService.deleteAddress(id);
	}
	
}

