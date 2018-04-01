package com.itntraining.studentmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	@PostMapping("/departments")
	public ResponseEntity<?> saveDepartment(@RequestBody Department department){
		Department savedDepartment = departmentRepository.save(department);
		return ResponseEntity.ok(savedDepartment);
		
	}
	@GetMapping("/departments")
	public ResponseEntity<?> getAllDepartments(){
		List<Department> departments = departmentRepository.findAll();
		return ResponseEntity.ok(departments);
	}
	
	@PutMapping("/departments")
	@Transactional
	public ResponseEntity<?> updateDepartment(@RequestParam Long departmentId, @RequestBody Department department){
		departmentRepository.findById(departmentId).ifPresent(d -> {
		d.setDepartmentName(department.getDepartmentName());			
	});
		return ResponseEntity.ok("Updated Successfully");
		
	}
	@DeleteMapping("/departments")
	public ResponseEntity<?> deleteStudent(@RequestParam Long departmentId){
		departmentRepository.deleteById(departmentId);
		return ResponseEntity.ok("Deleted");
	}

}
