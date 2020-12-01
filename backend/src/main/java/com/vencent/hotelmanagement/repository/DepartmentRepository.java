package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vencent.hotelmanagement.entity.Department;
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
