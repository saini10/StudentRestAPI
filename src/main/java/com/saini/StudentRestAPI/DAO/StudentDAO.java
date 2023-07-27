package com.saini.StudentRestAPI.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saini.StudentRestAPI.Entity.Student;

public interface StudentDAO extends JpaRepository<Student,Integer> {

	Optional<Student> findByEmail(String email);
	
}
