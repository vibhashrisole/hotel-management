package com.vencent.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencent.hotelmanagement.entity.MenuCard;

import com.vencent.hotelmanagement.repository.MenuCardRepository;

import java.util.List;

@Service
public class MenuCardService {

	
	@Autowired
	private MenuCardRepository repo;
	
	//Post method for single item
	public MenuCard saveItems(MenuCard v) {
		return repo.save(v);
	}
	
	//Post method for multiple items
	public List<MenuCard> saveItems(List<MenuCard> vs) {
		return repo.saveAll(vs);
	}
	
	//Get method for single item
	public List<MenuCard> getItems(){
		return repo.findAll();
	}
	
	//Get method for multiple items
	public MenuCard getMenuById(int id){
		return repo.findById(id).orElse(null);
	}
	
	//Get Menu by Item
	public MenuCard findById(String items){
		return repo.findById(items);
	}
	
	//for delete
	public String deleteItems(int id) {
		repo.deleteById(id);
		return "Item Removed with: "+id;
	}
	
	//deleting by item
	public String deleteByItems(String items) {
		MenuCard existingitem=repo.findById(items);
		int temp_id=existingitem.getId();
		repo.deleteById(temp_id);
		return null;
	}
	
	//updating item fields
		public MenuCard updateItems(MenuCard v) {
			MenuCard existingitem=repo.findById(v.getId()).orElse(null);
			existingitem.setItems(v.getItems());
			existingitem.setPrice(v.getPrice());
			return repo.save(existingitem);
			
		}


	
	
}
