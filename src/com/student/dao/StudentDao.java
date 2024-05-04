package com.student.dao;

import com.student.entity.StudentEntity;

public interface StudentDao {
	
	void insert(StudentEntity student);
	
	void cleanUp();

}
