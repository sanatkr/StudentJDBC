package com.student.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.student.entity.StudentEntity;

public class StudentResultSetExtractor implements ResultSetExtractor<List<StudentEntity>> {

	@Override
	public List<StudentEntity> extractData(ResultSet res) throws SQLException, DataAccessException {
		
		List<StudentEntity> studentList = new ArrayList<>();
		while(res.next())
		{
			StudentEntity student = new StudentEntity();
			student.setRollNo(res.getInt("Roll_No"));
			student.setName(res.getString("Student_name"));
			student.setAddress(res.getString("Student_address"));
			
			studentList.add(student);
		}
		return studentList;
	}

	

}
