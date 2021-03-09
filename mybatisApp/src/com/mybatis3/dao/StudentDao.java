package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	public StudentDao() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = 
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*@@@@@@@@@@@@@@@@@@@@@@@SELECT@@@@@@@@@@@@@@@@@*/
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student findStudent=
				sqlSession.selectOne(NAMESPACE+"findStudentById",studId);
		sqlSession.close();
		return findStudent;
	}
	public List<Student> findAllStudents() {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudents");
		sqlSession.commit();
		sqlSession.close();
		return studentList;
	}
	public String findStudentNameById(Integer userId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		String studentName=
				sqlSession.selectOne(NAMESPACE+"findStudentNameById",userId);
		sqlSession.commit();
		sqlSession.close();
		return studentName;
	}
	public List<String> findStudentNameList() {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		List<String> studentNameList=
				sqlSession.selectList(NAMESPACE+"findStudentNameList");
		sqlSession.commit();
		sqlSession.close();
		return studentNameList;
	}
	
	
}












