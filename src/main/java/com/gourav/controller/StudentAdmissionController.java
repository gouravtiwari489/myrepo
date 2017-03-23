package com.gourav.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gourav.entity.Employee;

@Controller
@RequestMapping("/spring")
public class StudentAdmissionController {
	
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String studentName, 
			@RequestParam("hobby") String hobby){
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("msg", "Details submitted by "+studentName +" and his hobbies are "+ hobby);
		return modelAndView;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getClientById(@RequestParam(required = false) String clientId) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setName("gourav");
		employee.setGender("m");
		employee.setAge("28");
		employees.add(employee);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
}
