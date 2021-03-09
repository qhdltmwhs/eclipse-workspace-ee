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
	/*@@@@@@@@@@@@@@@@@@@@@@@INSERT@@@@@@@@@@@@@@@@@*/
	public int insertStudent(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int row=sqlSession.insert(NAMESPACE+"insertStudent", student);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int row=sqlSession.insert(NAMESPACE+"insertStudentBySequence1", student);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	public int insertStudentBySequence2(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int row=sqlSession.insert(NAMESPACE+"insertStudentBySequence2", student);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	
	/*@@@@@@@@@@@@@@@@@@@@@@@SELECT@@@@@@@@@@@@@@@@@*/
	
	/*
	 resultMap 
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student findStudent=
				sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap",studId);
		sqlSession.close();
		return findStudent;
	}
	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.commit();
		sqlSession.close();
		return studentList;
	}
	
	/*
	 resultType Dto 
	*/
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
	/*
	 resultType Wrapper(String) 
	 */
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
	/*
	 resultType Map
	 */
	public Map findStudentByIdMap(Integer userId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Map studentMap=sqlSession.selectOne(NAMESPACE+"findStudentByIdMap",userId);
		sqlSession.close();
		return studentMap;
	}
	public List<Map> findAllStudentsMapList() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Map> studentMapList=sqlSession.selectList(NAMESPACE+"findAllStudentsMapList");
		sqlSession.close();
		return studentMapList;
	}
	
}












