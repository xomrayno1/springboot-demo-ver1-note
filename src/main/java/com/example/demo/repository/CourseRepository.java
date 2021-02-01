package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

@Repository
public interface CourseRepository  extends CrudRepository<Course, Long>{
	//	jpaRepo->pagingandsort->crud ->repository
	
	@Override
	List<Course> findAll();
	
	List<Course> findByStudents(Student student);
}
