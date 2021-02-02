package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getById(long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	public Student getOne(long id) {
		// TODO Auto-generated method stub
		return studentRepo.getOne(id);
	}

	@Override
	public List<Student> searchByFirstNameAndLastName(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return studentRepo.findBySearchFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<Student> findBySearchName(String name) {
		// TODO Auto-generated method stub
		return studentRepo.findBySearchName(name);
	}

}
