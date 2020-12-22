package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencent.hotelmanagement.entity.MaterialNeeded;

public interface MaterialNeededRepository extends JpaRepository<MaterialNeeded,Integer>{
	
	MaterialNeeded findById( String items);

	
}

