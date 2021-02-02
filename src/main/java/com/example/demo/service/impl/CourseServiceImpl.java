package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl  implements CourseService{
	@Autowired
	CourseRepository courseRepo;

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepo.delete(course);
	}

	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Course getById(long id) {
		// TODO Auto-generated method stub
		return courseRepo.findById(id).orElse(null);
	}

	@Override
	public List<Course> getByStudent(Student student) {
		// TODO Auto-generated method stub
		return courseRepo.findByStudents(student);
	}

	@Override
	public List<Course> searchByName(String name) {
		// TODO Auto-generated method stub
		return courseRepo.findByNameContainingAllIgnoreCase(name);
	}

}
