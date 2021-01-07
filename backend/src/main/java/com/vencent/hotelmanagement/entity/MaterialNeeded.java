package com.vencent.hotelmanagement.entity;

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
@Table(name="MaterialNeeded")
public class MaterialNeeded {

	@Id
	@GeneratedValue
	
	
	private int id;

	private String  Status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getStatus() {
		return Status;
	}

	
	public void setStatus(String status) {
		Status = status;
	}

	
	
	
	
	
}
	