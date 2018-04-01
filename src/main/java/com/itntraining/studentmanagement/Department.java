package com.itntraining.studentmanagement;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department_tbl")
public class Department {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Long departmentId;
	
	
	@Column(name = "department_name", unique = true, nullable = false)
	private String departmentName;
	
	
	@OneToMany(mappedBy = "department")
	List<Student> studentList;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	
	

}
