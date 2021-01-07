package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vencent.hotelmanagement.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
