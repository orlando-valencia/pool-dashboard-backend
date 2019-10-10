package com.dashboard.tiempodevelopment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Directory {
	
	private List<Field> fields;
	private List<Employee> employees;
	
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public boolean equals(Object object){
		if(this == object) {
			return true;
		}
		if(object instanceof Directory) {
			return true;
		}
		Directory directory = (Directory) object;
		
		return 	directory.fields.equals(this.fields) && 
				directory.employees.equals(this.employees);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\"fields\": [\n");
		for(Field field : fields){
			builder.append(field.toString() + ",");
			builder.append("\n");
		}
		builder.append("]\n\"employees\": [\n");
		for(Employee employee : employees){
			builder.append(employee.toString() + ",");
			builder.append("\n");
		}
		builder.append("]");
		
		return builder.toString();
	}
	
}
