package com.vencent.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencent.hotelmanagement.entity.Address;
import com.vencent.hotelmanagement.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	public Address saveAddress(Address d) {
		return addressRepo.save(d);
	}
	
	public List<Address> getall(){
		return addressRepo.findAll();
	}
	
	public Address getAddressById(int id){
		return addressRepo.findById(id).orElse(null);
	}
	
	public String deleteAddress(int id) {
		addressRepo.deleteById(id);
		return "Address Deleted with ID: "+id;
	}
	
	public Address updateAddress(Address d) {
		Address existingAddress=addressRepo.findById(d.getAddressId()).orElse(null);
		existingAddress.setLine1(d.getLine1());
		existingAddress.setLine2(d.getLine2());
		existingAddress.setCity(d.getCity());
		existingAddress.setState(d.getState());
		existingAddress.setCountry(d.getCountry());
		existingAddress.setPinCode(d.getPinCode());
		existingAddress.setType(d.getType());
		return addressRepo.save(existingAddress);
	}
	
}
