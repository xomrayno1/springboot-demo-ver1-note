package com.example.demo.service;

import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.entity.Student;

public interface StudentService {
	public void deleteStudent(Student student);
	public Student createStudent(Student student);
	public Student updateStudent(Student student);
	public List<Student> getAll();
	public List<Student> searchByFirstNameAndLastName(String lastName, String firstName);
	List<Student> findBySearchName(String name);
	public Student getById(long id);
	public Student getOne(long id);
}
