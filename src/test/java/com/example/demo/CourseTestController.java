package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.connect.Connector.Argument;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTestController {
	@Autowired
	private WebApplicationContext context;
	@MockBean
	CourseService courseService;
	
	 
	MockMvc mockMvc;

	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testAddCourse() throws JsonProcessingException, Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Mockito.when(courseService.createCourse(new Course("javascript")))
			.thenAnswer(new Answer<Object>() {

				@Override
				public Object answer(InvocationOnMock invocation) throws Throwable {
					// TODO Auto-generated method stub
					Object[] arguments =  invocation.getArguments();
					((Course)arguments[0]).setName("javascript");
					return null;
				}
			});
		mockMvc.perform(post("/v1/api/courses")
				  .contentType(MediaType.APPLICATION_JSON_VALUE)
				  .content(objectMapper.writeValueAsString(
				    new Course("javascript")))
				  ).andExpect(status().isOk());
	}
}
