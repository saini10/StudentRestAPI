package com.saini.StudentRestAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saini.StudentRestAPI.DAO.StudentDAO;
import com.saini.StudentRestAPI.Entity.Student;

@Service
public class StudentServiceImp implements StudentService {

	private StudentDAO dao;

	@Autowired
	public StudentServiceImp(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public Student findById(int id) {

		Optional<Student> student = dao.findById(id);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new RuntimeException("Student with email " + id + " does not exists");
		}

	}

	@Override
	public Student findByEmail(String studentId) {
		Optional<Student> student = dao.findByEmail(studentId);

		if (student.isEmpty()) {
			throw new RuntimeException("Student with email " + studentId + " does not exists");

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
		return dao.save(student);
	}

	@Override
	public Student update(Student student) {

		// below line through error if student don't exist already
		@SuppressWarnings("unused")
		Student s = findById(student.getId());

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
