package com.vencent.hotelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue
	private int dept_id;
	
	private String dept_name;
	
	public int getDept_id() {
		return dept_id;
	}
	
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}

