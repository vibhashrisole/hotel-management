package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencent.hotelmanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}

