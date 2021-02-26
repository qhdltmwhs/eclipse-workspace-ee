package com.itwill.user;

import java.util.ArrayList;

import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

/*
 * - 회원관리 비즈니스로직(예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴퍼넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스
 * - Dao를 이용해서 데이타베이스를 조작작업하는 클래스
 */
public class UserService {
	private UserDao userDao;
	public UserService() throws Exception {
		userDao=new UserDao();
	}
	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception {
		//1.아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			throw new ExistedUserException(user.getUserId()+" 는 이미존재하는 아이디입니다.");
		}
		return userDao.create(user);
	}
	/*
	 * 회원로그인
	 */
	public User login(String userId, String password)throws Exception{
		//1.아이디 존재여부(null인경우)
		User user = userDao.findUser(userId);
		if(user==null) {
			throw new UserNotFoundException(userId+" 는 존재하지않는 아이디입니다.");
		}
		//2.패스워드 일치여부(일치하지 않느경우)
		if(!user.isMatchPassword(password)) {
			throw new PasswordMismatchException("패스워드가 일치하지 않습니다.");
		}
		return user;
	}	
	/*
	 * 회원전체리스트	
	 */
	public ArrayList<User> findUserList() throws Exception{
		return userDao.findUserList();
	}
	/*
	 * 회원1명보기
	 */
	public User findUser(String userId)throws Exception{
		User findUser = userDao.findUser(userId); 
		return findUser;		
	}
	/*
	 * 회원수정
	 */
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
	/*
	 * 회원삭제
	 */
	public int remove(String userId)throws Exception{
		return userDao.remove(userId);
	}
} 