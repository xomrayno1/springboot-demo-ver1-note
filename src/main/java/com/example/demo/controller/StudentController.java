package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.exception.ApplicationException;
import com.example.demo.response.APIResponse;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/v1/api/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping("/search") 
	public ResponseEntity<APIResponse> getStudentByFistNameAndLastName(
			@RequestParam(value = "firstName",required = false) String firstName,
			@RequestParam(value = "lastName",required = false) String lastName){
		 List<Student> students =  studentService.searchByFirstNameAndLastName(lastName, firstName);
		if(students.isEmpty()) {
			new ResponseEntity<APIResponse>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<List<Student>>(students,
										HttpStatus.OK.getReasonPhrase(),
										HttpStatus.OK.value()),
				HttpStatus.OK);
	}
	@GetMapping("/searchName") 
	public ResponseEntity<APIResponse> getStudentByFistNameAndLastName(
			@RequestParam(value = "name",required = false) String name){
		 List<Student> students =  studentService.findBySearchName(name);
		if(students.isEmpty()) {
			new ResponseEntity<APIResponse>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<List<Student>>(students,
										HttpStatus.OK.getReasonPhrase(),
										HttpStatus.OK.value()),
				HttpStatus.OK);
	}
}
