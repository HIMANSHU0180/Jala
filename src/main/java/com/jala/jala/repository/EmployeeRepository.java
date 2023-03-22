package com.jala.jala.repository;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jala.jala.model.employee;


@JavaBean
public interface EmployeeRepository extends JpaRepository<employee,Integer> {
   
    
}


