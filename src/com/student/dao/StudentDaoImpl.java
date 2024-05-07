package com.student.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;
import com.student.mapper.StudentMapper;
import com.student.resultsetextractor.GroupStudentResultSetExtractor;
import com.student.resultsetextractor.StudentResultSetExtractor;

@Repository
public class StudentDaoImpl implements StudentDao{

	//JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	
	@Autowired
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



	@Override
	public List<StudentEntity> viewAllStudent() {
		
		String selectSql = "SELECT * FROM STUDENT";
		
		List<StudentEntity> queryResult = jdbcTemplate.query(selectSql, new StudentMapper());
		return queryResult;
	}

	public List<StudentEntity> viewAllStudentBeanPropertyRM() {
		
		//String selectSql = "SELECT * FROM STUDENT";
		
		System.out.println("\nBeanPropertyRowMapper class used for mapping --->\n");
		
		String selectSql = "SELECT ROLL_NO as rollNo, STUDENT_NAME as name, STUDENT_ADDRESS as address FROM STUDENT";
		
		List<StudentEntity> queryResult = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class));
		return queryResult;
	}



	@Override
	public List<StudentEntity> viewAllStdResultSetExtractor() {
		
		String sql = "SELECT * FROM STUDENT";
		
		List<StudentEntity> queryResult = jdbcTemplate.query(sql, new StudentResultSetExtractor());
		return queryResult;
	}



	@Override
	public Map<String, List<String>> groupStudentsByAddress() {
		
		String sql = "Select * from student";
		Map<String, List<String>> query = jdbcTemplate.query(sql,new GroupStudentResultSetExtractor());
		return query;
	}



	@Override
	public int updateStudent(StudentEntity student) {
		
		String sql = "update student set Student_address=? where roll_no=?";
		
		int recordUpdated = this.jdbcTemplate.update(sql,student.getAddress(),student.getRollNo());
		
		return recordUpdated;
	}



	@Override
	public int updateMultipleStudents(List<StudentEntity> studentList) {
		
		String sql = "update student set student_address=? where roll_no=?";
		
		int[] batchUpdate = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				
				ps.setString(1, studentList.get(index).getAddress());
				ps.setInt(2, studentList.get(index).getRollNo());
				
				System.out.println("Insdie setValues() method ");
				
			}
			
			@Override
			public int getBatchSize() {
				
				System.out.println("Insdie getBatchSize() method ");
				return studentList.size();
			}
		});
		int updatedRecords = 0;
		for(int i=0;i<batchUpdate.length;i++)
		{
			if(batchUpdate[i]==1)
			{
				updatedRecords++;
			}
		}
		return updatedRecords;
	}
	
		

}
