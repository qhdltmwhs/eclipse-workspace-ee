package dao.guest;

public class GuestSQL {
	/*
	 insert into GUEST values(guest_no_seq.nextval , '김경호', sysdate, 'guard@naver.com', 'http://', '방명록 사용법', '방명록처럼 사용하시면 됩니다');
	 select * from guest where guest_no=3;
	 select * from guest;
	 update guest set guest_name='김경자', guest_email='kkk@daum.net', guest_homepage='http://수정', guest_title='난감하네', guest_content='정말난감하네'
	 where guest_no = 3;
	 delete guest where guest_no=1;
	 */
	
	public static final String GUEST_INSERT="insert into guest values(guest_no_seq.nextval, ?, sysdate, ?, ?, ?, ?, ?)";
	public static final String GUEST_DELETE="delete guest where guest_no=?";
	public static final String GUEST_UPDATE="update guest set guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
	public static final String GUEST_SELECT_NO="select * from guest where guest_no=?";
	public static final String GUEST_SELECT_ALL="select * from guest";
}