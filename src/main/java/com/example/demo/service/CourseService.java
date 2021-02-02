package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

public interface CourseService {
	public void deleteCourse(Course course);
	public Course createCourse(Course course);
	public Course updateCourse(Course course);
	public List<Course> getAll();
	public Course getById(long id);
	public List<Course> getByStudent(Student student);
	public List<Course> searchByName(String name);
}
