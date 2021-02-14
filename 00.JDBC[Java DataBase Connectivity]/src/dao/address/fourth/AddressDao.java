package dao.address.fourth;
/*
Dao(Data Access Object)
 - Address���� �����͸� �����ϰ��ִ� Address ���̺�
   CRUD(Create, Read, Update, Delete) �۾��� �Ҽ��ִ�
   ����(???)�޽�带 �������ִ� Ŭ����
 - AddressService��ü�� ��û(�޽��ȣ��)�� �޾Ƽ� 
   Data Access(DB)�� ���õ� �������(CRUD)��
   �����ϴ� ��ü
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressDao {
	/****************DB��������*************/
	private String driverClass="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
	private String user="javabackend92";
	private String password="javabackend92";
	
	public int deleteByNo(int no) throws Exception{
		String deleteSql="delete address where no="+no;
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		int deleteRowCount = stmt.executeUpdate(deleteSql);
		stmt.close();
		con.close();
		return  deleteRowCount;
	}
	
	public int insert(Address address) throws Exception{
		String insertSql=
				"insert into address values(address_no_seq.nextval,'"
											+address.getId()+"','"
											+address.getName()+"','"
											+address.getPhone()+"','"
											+address.getAddress()+"')";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement  stmt=con.createStatement();
		int insertRowCount=stmt.executeUpdate(insertSql);
		stmt.close();
		con.close();
		return insertRowCount;
	}
	
	
	public ArrayList<Address> selectAll() throws Exception{
		ArrayList<Address> addressList=new ArrayList<Address>();
		String selectSql = "select no,id,name,phone,address from address";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectSql);
		while(rs.next()) {
			int no=rs.getInt("no");
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			addressList.add(new Address(no, id, name, phone, address));
		}
		rs.close();
		stmt.close();
		con.close();
		
		return addressList;
	}
	public Address selectByNo(int no)throws Exception{
		String selectSql = "select no,id,name,phone,address from address where no="+no;
		Address findAddress=null;
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectSql);
		if(rs.next()) {
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			findAddress=new Address(no, id, name, phone, address);
		}
		rs.close();
		stmt.close();
		con.close();
		return findAddress;
	}
	
	public int updateByNo(Address address) throws Exception{
		String updateSql="update address set id='"+
							address.getId()+"',name='"+
							address.getName()+"',phone='"+
							address.getPhone()+"',address='"+
							address.getAddress()+"' where no ="+
							address.getNo();
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		int updateRowCount = stmt.executeUpdate(updateSql);//�ڵ� commit
	
		stmt.close();
		con.close();
		return updateRowCount;
	}
}