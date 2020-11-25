package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencent.hotelmanagement.entity.RawMaterial;

public interface RawMaterialRepository extends JpaRepository<RawMaterial,Integer>{

	RawMaterial findByName(String name);

}
