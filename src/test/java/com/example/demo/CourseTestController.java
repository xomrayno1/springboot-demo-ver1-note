package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(value = CourseController.class)
public class CourseTestController{
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	CourseRepository courseRepository;
	
	 
	MockMvc mockMvc;

	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	public void testGetAllCourse() throws Exception {
		//ObjectMapper mapper = new ObjectMapper();
		Mockito.when(courseRepository.findAll())
									.thenReturn(
											Arrays.asList(
													new Course(1,"Spring boot"),
													new Course(2,"Spring Mvc"),
													new Course(3,"Java advance"),
													new Course(4,"Angular")
													)		
											);
		String expected = "{{id:1,name:Spring boot},{id:2,name:Spring Mvc},{id:3,name:Java advance},{id:4,name:Angular}}";
		
		MvcResult mvcResult = mockMvc.perform(
					get("/v1/api/courses").accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println("expected : " +expected);
		System.out.println("response : "  + mvcResult.getResponse().getContentAsString());
		
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
		
	}
	
	
	
	
	
	
//	@Test
//	public void testAddCourse() throws JsonProcessingException, Exception {
//		ObjectMapper objectMapper = new ObjectMapper();
//		Mockito.when(courseService.createCourse(new Course("javascript")))
//			.thenAnswer(new Answer<Object>() {
//
//				@Override
//				public Object answer(InvocationOnMock invocation) throws Throwable {
//					// TODO Auto-generated method stub
//					Object[] arguments =  invocation.getArguments();
//					((Course)arguments[0]).setName("javascript");
//					return null;
//				}
//			});
//		mockMvc.perform(post("/v1/api/courses")
//				  .contentType(MediaType.APPLICATION_JSON_VALUE)
//				  .content(objectMapper.writeValueAsString(
//				    new Course("javascript")))
//				  ).andExpect(status().isOk());
//	}
}
