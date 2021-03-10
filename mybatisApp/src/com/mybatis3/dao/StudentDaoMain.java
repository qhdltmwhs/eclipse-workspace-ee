package com.mybatis3.dao;

import java.util.Date;
import java.util.Map;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(studentDao.findStudentById(1));
		System.out.println(studentDao.findStudentById(5));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(studentDao.findAllStudents());
		System.out.println("---------findStudentNameById-------------------------");
		System.out.println(studentDao.findStudentNameById(3));
		System.out.println("---------findStudentNameList-------------------------");
		System.out.println(studentDao.findStudentNameList());
		System.out.println("---------findStudentByIdMap--------------------------");
		Map studentMap = studentDao.findStudentByIdMap(1);
		System.out.println(studentMap.get("STUD_ID")+" "+
						   studentMap.get("NAME")+" "+
				           studentMap.get("EMAIL")+" "
						   +studentMap.get("DOB"));
		
		System.out.println("---------findAllStudentsMapList----------------------");
		System.out.println(studentDao.findAllStudentsMapList());
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println(studentDao.findStudentByIdResultMap(3));
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println(studentDao.findAllStudentsResultMap());
		System.out.println("---------insertStudent(Dto)--------------------------");
		//System.out.println(studentDao.insertStudent(new Student(1000, "김천천", "1000@1000.co.kr", new Date())));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student1=new Student(null, "김시퀀스1", "seq1@gmail.com", new Date());
		System.out.println(studentDao.insertStudentBySequence1(student1));
		System.out.println("insert PK:"+student1.getStudId());
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student2=new Student(null, "김시퀀스2", "seq2@gmail.com", new Date());
		System.out.println(studentDao.insertStudentBySequence2(student2));
		System.out.println("insert PK:"+student2.getStudId());
		System.out.println("---------updateStudentById---------------------------");
		System.out.println(studentDao.updateStudentById(new Student(7, "김변경", "change@naver.com", new Date()) ));
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println(studentDao.deleteStudentById(19));
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println(studentDao.deleteStudentByName("김시퀀스1"));
		System.out.println("---------deleteStudentByNameLike---------------------");
		System.out.println(studentDao.deleteStudentByNameLike("시퀀스"));
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println(studentDao.findStudentByIdWithAddress(1));
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println(studentDao.findStudentByIdWithCourses(1));
		System.out.println("---------findAllOrderedStudents------------------");
		System.out.println(studentDao.findAllOrderedStudents("name desc"));
		System.out.println(studentDao.findAllOrderedStudents("email asc"));
		System.out.println(studentDao.findAllOrderedStudents("dob desc"));
		
		
		
		System.out.println("---------updateStudentParamMap(parameter Map)--------");
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)-");
		System.out.println("---------findStudentsThreeParamMap(parameter Map)----");
		/*
		
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		*/
	}
}
