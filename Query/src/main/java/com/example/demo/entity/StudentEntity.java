package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentDemo")
public class StudentEntity {
	@Id
	@Column(name="stu_id")
           private int stu_id;
	@Column(name="stu_name")
           private String stu_name;
		public int getStu_id() {
			return stu_id;
		}
		public void setStu_id(int stu_id) {
			this.stu_id = stu_id;
		}
		public String getStu_name() {
			return stu_name;
		}
		public void setStu_name(String stu_name) {
			this.stu_name = stu_name;
		}
		public StudentEntity(int stu_id, String stu_name) {
			super();
			this.stu_id = stu_id;
			this.stu_name = stu_name;
		}
		public StudentEntity() {
			
		}
           
		
}