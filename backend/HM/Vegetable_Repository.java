package com.hotel_management.HM;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Vegetable_Repository extends JpaRepository<rawMaterial,Integer>{
	rawMaterial findByName(String name);
}
