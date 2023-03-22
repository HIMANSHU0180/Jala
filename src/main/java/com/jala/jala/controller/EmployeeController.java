package com.jala.jala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.jala.jala.model.employee;
import com.jala.jala.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAll());

    return "index";
    }
    @GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		employee e = new employee();
		model.addAttribute("employee", e);
		return "new_employee";
	}
    @PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") employee employee) {
		// save employee to database
		employeeService.save(employee);
		return "redirect:/";
	}
    @GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		
		// get employee from the service
		employee e = employeeService.get(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", e);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
