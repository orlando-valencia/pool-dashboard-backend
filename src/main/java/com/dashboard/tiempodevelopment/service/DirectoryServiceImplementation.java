package com.dashboard.tiempodevelopment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.MediaType;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dashboard.tiempodevelopment.model.Directory;
import com.dashboard.tiempodevelopment.model.Employee;
import com.dashboard.tiempodevelopment.model.Field;
import com.dashboard.tiempodevelopment.model.Row;

@Component
public class DirectoryServiceImplementation implements IDirectoryService {

	private static final String DIRECTORY_JSON_URL = "https://api.bamboohr.com/api/gateway.php/tiempodevelopment/v1/employees/directory";
	private static final String SKILLS_JSON_URL = "https://api.bamboohr.com/api/gateway.php/tiempodevelopment/v1/employees/all/tables/customSkills1";
	//	private static final Logger log = LoggerFactory.getLogger(DirectoryServiceImplementation.class);

	@Autowired
	private RestTemplate restTemplate;

//	@Override
//	public Directory getDirectory() {
//		return getDirectoryInfo().getBody();
//	}

	public List<Employee> getEmployeesByFilter(HashMap<String, String> filterMap){
		List<Employee> employees = getDirectoryInfo().getBody().getEmployees();
		List<Employee> newEmployees = new ArrayList<>();

		for(Employee employee : employees) {
			boolean isById = filterMap.get("id") != null && employee.getId() != null && employee.getId().toLowerCase().equals(filterMap.get("id").toLowerCase());
			boolean isByFirstName = filterMap.get("firstName") != null && employee.getFirstName() != null && employee.getFirstName().toLowerCase().equals(filterMap.get("firstName").toLowerCase());
			boolean isByGender = filterMap.get("gender") != null && employee.getGender() != null && employee.getGender().toLowerCase().equals(filterMap.get("gender").toLowerCase());
			boolean isByJobTitle = filterMap.get("jobTitle") != null && employee.getJobTitle() != null && employee.getJobTitle().toLowerCase().equals(filterMap.get("jobTitle").toLowerCase());
			boolean isByDepartment = filterMap.get("department") != null && employee.getDepartment() != null && employee.getDepartment().toLowerCase().equals(filterMap.get("department").toLowerCase());
			boolean isByLocation = filterMap.get("location") != null && employee.getLocation() != null && employee.getLocation().toLowerCase().equals(filterMap.get("location").toLowerCase());
			boolean isByDivision = filterMap.get("division") != null && employee.getDivision() != null && employee.getDivision().toLowerCase().equals(filterMap.get("division").toLowerCase());
			boolean isBySupervisor = filterMap.get("supervisor") != null && employee.getSupervisor() != null && employee.getSupervisor().toLowerCase().equals(filterMap.get("supervisor").toLowerCase());
			if((((((((isById || isByFirstName) || isByGender) || isByJobTitle) || isByDepartment) || isByLocation) || isByDivision) || isBySupervisor)) {
				newEmployees.add(employee);
			}
		}

		if(newEmployees.isEmpty()) {
			return employees;
		}

		return newEmployees;
	}

	public List<Field> getFields() {
		return getDirectoryInfo().getBody().getFields();
	}

	private ResponseEntity<Directory> getDirectoryInfo() {
		return restTemplate.exchange(DIRECTORY_JSON_URL, HttpMethod.GET, new HttpEntity<String>(getHeadersJSON()), Directory.class);
	}

	public Row[] getSkillList(){
		HttpEntity<Row[]> entity = new HttpEntity<>(getHeadersXML());
		return restTemplate.exchange(SKILLS_JSON_URL, HttpMethod.GET, entity, Row[].class).getBody();
	}

	private HttpHeaders getHeadersJSON() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("3c55a824dc08566f18df31731be1da8bd927fee0", "x");
		headers.set("accept", MediaType.APPLICATION_JSON);
		return headers;
	}

	private HttpHeaders getHeadersXML() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("3c55a824dc08566f18df31731be1da8bd927fee0", "x");
		return headers;
	}
}
