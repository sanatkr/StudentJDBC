package com.student.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.student.entity.StudentEntity;

public class StudentDaoImpl implements StudentDao{

	//JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insert(StudentEntity student) {
		
		String query = "INSERT INTO STUDENT VALUES(?,?,?)";
		
		Object[] args = {student.getRollNo(),student.getName(),student.getAddress()};
		
		int noOfRowsInserted = jdbcTemplate.update(query,args);
		
		System.out.println("No of inserted row is --> "+noOfRowsInserted);
		
	}
	
	

	private DataSource getDataSource() {
		
		String url = "jdbc:mysql://localhost:3306/school";
		String username = "root";
		String password = "root";
			
		DataSource dataSource = new DriverManagerDataSource(url,username,password);
		
		return dataSource;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public void cleanUp() {

		String query = "TRUNCATE TABLE STUDENT";
		
		jdbcTemplate.execute(query);
		
	}
	
	
	

}
