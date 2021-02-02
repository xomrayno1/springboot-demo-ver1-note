package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Course;
import com.example.demo.exception.ApplicationException;
import com.example.demo.response.APIResponse;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/v1/api/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping
	public ResponseEntity<APIResponse> getAll(){
		List<Course> course = courseService.getAll();
		if(course.isEmpty()) {
			return new ResponseEntity<APIResponse>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<List<Course>>(course, 
						HttpStatus.OK.getReasonPhrase(),
						HttpStatus.OK.value()),
				HttpStatus.OK);
	}
	@GetMapping("/search")
	public ResponseEntity<APIResponse> getSearchByName(
			@RequestParam(value = "search",required = false, defaultValue = "")String name){
		//System.out.println(name);
		List<Course> course = courseService.searchByName(name);
		if(course.isEmpty()) {
			return new ResponseEntity<APIResponse>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<List<Course>>(course, 
						HttpStatus.OK.getReasonPhrase(),
						HttpStatus.OK.value()),
				HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getCourseById(@PathVariable("id") long id){
		Course course = courseService.getById(id);
		if(course == null) {
			throw new ApplicationException("course not found exception with id :"+id);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<Course>(course, 
										HttpStatus.OK.getReasonPhrase(),
										HttpStatus.OK.value()),
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<APIResponse> createCourse(@Validated @RequestBody Course createCourse){
		Course course =  courseService.createCourse(createCourse);
		APIResponse apiResponse = new APIResponse<Course>(course, 
							HttpStatus.CREATED.getReasonPhrase(), 
							HttpStatus.CREATED.value());
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
							.buildAndExpand(course.getId()).toUri();
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setLocation(location);
//		responseHeaders.set("MyResponseHeader","MyValue");
//	 
//		return new ResponseEntity<APIResponse>(apiResponse,responseHeaders,HttpStatus.CREATED);
		
		return ResponseEntity.created(location).body(apiResponse);
	}
}
