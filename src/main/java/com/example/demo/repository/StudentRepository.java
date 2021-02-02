package com.example.demo.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long>{
	@Query("SELECT student FROM Student student where upper(student.firstName) like upper(concat('%',:firstName,'%')) "
			+ " and upper(student.lastName) like upper(concat('%',:lastName,'%'))" )
	List<Student> findBySearchFirstNameAndLastName(String firstName, String lastName);
	//search nhìu đk
	
	
	@Query("SELECT student FROM Student student where upper(student.firstName) like upper(concat('%',:name,'%')) "
			+ " or upper(student.lastName) like upper(concat('%',:name,'%'))" )
	List<Student> findBySearchName(@PathParam("name") String name);
	//1 field nhưng search trên nhiều field
}
