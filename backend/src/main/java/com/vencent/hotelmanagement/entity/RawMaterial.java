package com.vencent.hotelmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="raw_material")
public class RawMaterial {
	
	@Id
	@GeneratedValue
	@Column(name="raw_id")
	private int rawMaterialId;
	
	@Column(name="raw_material_name")
	private String rawMaterialName;
	
	@Column(name="raw_material_price")
	private double rawMaterialPrice;
	
	@Column(name="raw_material_quantity")
	private double rawMaterialQuantity;
	
	public int getId() {
		return rawMaterialId;
	}
	
	public void setId(int id) {
		this.rawMaterialId = id;
	}
	
	public String getName() {
		return rawMaterialName;
	}
	
	public void setName(String name) {
		this.rawMaterialName = name;
	}
	
	public double getPrice() {
		return rawMaterialPrice;
	}
	
	public void setPrice(double price) {
		this.rawMaterialPrice = price;
	}
	
	public double getQuantity() {
		return rawMaterialQuantity;
	}
	
	public void setQuantity(double quantity) {
		this.rawMaterialQuantity = quantity;
	}
	
}
