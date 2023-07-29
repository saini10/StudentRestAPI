package com.saini.StudentRestAPI.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saini.StudentRestAPI.Entity.Student;

public interface StudentDAO extends JpaRepository<Student,Integer> {

	Optional<Student> findByEmail(String email);
	
	@Query(value = "Select COUNT(email) FROM student WHERE email= ?1",
			nativeQuery=true)
	int findEmail(String email);
	
}
