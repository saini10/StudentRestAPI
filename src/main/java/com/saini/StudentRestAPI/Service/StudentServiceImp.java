package com.saini.StudentRestAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saini.StudentRestAPI.DAO.StudentDAO;
import com.saini.StudentRestAPI.Entity.Student;
import com.saini.StudentRestAPI.Exception.EmailAlreadyRegisteredException;
import com.saini.StudentRestAPI.Exception.EmailNotFoundException;
import com.saini.StudentRestAPI.Exception.FirstNameNotFoundException;
import com.saini.StudentRestAPI.Exception.StudentNotFoundException;

@Service
public class StudentServiceImp implements StudentService {

	private StudentDAO dao;

	@Autowired
	public StudentServiceImp(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public Student findById(int id) {
		
		if(id <= 0) throw new StudentNotFoundException("Invalid(negative or Zero) id");

		Optional<Student> student = dao.findById(id);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException("Student with id " + id + " does not exists");
		}

	}

	@Override
	public Student findByEmail(String studentId) {
		Optional<Student> student = dao.findByEmail(studentId);

		if (student.isEmpty()) {
			throw new StudentNotFoundException("Student with email " + studentId + " does not exists");

		} else {
			return student.get();
		}

	}

	@Override
	public List<Student> findAll() {
		return dao.findAll();
	}

	@Override
	public Student add(Student student) {
		
		if(student.getFirstName() == null) {
			throw new FirstNameNotFoundException("First Name can not be null");
		}
		
		if(student.getEmail() == null) {
			throw new EmailNotFoundException("Email is mandatory for student registration");
		}
		
		if(dao.findEmail(student.getEmail()) >= 1) {
			throw new EmailAlreadyRegisteredException("Email " + student.getEmail() + " already registred.");
		}
		
		return dao.save(student);
	}

	@Override
	public Student update(Student student) {

		// below line through error if student don't exist already
		
		
		Student s = findById(student.getId());
		
		if(student.getFirstName() == null) {
			throw new FirstNameNotFoundException("First Name can not be null");
		}
		
		if(student.getEmail() == null) {
			throw new EmailNotFoundException("Email is mandatory for student registration");
		}
		
		if(s.getEmail().equals(student.getEmail())) {
			return dao.save(student);
		}
		
		if(dao.findEmail(student.getEmail()) >= 1) {
			throw new EmailAlreadyRegisteredException("Email " + student.getEmail() + " already registred.");
		}
		
		return dao.save(student);

		
	}

	@Override
	public void delete(int id) {

		// below code will through error if we try to delete student that don't exists
		// in database
		Student s = findById(id);

		dao.delete(s);

	}

}
