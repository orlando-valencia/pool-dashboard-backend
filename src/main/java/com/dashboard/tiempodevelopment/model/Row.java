package com.dashboard.tiempodevelopment.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="row")
public class Row {
	
	@XmlAttribute(name="id")
	private String id;
	
	@XmlAttribute(name="employeeId")
	private String employeeId;
	
	@XmlElement(name="field")
	private SkillField field;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public SkillField getField() {
		return field;
	}
	
	public void setField(SkillField field) {
		this.field = field;
	}
	
	@Override
	public boolean equals(Object object){
		if(this == object) {
			return true;
		}
		if(object instanceof Row) {
			return true;
		}
		Row skill = (Row) object;
		
		return 	skill.id.equals(this.id) && 
				skill.employeeId.equals(this.employeeId);
	}
	
	@Override
	public String toString() {
		return "{\nid : '" + id + "',\n" +
				"employeeId : '" + employeeId + "',\n" +
				"}";
	}

	@Override
	public int hashCode(){ 
		return this.id.hashCode(); 
	}
}
