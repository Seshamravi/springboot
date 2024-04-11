package com.springboot.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Student;
import com.springboot.entity.StudentEntity;
import com.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentservice;

	@GetMapping("/hello") // RequestMapping+method=get
	// @ResponseBody
	StudentEntity getMessage(@RequestParam(required=true) Integer id) {
	StudentEntity entity=	studentservice.findStudentid(id);
		
		return entity;
	}

	Student getByid(ArrayList al1, Integer id) {

		Iterator it = al1.iterator();
		while (it.hasNext()) {
			Student st = (Student) it.next();
			if (id == st.getSid()) {
				return st;
			}
		}
		return null;

	}

	@PostMapping("/saveDetails")
	String save(@RequestBody Student std) {
		
		studentservice.save(std);
		return "Data Successfully Inserted";
	}
	@DeleteMapping("/deleteDetails/{sid}")
  String deleteByid(@PathVariable Integer sid) {
		
		studentservice.deleteByid(sid);
	  return "deleted successfully";
  }
}
