package com.student.dao;

import java.util.List;
import java.util.Map;

import com.student.entity.StudentEntity;

public interface StudentDao {
	
	void insert(StudentEntity student);
	
	void cleanUp();
	
	List<StudentEntity> viewAllStudent();
	
	List<StudentEntity> viewAllStudentBeanPropertyRM();
	
	List<StudentEntity> viewAllStdResultSetExtractor();
	
	Map<String,List<String>> groupStudentsByAddress();
	
	int updateStudent(StudentEntity student);

	int updateMultipleStudents(List<StudentEntity> studentList);
}
