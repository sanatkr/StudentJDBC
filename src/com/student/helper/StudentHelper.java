package com.student.helper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.entity.StudentEntity;

@Service("studentHelper")
public class StudentHelper {
	
	public StudentHelper()
	{
		System.out.println("StudentHelper object created");
	}
	
	public void viewAllStudents(List<StudentEntity> students)
	{
		for(StudentEntity st:students)
		{
			System.out.println(st);
		}
	}
	

}
