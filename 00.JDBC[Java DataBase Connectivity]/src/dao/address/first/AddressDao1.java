package dao.address.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
Dao(Data Access Object)
 - Address들의 데이터를 저장하고있는 Address 테이블에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스
 - AddressService객체의 요청(메쏘드호출)을 받아서 
   Data Access(DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */
public class AddressDao1 {
	public void deleteByNo() throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend92";
		String password = "javabackend92";
		String deleteSql =
				"delete address where no = 8";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		int deleteRowCount = st.executeUpdate(deleteSql);
		System.out.println(deleteRowCount + "행 delete");
		st.close();
		con.close();
	}
	public void insert() throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend72";
		String password = "javabackend72";
		String insertSql =
				"insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시')";
		
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		
		
		int rowCount = st.executeUpdate(insertSql);
		System.out.println(rowCount + "행 insert");
		
		st.close();
		con.close();
	}
	public void selectAll() throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend72";
		String password = "javabackend72";
		String selectSql =
				"select no, id, name, phone, address from address";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(selectSql);
		
		//boolean isExist = rs.next();
		
		while(rs.next()) {
			
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		
		rs.close();
		st.close();
		con.close();
	}
	public void selectByNo() throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend72";
		String password = "javabackend72";
		String selectSql =
				"select no, id, name, phone, address from address where no = 3";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(selectSql);
		
		//boolean isExist = rs.next();
		if(rs.next()) {
			
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		
		rs.close();
		st.close();
		con.close();

	}
	public void updateByNo() throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend72";
		String password = "javabackend72";
		String updateSql =
				"update address set id = 'yyyy', name = '김경숙', phone = '899-9999', address = 'LA' where no = 10";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		int updateRowCount = st.executeUpdate(updateSql);
		System.out.println(updateRowCount + "행 update");
		st.close();
		con.close();
	}
}
