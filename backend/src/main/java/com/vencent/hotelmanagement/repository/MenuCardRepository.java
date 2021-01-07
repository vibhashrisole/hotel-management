package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencent.hotelmanagement.entity.MenuCard;

public interface MenuCardRepository extends JpaRepository<MenuCard,Integer>{
	
	MenuCard findById( String items);

}
