package com.itwill.shop.jumun;

import java.util.ArrayList;

public class JumunService {
	private JumunDao jumunDao;
	public JumunService() throws Exception{
		jumunDao=new JumunDao();
	}
	/*
	 * 주문목록
	 */
	public ArrayList<Jumun> list(String sUserId) throws Exception{
		return jumunDao.list(sUserId);
	}
	/*
	 * 주문상세보기
	 */
	public Jumun detail(String sUserId,int j_no)throws Exception{
		return jumunDao.detail(sUserId,j_no);
	}
	
}