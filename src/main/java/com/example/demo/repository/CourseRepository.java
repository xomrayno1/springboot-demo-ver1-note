package com.example.demo.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
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
 
	@Query(value = "SELECT course FROM Course course WHERE upper(course.name) LIKE    upper(concat('%',:name,'%'))  ")
	//build query 
	List<Course> findByNameContainingAllIgnoreCase(@PathParam("name")	String name);
	// Tìm kiếm %name% ko phân biệt hoa thường(tất cả trường hợp bỏ qua)
	//findByNameAllIgnoreCase
	//tìm kiếm name ko phan biệt hoa,thường
	//SQL : nó sử dụng upper cho value về chữ hoa và cho các value field về hoa rồi tìm kiếm
}
