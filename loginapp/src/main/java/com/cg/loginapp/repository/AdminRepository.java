package com.cg.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loginapp.entity.Admin;


@Repository	
public interface AdminRepository extends JpaRepository<Admin,String>{

}
