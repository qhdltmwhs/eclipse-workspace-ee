package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressSelectByNoMain {

	public static void main(String[] args) throws Exception {
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
			/*
			 *  DB 
			 *  	number   ---> int, double
			 *  	varchar2 ---> String
			 *  	date     ---> Date
			 *  	XXX var = rs.getXXX("컬럼이름")
			 */
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

}
