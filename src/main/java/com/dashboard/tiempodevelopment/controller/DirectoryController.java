package com.dashboard.tiempodevelopment.controller;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.tiempodevelopment.model.Employee;
import com.dashboard.tiempodevelopment.model.Field;
import com.dashboard.tiempodevelopment.model.Row;
import com.dashboard.tiempodevelopment.service.DirectoryServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class DirectoryController {
	
	@Autowired
	private DirectoryServiceImplementation directoryService;
	
//	@GetMapping("/directory")
//	public Directory getDirectory() {
//		return directoryService.getDirectory();
//	}
	
	@GetMapping("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeesByFilter(
			@QueryParam("id") String id,
			@QueryParam("firstName") String firstName,
			@QueryParam("gender") String gender,
			@QueryParam("jobTitle") String jobTitle,
			@QueryParam("department") String department,
			@QueryParam("location") String location,
			@QueryParam("division") String division,
			@QueryParam("supervisor") String supervisor) {

		//TODO : Change HashMap By List of values on each Parameter
		
		HashMap<String, String> filterMap = new HashMap<>();
		if(id != null) filterMap.put("id", id);
		if(firstName != null) filterMap.put("firstName", firstName);
		if(gender != null) filterMap.put("gender", gender);
		if(jobTitle != null) filterMap.put("jobTitle", jobTitle);
		if(department != null) filterMap.put("department", department);
		if(location != null) filterMap.put("location", location);
		if(division != null) filterMap.put("division", division);
		if(supervisor != null) filterMap.put("supervisor", supervisor);
		
		return directoryService.getEmployeesByFilter(filterMap);
	}
	
	@GetMapping("/fields")
	public List<Field> getFields() {
		return directoryService.getFields();
	}
	
	@GetMapping("/skills")
	public Row[] getSkills() {
		return directoryService.getSkillList();
	}
}
