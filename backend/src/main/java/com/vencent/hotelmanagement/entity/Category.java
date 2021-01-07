package com.vencent.hotelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_type")
	private String categoryType;

	
	public int getCategoryId() {
		return categoryId;
	}

	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	public String getCategoryType() {
		return categoryType;
	}

	
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
	
	
}
