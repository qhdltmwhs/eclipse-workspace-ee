package com.itwill.address;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AddressDao {
	
	
	public int deleteByNo(int no) throws Exception{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		
		pstmt.setInt(1, no);
		int deleteRowCount = pstmt.executeUpdate();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return  deleteRowCount;
	}
	
	public int insert(Address address) throws Exception{
		
											
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement  pstmt=con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1,address.getId());
		pstmt.setString(2,address.getName());
		pstmt.setString(3,address.getPhone());
		pstmt.setString(4,address.getAddress());
		int insertRowCount=pstmt.executeUpdate();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}
	
	
	public ArrayList<Address> selectAll() throws Exception{
		ArrayList<Address> addressList=new ArrayList<Address>();
		
		
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement  pstmt=con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int no=rs.getInt("no");
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			addressList.add(new Address(no, id, name, phone, address));
		}
		rs.close();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		
		return addressList;
	}
	public Address selectByNo(int no)throws Exception{
		
		Address findAddress=null;
		
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_SELECT_PK);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			findAddress=new Address(no, id, name, phone, address);
		}
		rs.close();
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return findAddress;
	}
	
	public int updateByNo(Address address) throws Exception{
		
							
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		pstmt.setString(1,address.getId());
		pstmt.setString(2,address.getName());
		pstmt.setString(3,address.getPhone());
		pstmt.setString(4,address.getAddress());
		pstmt.setInt(5,address.getNo());
		int updateRowCount = pstmt.executeUpdate();
	
		pstmt.close();
		
		ConnectionFactory.releaseConnection(con);
		return updateRowCount;
	}
}