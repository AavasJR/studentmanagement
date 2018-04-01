package com.itntraining.studentmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_tbl")	//every table has a primary key
public class Student {
	@Id					// This makes the studentId as primary key
	@GeneratedValue		// For auto increment
	@Column(name = "student_id")	
	private Long studentId;	
	@Column(name = "first_name")
	private String firstName;	
	@Column(name = "last_name")
	private String lastName;	
	@Column( name = "address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	public Department getDeparatment() {
		return department;
	}
	public void setDeparatment(Department deparatment) {
		this.department = deparatment;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
