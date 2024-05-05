package com.student.dao;

import java.util.List;

import com.student.entity.StudentEntity;

public interface StudentDao {
	
	void insert(StudentEntity student);
	
	void cleanUp();
	
	List<StudentEntity> viewAllStudent();
	
	List<StudentEntity> viewAllStudentBeanPropertyRM();

}
