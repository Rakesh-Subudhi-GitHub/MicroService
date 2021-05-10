package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.dao.IStudentDAO;
import com.rk.model.Student;

@Component
public class RunnerClass implements CommandLineRunner{

	@Autowired
	private IStudentDAO studDao;
	
	@Override
	public void run(String... args) throws Exception {
		
//		studDao.addStudent(new Student(100,"Rakesh",850.55));
//		studDao.addStudent(new Student(101,"Raka",260.55));
//		studDao.addStudent(new Student(102,"Raja",789.55));
		
		studDao.getAllStudent().forEach((k,v)->System.out.println(k+" "+v));
	}

}
