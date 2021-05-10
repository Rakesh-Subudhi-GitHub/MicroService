package com.rk.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.rk.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDAO {
	
	private static final String KEY="Student";

	//ref Type,key,value
	@Resource(name = "rt")//inject the RedisTemplate 
	private HashOperations<String,Integer,Student> hashOper; 
	
	@Override
	public String addStudent(Student stud) {
		
		// TO Create a new Student Record add here
		hashOper.putIfAbsent(KEY, stud.getStudId(), stud);
		
		return "record is Sussesfully added ";
	}

	@Override
	public String modifyStudent(Student stud) {
		
		// TO UPADTE Student Record 
		hashOper.put(KEY, stud.getStudId(), stud);
				
		return "record is Sussesfully added ";
	}

	@Override
	public Student getOneStudent(Integer studId) {
	
		//read a particular Student data
		return hashOper.get(KEY, studId);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {
		
		//read all data in Student data
		return hashOper.entries(KEY);
	}

	@Override
	public String removeStudent(Integer studId) {
		
		//delete a particular Student record
	    hashOper.delete(KEY, studId);
	    
	    return "Record delete Successfully";
	}

}//class
