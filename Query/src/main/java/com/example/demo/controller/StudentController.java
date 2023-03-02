package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired //extends another class
         StudentService stuService;
	
	@PostMapping("/addDetails")
	
	public StudentEntity addInfo(@RequestBody StudentEntity st) {
		return stuService.saveDetails(st);
	}
	@GetMapping("/showDetails")
	public List<StudentEntity>fetchDetails()
	{
		return stuService.getDetails();
	}
	@PutMapping("/UpdateDetails")
	public StudentEntity UpdateInfo(@RequestBody StudentEntity st1)
	{
		return stuService.UpdateDetails(st1);
	}
	@DeleteMapping("/delete/{sid}")
	public String deleteInfo(@PathVariable("sid")int sid)
	{
		stuService.deleteDetails(sid);
		return "Deleted details";
	}
	//display JPQL
			@GetMapping("/s")
			public List<StudentEntity> displayAllStudent(){
				return stuService.allStudent();
			}
			//deletion in JPQL
			@DeleteMapping("/del/{stu_id}")
			public Integer delete(@PathVariable ("stu_id")int stu_id) {
				return stuService.delete(stu_id);
			}
			//updating in JPQL
			@PutMapping("/update/{stu_id}/{stu_name}")
			public String update(@PathVariable ("stu_id")int stu_id,@PathVariable("stu_name")String stu_name) {
				return stuService.update(stu_name,stu_id)+" updated";
			}
}