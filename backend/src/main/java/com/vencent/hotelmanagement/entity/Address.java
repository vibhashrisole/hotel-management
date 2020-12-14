package com.vencent.hotelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue
	private int address_id;
	
	private String line_1;
	
	private String line_2;
	
	private String city;
	
	private int pin_code;
	
	private String country;
	
	private String state;
	
	@OneToOne(targetEntity = Type.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAddress_id() {
		return address_id;
	}

	public String getLine_1() {
		return line_1;
	}

	public void setLine_1(String line_1) {
		this.line_1 = line_1;
	}

	public String getLine_2() {
		return line_2;
	}

	public void setLine_2(String line_2) {
		this.line_2 = line_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}



