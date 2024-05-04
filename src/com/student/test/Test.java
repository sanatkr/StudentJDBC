package com.student.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;
import com.student.entity.StudentEntity;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loaded....");
		
		StudentDaoImpl studentDao = context.getBean("studentDao",StudentDaoImpl.class);
		
		//Cleaning the complete student table
		studentDao.cleanUp();
		StudentEntity student = new StudentEntity();
		student.setRollNo(3);
		student.setName("Rajiv");
		student.setAddress("Ranchi");
		
		studentDao.insert(student);
	
		
		
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
