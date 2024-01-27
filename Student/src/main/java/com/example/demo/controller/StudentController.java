package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentDB;
import com.example.demo.entity.Student;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;

@RestController
public class StudentController {

	@Autowired
	StudentDB stu;
	
	@GetMapping("home")
	public ModelAndView home() {
		ModelAndView page=new ModelAndView();
		page.setViewName("home.jsp");
		return page;
	}
	
	@GetMapping("addstu")
	public ModelAndView addstu() {
		ModelAndView page=new ModelAndView();
		page.setViewName("addstu.jsp");
		return page;
	}

	@GetMapping("deleteme")
	public ModelAndView deletestu() {
		ModelAndView page=new ModelAndView();
		page.setViewName("delete.jsp");
		return page;
	}
	
	@GetMapping("stuupdate")
	public ModelAndView updatestu() {
		ModelAndView page=new ModelAndView();
		page.setViewName("updatestu.jsp");
		return page;
	}
	

	@GetMapping("findidme")
	public ModelAndView findidstu() {
		ModelAndView page=new ModelAndView();
		page.setViewName("findid.jsp");
		return page;
	}

	@GetMapping("findmarkme")
	public ModelAndView findmarkstu() {
		ModelAndView page=new ModelAndView();
		page.setViewName("findmark.jsp");
		return page;
	}

	
	@GetMapping("studentlist")
	@Produces(MediaType.APPLICATION_XML_VALUE )
	public List<Student> getStudent(){
		List<Student> myStudent= (List<Student>)stu.findAll();
		return (List<Student>)myStudent; 
	}
	

	
	@PostMapping(value = "/addstudent", produces = "application/json")
	@Consumes(MediaType.APPLICATION_XML_VALUE )
	public ModelAndView createPerson( Student person) {	
		stu.save(person);
		ModelAndView page=new ModelAndView();
		page.setViewName("success.jsp");
		return page;
		
	}
	
	@PostMapping("roll{id}")
	public Optional<Student> search(int id) {
		Optional<Student> jk=stu.findById(id);
		return jk;
	}
	
	@PostMapping("delete{id}")
	public ModelAndView delete( int id) {
		stu.deleteById(id);
		ModelAndView page = new ModelAndView();
		page.setViewName("success.jsp");
		return page;	
	}
	
	@PostMapping("mark{marks}")
	public List<Student> update(int marks) {
		List<Student> marky= (List<Student>)stu.searchByMarks(marks);
		//Student stt = stu.searchByMarks(marks);
		return marky;
	}
	
	@PostMapping("change")
	public ModelAndView cahnge(Student person) {
		
		stu.updateById(person.getId(), person.getName(), person.getMarks(), person.getResult());
		ModelAndView page = new ModelAndView();
		page.setViewName("success.jsp");
		return page;
	}
	
}
