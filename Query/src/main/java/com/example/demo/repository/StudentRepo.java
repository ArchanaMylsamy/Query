package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.StudentEntity;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
	@Query(value="select * from student_demo ",nativeQuery=true)
	public List<StudentEntity> getAllStudent();
	//Deletion in JPQL
    @Modifying
	@Transactional
	@Query(value="DELETE FROM student_demo where stu_id = :i",nativeQuery = true)
	Integer deleteByStudentId(@Param("i")int stu_id);
  //Updating in JPQL
    @Modifying
    @Transactional
    @Query(value="UPDATE student_demo d set d.stu_name=:sn WHERE d.stu_id=:i",nativeQuery=true)
    public Integer updateByStudentId(@Param("sn")String stu_name,@Param("i")int stu_id);
}