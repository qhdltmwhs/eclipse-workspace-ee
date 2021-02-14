package dao.member;

public class MemberSQL {
	
	public static final String MEMBER_INSERT=
			"insert into member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) values(?,?,?,?,?,?,sysdate)";
			public static final String MEMBER_UPDATE=
			"update member set m_password=?,m_name=?,m_address=?,m_age=?,m_married=? where m_id=?";
			public static final String MEMBER_DELETE=
			"delete member where m_id=?";
			public static final String MEMBER_SELECT_ID=
			"select m_id, m_password, m_name, m_address, m_age, m_married, m_regdate from member where m_id=?";
			public static final String MEMBER_SELECT_ALL=
			"select m_id, m_password, m_name, m_address, m_age, m_married, m_regdate from member";
}
