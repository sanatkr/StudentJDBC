package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.student.entity.StudentEntity;

public class StudentMapper implements RowMapper<StudentEntity> {

	@Override
	public StudentEntity mapRow(ResultSet res, int row) throws SQLException {
		
		StudentEntity student = new StudentEntity();
		
		student.setRollNo(res.getInt("Roll_NO"));
		student.setName(res.getString("Student_name"));
		student.setAddress(res.getString("Student_address"));
		
		System.out.println("mapRow() method called for student --> "+student);
		
		return student;
	}

	

}
