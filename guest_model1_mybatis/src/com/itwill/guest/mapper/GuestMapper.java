package com.itwill.guest.mapper;

import java.util.List;

import com.itwill.guest.Guest;

public interface GuestMapper {
	/*
	 * 인터페이스의 풀네임은 GuestMapper.xml의 namespace와일치
	 * 메쏘드이름은 	GuestMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 GuestMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 GuestMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	public List<Guest> selectAll();
	/*
	<select id="selectAll" resultType="com.itwill.guest.Guest">
		select * from guest
	</select>
	 */
}
