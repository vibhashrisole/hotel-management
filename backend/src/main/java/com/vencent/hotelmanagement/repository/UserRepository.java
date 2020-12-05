package com.vencent.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vencent.hotelmanagement.entity.User;
public interface UserRepository extends JpaRepository<User,Integer>{

}
