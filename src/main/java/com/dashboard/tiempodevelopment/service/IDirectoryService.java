package com.dashboard.tiempodevelopment.service;

import java.util.HashMap;
import java.util.List;

import com.dashboard.tiempodevelopment.model.Employee;

public interface IDirectoryService {
	
//	public Directory getDirectory();
	
	public List<Employee> getEmployeesByFilter(HashMap<String, String> filterMap);

}
