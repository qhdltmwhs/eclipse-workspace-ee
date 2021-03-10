package com.itwill.guest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class GuestDaoImplMyBatis implements GuestDao {
	/*
	이름             널?       유형             
	-------------- -------- -------------- 
	GUEST_NO       NOT NULL NUMBER(10)     
	GUEST_NAME     NOT NULL VARCHAR2(100)  
	GUEST_DATE     NOT NULL DATE           
	GUEST_EMAIL             VARCHAR2(100)  
	GUEST_HOMEPAGE          VARCHAR2(100)  
	GUEST_TITLE    NOT NULL VARCHAR2(255)  
	GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
	 */
	private SqlSessionFactory sqlSessionFactory;
	public GuestDaoImplMyBatis() throws Exception{
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
	
	@Override
	public int insertGuest(Guest guest) throws Exception {
		int insertRowCount=0;
		
		return insertRowCount;
	}
	
	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest=null;
		
		return guest ;
	}
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		List<Guest> guestList=new ArrayList<Guest>();
		SqlSession sqlSession=sqlSessionFactory.openSession();
		guestList = sqlSession.selectList("com.itwill.guest.mapper.GuestMapper.selectAll");
		return (ArrayList<Guest>)guestList;
	}
	
	@Override
	public int updateGuest(Guest guest) throws Exception {
		int updateRowCount=0;
		
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		int deleteRowCount=0;
		
		return deleteRowCount;
	}
}















