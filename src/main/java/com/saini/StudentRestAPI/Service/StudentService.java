package com.saini.StudentRestAPI.Service;

import java.util.List;

import com.saini.StudentRestAPI.Entity.Student;

public interface StudentService {

	Student findById(int id);
	
	Student findByEmail(String studentId);
	
	List<Student> findAll();
	
	Student add(Student student);
	
	Student update(Student student);
	
	void delete(int id);
	
	
	
}
