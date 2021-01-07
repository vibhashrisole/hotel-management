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
	

	public List<MenuCard> getall(){
		return repo.findAll();
	}
	

	public MenuCard getMenuById(int id){
		return repo.findById(id).orElse(null);
	}
	
	//for delete
	public String deleteItems(int id) {
		repo.deleteById(id);
		return "Item Removed with: "+id;
	}
	
	
	//updating item fields
		public MenuCard updateItems(MenuCard v) {
			MenuCard existingitem=repo.findById(v.getId()).orElse(null);
			existingitem.setItems(v.getItems());
			existingitem.setPrice(v.getPrice());
			//existingitem.setRawmaterial(v.getRawmaterial());
			existingitem.setCategoryType(v.getCategoryType());
			
			
			return repo.save(existingitem);
			
		}


	
	
}
