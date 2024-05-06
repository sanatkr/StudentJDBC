package com.student.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.dao.StudentDaoImpl;
import com.student.entity.StudentEntity;
import com.student.helper.StudentHelper;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loaded....");
		
		StudentDaoImpl studentDao = context.getBean("studentDaoImpl",StudentDaoImpl.class);
		StudentHelper studentHelper = context.getBean("studentHelper",StudentHelper.class);
		
		//Cleaning the complete student table
//		studentDao.cleanUp();
//		
//		StudentEntity student = new StudentEntity();
//		student.setRollNo(3);
//		student.setName("Rajiv");
//		student.setAddress("Ranchi");
//		
//		studentDao.insert(student);
		
		System.out.println("\nViewing all students using RowMapper class :");
		List<StudentEntity> allStudents = studentDao.viewAllStudent();
		studentHelper.viewAllStudents(allStudents);
		
		System.out.println("\nViewing all students using bean PropertyRowMapper class :-\n");
		List<StudentEntity> allStudentBeanPropertyRM = studentDao.viewAllStudentBeanPropertyRM();
		studentHelper.viewAllStudents(allStudentBeanPropertyRM);
		
		System.out.println("\nViewing all students using ResultSetExtractor class :-\n");
		List<StudentEntity> viewAllStdResultSetExtractor = studentDao.viewAllStdResultSetExtractor();
		studentHelper.viewAllStudents(viewAllStdResultSetExtractor);
		
		
		System.out.println("\nGrouping students by address using ResultSetExtractor class :-\n");
		Map<String, List<String>> groupStudentsByAddress = studentDao.groupStudentsByAddress();
		System.out.println(groupStudentsByAddress);
		
	
		
//		StudentEntity student = new StudentEntity();
//		student.setRollNo(2);
//		student.setName("Aman");
//		student.setAddress("Muz");
//		
//		StudentDao studentDao = new StudentDaoImpl();
//		studentDao.insert(student);
//		

	}

}
