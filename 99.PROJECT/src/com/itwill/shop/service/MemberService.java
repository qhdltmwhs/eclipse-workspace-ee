package com.itwill.shop.service;


import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.dao.MemberDao;
import com.itwill.shop.vo.Member;

/*
 * - 회원관리 비즈니스로직(업무)을 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스
 * - Dao객체 를 이용해서 데이타에 접근하는 클래스
 */
public class MemberService {
	private MemberDao memberDao;

	
	public MemberService() {
		memberDao=new MemberDao();
	}
	
	/*
	 * 회원가입
	 */
	public boolean memberRegister(Member newMember) throws Exception {
		/*
		 * 아이디존재여부체크
		 *     - 존재하면 메세지
		 *     - 존재안하면 가입(DB저장).
		 */
		boolean isRegister=false;
		if(!isExistedId(newMember.getM_id())) {
			//아이디중복안됨-->가입
			memberDao.create(newMember);
			isRegister=true;
		}else {
			//아이디중복
			isRegister=false;
		}
		return isRegister;
	}
	/*
	 * 회원탈퇴
	 */
	public int memberUnRegister(String id) throws Exception{
		return memberDao.deleteById(id);
	} 
	
	
	/*
	 *아이디 존재여부
	 */
	public boolean isExistedId(String id)  throws Exception{
		boolean isExisted=false;
		Member member = memberDao.selectById(id);
		if(member==null) {
			isExisted=false;
		}else if(member!=null) {
			isExisted=true;
		}
		return isExisted;
	}
	
	
	
	
	/*
	 * 로그인
	 */
	public int login(String id,String password) throws Exception{
		/*
		 * 0.성공
		 * 1.아이디존재안함
		 * 2.패쓰워드불일치
		 */
		int result=-9999;
		if(isExistedId(id)) {
			//아이디존재(회원인경우)
			Member findMember = memberDao.selectById(id);
			if(findMember.getM_password().equals(password)) {
				//패드워드일치
				result=0;
			}else {
				//패드워드불일치
				result=2;
			}
		}else {
			//아이디존재안함
			result=1;
		}
		return result;
	}
	/*
	 * 로그아웃
	 */
	public void logout() {
		
	}
	
	/*
	 * 회원상세보기
	 * (회원아이디로 1명 검색)
	 */
	public Member findById(String id) throws Exception{
		return memberDao.selectById(id);
	}
	/*
	 * 회원 전체     검색
	 * 회원 이름으로 검색
	 * 회원 주소로   검색
	 * 회원 나이로   검색
	 */
	public List<Member> findByAll()throws Exception{
		return memberDao.selectAll();
	}
	public ArrayList<Member> findByName(String name){
		return memberDao.selectByName(name);
	}
	
	/*
	 * 회원수정
	 */
	public int memberUpdate(Member member) throws Exception{
		return memberDao.updateById(member);
	}

}