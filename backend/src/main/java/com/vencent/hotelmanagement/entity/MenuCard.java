package com.vencent.hotelmanagement.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MenuCard")
public class MenuCard {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="items")
	private String items;
	
	@Column(name="price")
	private double price;

	
	/*@OneToMany( targetEntity=RawMaterial.class,cascade = CascadeType.ALL)
	@JoinColumn(name="MenuRaw_fk",referencedColumnName="id")
	
	List<RawMaterial>  rawmaterial= new ArrayList<>();*/
	
	
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable = false)
    private Category categoryType ;
	
	
	
	/**
	 * @return the categoryType
	 */
	public Category getCategoryType() {
		return categoryType;
	}


	/**
	 * @param categoryType the categoryType to set
	 */
	public void setCategoryType(Category categoryType) {
		this.categoryType = categoryType;
	}


	/*public List<RawMaterial> getRawmaterial() {
		return rawmaterial;
	}

	
	public void setRawmaterial(List<RawMaterial> rawmaterial) {
		this.rawmaterial = rawmaterial;
	}*/

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getItems() {
		return items;
	}

	
	public void setItems(String items) {
		this.items = items;
	}

	
	public double getPrice() {
		return price;
	}

	
	public void setPrice(double price) {
		this.price = price;
	}


	
}
