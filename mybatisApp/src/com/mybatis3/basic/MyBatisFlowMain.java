package com.mybatis3.basic;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0. mybatis-config.xml --> InputStream
		 */
		InputStream mybatisConfigInputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		/*
		 * 3. SqlSession open
		 */
		SqlSession sqlSession=sqlSessionFactory.openSession();
		/*
		 * autocommit true
		 */
		/*
		 * 4. SqlSession사용(CRUD)
		 */
		System.out.println("#### SqlSession객체:"+sqlSession);
		Student student= 
				sqlSession.selectOne("com.mybatis3.dao.mapper.StudentMapper.findStudentById",new Integer(1));
		System.out.println("#### findStudent:"+student);
		List<Student> studentList=sqlSession.selectList("com.mybatis3.dao.mapper.StudentMapper.findAllStudents");
		System.out.println("#### studentList:"+studentList);
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
	}
}













