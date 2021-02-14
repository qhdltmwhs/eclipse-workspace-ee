  
package com.itwill.shop.test;

import com.itwill.shop.service.MemberService;
import com.itwill.shop.vo.Member;

public class MemberServiceTestMain {

	public static void main(String[] args) throws Exception{
		MemberService memberService=new MemberService();
		System.out.println("1.isExistedId:"+memberService.isExistedId("apple"));
		boolean isSuccess=
				memberService.memberRegister(new Member("apple", "apple", "사과", "충주시", 23, "F", null));
		System.out.println("2.memberRegister:"+isSuccess);
		System.out.println("3.login:"+memberService.login("apple", "apple"));
		Member findMember=memberService.findById("apple");
		System.out.println("3.findById:"+findMember);
		findMember.setM_name("배");
		findMember.setM_address("안성시");
		findMember.setM_age(45);
		System.out.println("4.memberUpdate:"+memberService.memberUpdate(findMember));
		System.out.println("5.findAll:"+memberService.findByAll());
		
		
	}

}