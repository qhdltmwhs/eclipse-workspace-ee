package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentById-------");
		
		System.out.println("---------findAllStudents---------");
		
		System.out.println("-------findStudentByIdResultMap-------");
	
		System.out.println("---------insertStudent(Dto)--------------");
	
		System.out.println("---------insertStudentBySequence1---------");
		
		System.out.println("---------insertStudentBySequence2---------");
		
		System.out.println("---------updateStudent-------------------");
		
		
		System.out.println("---------deleteStudentById------------------");
		
		System.out.println("---------findStudentByIdWithAddress----------");
		
		System.out.println("---------findStudentByIdWithCourses----------");
		System.out.println("---------findStudentNameList----------");
		System.out.println("---------findStudentNameById----------");
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("------------findAllStudentsMapList-------------");
		System.out.println("---------updateStudentParamMap(parameter Map)----");
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)----");
		System.out.println("---------findStudentsThreeParamMap(parameter Map)----");
		/*
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		*/
	}
}
