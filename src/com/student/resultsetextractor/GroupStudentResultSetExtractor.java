package com.student.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class GroupStudentResultSetExtractor implements ResultSetExtractor<Map<String,List<String>>>{

	@Override
	public Map<String, List<String>> extractData(ResultSet res) throws SQLException, DataAccessException {

		Map<String,List<String>> studentTableMap = new HashMap<>();
		
		while(res.next())
		{
			String studentName = res.getString("Student_name");
			String studentAddress = res.getString("Student_address");
			
			List<String> studentNameList = studentTableMap.get(studentAddress);
			
			if(studentNameList == null)
			{
				List<String> newStudentNameList = new ArrayList<>();
				newStudentNameList.add(studentName);
				studentTableMap.put(studentAddress, newStudentNameList);
			}
			else
			{
				studentNameList.add(studentName);
			}
		}
		return studentTableMap;
	}
	

}
