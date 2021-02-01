package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	public void deleteStudent(Student student);
	public Student createStudent(Student student);
	public Student updateStudent(Student student);
	public List<Student> getAll();
	public Student getById(long id);
	 
}
