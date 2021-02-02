package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "name is required")
	@Size(min = 2 , max = 20 , message = "field size 2 to 20")
	private String name;
	
	
	@ManyToMany
	@JoinTable(name = "student_course",
				joinColumns = @JoinColumn(name="course_id"),
				inverseJoinColumns = @JoinColumn(name="student_id"))	
	@JsonIgnore
	private List<Student> students;


	public Course() {
		super();
	}


	public Course(long id,
			@NotBlank(message = "name is required") @Size(min = 2, max = 20, message = "field size 2 to 20") String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Course(
			@NotBlank(message = "name is required") @Size(min = 2, max = 20, message = "field size 2 to 20") String name) {
		super();
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	

}
