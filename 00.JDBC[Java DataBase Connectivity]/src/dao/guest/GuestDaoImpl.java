package dao.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(10)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
 */
public class GuestDaoImpl implements GuestDao{
	
	public GuestDaoImpl() throws Exception{
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		
		Guest guest = null;
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
		
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int guest_no = rs.getInt("guest_no");
			String guest_name = rs.getString("guest_name");
			String guest_date = rs.getString("guest_date");
			String guest_email = rs.getString("guest_email");
			String guest_homepage = rs.getString("guest_homepage");
			String guest_title = rs.getString("guest_title");
			String guest_content = rs.getString("guest_content");
			
			guest = new Guest(guest_no, guest_name, guest_date, guest_email, guest_homepage, guest_title, guest_content);
			
		}
		rs.close();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return guest;
		
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		
		ArrayList<Guest> guestList = new ArrayList<Guest>(); 
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int guest_no = rs.getInt("guest_no");
			String guest_name = rs.getString("guest_name");
			String guest_date = rs.getString("guest_date");
			String guest_email = rs.getString("guest_email");
			String guest_homepage = rs.getString("guest_homepage");
			String guest_title = rs.getString("guest_title");
			String guest_content = rs.getString("guest_content");
			
			guestList.add(new Guest(guest_no, guest_name, guest_date, guest_email, guest_homepage, guest_title, guest_content));
		}
		rs.close();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		
		int updateRowCount = pstmt.executeUpdate();
		
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return updateRowCount;
		
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		
		pstmt.setInt(1, no);
		
		int deleteRowCount = pstmt.executeUpdate();
		
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deleteRowCount;
	}

}