package com.itwill.shop.jumun.test;

import com.itwill.shop.jumun.JumunDao;

public class JumunDaoTestMain {

	public static void main(String[] args) throws Exception{
		JumunDao jumunDao=new JumunDao();
		System.out.println(jumunDao.list("guard1"));
		
	}

}
