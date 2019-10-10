package com.dashboard.tiempodevelopment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Field {
	
	private String id;
	private String type;
	private String name;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object object){
		if(this == object) {
			return true;
		}
		if(object instanceof Field) {
			return true;
		}
		Field field = (Field) object;
		
		return 	field.id.equals(this.id) && 
				field.name.equals(this.name) && 
				field.type.equals(this.type);
	}
	
	@Override
	public String toString() {
		return "{\nid : '" + id + "',\n" +
				"name : '" + name + "',\n" +
				"type : '" + type + "'\n}";
	}

	@Override
	public int hashCode(){ 
		return this.id.hashCode(); 
	}
}
