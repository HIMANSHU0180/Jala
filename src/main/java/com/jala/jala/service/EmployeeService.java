package com.jala.jala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jala.jala.model.employee;
import com.jala.jala.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
   public   List<employee> getAll(){
    return employeeRepository.findAll();
   }
   public void save(employee e){
    employeeRepository.save(e);
   }
   
	public employee get(int id) {
		Optional<employee> optional = employeeRepository.findById(id);
		employee e = null;
		if (optional.isPresent()) {
			e = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return e;
	}
	public void deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);
	}
}
