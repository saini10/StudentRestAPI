package com.saini.StudentRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saini.StudentRestAPI.Entity.Student;
import com.saini.StudentRestAPI.Service.StudentServiceImp;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentServiceImp service;
	
	@Autowired
	public StudentController(StudentServiceImp service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Student> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{studentId}")
	public Student getById(@PathVariable String studentId) {
		
		if(isNumber(studentId)) {
			int id = Integer.parseInt(studentId);
			return service.findById(id);
		}
		
		return service.findByEmail(studentId);
	}
	
	private boolean isNumber(String studentId) {
		
		try {
			Integer.parseInt(studentId);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
		
	}

	@PostMapping
    public Student add(@RequestBody Student student) {
    	return service.add(student);
    }
	
	@PutMapping
	public Student update(@RequestBody Student student) {
		return service.update(student);
	}
	
	@DeleteMapping("/{studentId}")
	public void delete(@PathVariable int studentId) {
		service.delete(studentId);
	}
	
}
