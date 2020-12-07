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
		Address existingAddress=addressRepo.findById(d.getAddress_id()).orElse(null);
		existingAddress.setLine_1(d.getLine_1());
		existingAddress.setLine_2(d.getLine_2());
		existingAddress.setCity(d.getCity());
		existingAddress.setState(d.getState());
		existingAddress.setCountry(d.getCountry());
		existingAddress.setPin_code(d.getPin_code());
		existingAddress.setType(d.getType());	
		return addressRepo.save(existingAddress);
	}
	
}
