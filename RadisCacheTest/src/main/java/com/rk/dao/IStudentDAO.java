package com.rk.dao;

import java.util.Map;

import com.rk.model.Student;

public interface IStudentDAO {

	public String addStudent(Student stud);
	public String modifyStudent(Student stud);
	public Student getOneStudent(Integer studId);
	public Map<Integer,Student> getAllStudent();
	public String removeStudent(Integer studId);
	
}
