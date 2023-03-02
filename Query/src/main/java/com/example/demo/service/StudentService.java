package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
@Service
public class StudentService {
	@Autowired //extends another class
    StudentRepo stRepo; //reference variable
	
	public StudentEntity saveDetails(StudentEntity e) {
		return stRepo.save(e);
	}
	public List <StudentEntity>getDetails()

{
		return stRepo.findAll();
		
}
	public StudentEntity UpdateDetails(StudentEntity e1)
	{
		return stRepo.saveAndFlush(e1);
	}
	public void deleteDetails(int id)
	{
		stRepo.deleteById(id);
	}
	//display JPQL 
			public List<StudentEntity> allStudent(){
				return stRepo.getAllStudent();
			}
			//deletion in JPQL
			public Integer delete(int id ) {
				return stRepo.deleteByStudentId(id);
			}
			//updating in JPQL
			public Integer update(String name,int id) {
				return stRepo.updateByStudentId(name,id);
			}
}