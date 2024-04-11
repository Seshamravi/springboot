package com.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Student;
import com.springboot.entity.StudentEntity;
import com.springboot.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentrepository;

	public void save(Student std) {
		StudentEntity entity=new StudentEntity();
		
		entity.setSid(std.getSid());
		entity.setSname(std.getSname());
		entity.setAddress(std.getAddress());
		studentrepository.save(entity);
		
	}

	public StudentEntity findStudentid(Integer id) {
		
	Optional<StudentEntity> std=studentrepository.findById(id);
	 StudentEntity entity=std.isPresent()?std.get():null;
	
	 return entity;
	
	}

	public void deleteByid(Integer sid) {
		studentrepository.deleteById(sid);
	}

	

	
	 

}
