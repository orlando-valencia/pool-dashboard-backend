package com.dashboard.tiempodevelopment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String id;
    private String displayName;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String gender;
    private String jobTitle;
    private String workEmail;
    private String department;
    private String location;
    private String division;
    private String linkedIn;
    private String supervisor;
    private boolean photoUploaded;
    private String photoUrl;
    private int canUploadPhoto;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPreferredName() {
		return preferredName;
	}
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public boolean isPhotoUploaded() {
		return photoUploaded;
	}
	public void setPhotoUploaded(boolean photoUploaded) {
		this.photoUploaded = photoUploaded;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public int getCanUploadPhoto() {
		return canUploadPhoto;
	}
	public void setCanUploadPhoto(int canUploadPhoto) {
		this.canUploadPhoto = canUploadPhoto;
	}
	
	@Override
	public boolean equals(Object object){
		if(this == object) {
			return true;
		}
		if(object instanceof Employee) {
			return true;
		}
		Employee employee = (Employee) object;
		
		return 	employee.id.equals(this.id) &&
				employee.displayName.equals(this.displayName) &&
				employee.firstName.equals(this.firstName) &&
				employee.lastName.equals(this.lastName) &&
				employee.preferredName.equals(this.preferredName) &&
				employee.gender.equals(this.gender) &&
				employee.jobTitle.equals(this.jobTitle) &&
				employee.workEmail.equals(this.workEmail) &&
				employee.department.equals(this.department) &&
				employee.location.equals(this.location) &&
				employee.division.equals(this.division) &&
				employee.linkedIn.equals(this.linkedIn) &&
				employee.supervisor.equals(this.supervisor) &&
				employee.photoUploaded == this.photoUploaded &&
				employee.photoUrl.equals(this.photoUrl) &&
				employee.canUploadPhoto == this.canUploadPhoto;
	}
	
	@Override
	public String toString() {
		return 	"{\nid : '" + id + "',\n" +
				"displayName : '" + displayName + "',\n" +
				"firstName : '" + firstName + "',\n" +
				"lastName : '" + lastName + "',\n" +
				"preferredName : '" + preferredName + "',\n" +
				"gender : '" + gender + "',\n" +
				"jobTitle : '" + jobTitle + "',\n" +
				"workEmail : '" + workEmail + "',\n" +
				"department : '" + department + "',\n" +
				"location : '" + location + "',\n" +
				"division : '" + division + "',\n" +
				"linkedIn : '" + linkedIn + "',\n" +
				"supervisor : '" + supervisor + "',\n" +
				"photoUploaded : '" + photoUploaded + "',\n" +
				"photoUrl : '" + photoUrl + "',\n" +
				"canUploadPhoto : '" + canUploadPhoto + "'\n}";
	}
	
	@Override
	public int hashCode(){ 
		return this.id.hashCode(); 
	}
}
