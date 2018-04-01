package com.itntraining.studentmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController		//rest works in json data
public class StudentController {
	@Autowired		//to make the object of interface
	private StudentRepository studentRepository;
	
//	@GetMapping("/students")
//	public Student getStudent() {
//		Student student = new Student();
//		student.setStudentId(1L);
//		student.setFirstName("Aavas");
//		student.setLastName("Rayamajhi");
//		student.setAddress("Maitidevi");
//		return student;
//	}
	
	@GetMapping("/students/{firstName}")
	public String greet(@PathVariable String firstName) {	//Path Variable saves the firstName when entered in localhost
		return "Hello " + firstName;
	}
	@PostMapping("/students")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {	//ResponseEntity<?> le postman ko response client lai pathaucha 
		System.out.println("First Name: "+ student.getFirstName());
		System.out.println("Last Name:" + student.getLastName());
		Student savedStudent = studentRepository.save(student);		//this saves the data
		return ResponseEntity.ok(savedStudent);
	}
	
	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents(){
		List<Student> studentList = studentRepository.findAll();		//findall database bata data lyao ani teslai studentList ma assign garyo   
		return ResponseEntity.ok(studentList);		
	}
	
	@PutMapping("/students")		//to update the data 
	@Transactional	// Automatically updates the database or in other words manages transactions
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @RequestParam Long studentId){	//requestparam ma id aairako cha ani body ma chai 
		Optional<Student> oldStudentOptional = studentRepository.findById(studentId);
		oldStudentOptional.ifPresent(s -> {
			s.setAddress(student.getAddress());
			s.setFirstName(s.getFirstName());
			s.setLastName(s.getLastName());
			});
		return ResponseEntity.ok("Student Updated Successfully");
	}
	@DeleteMapping("/students")
	public ResponseEntity<?> deleteStudent(@RequestParam Long studentId){
		studentRepository.findById(studentId).ifPresent(s ->{
			studentRepository.delete(s);
		});
		return ResponseEntity.ok("Deleted");
	}
}
