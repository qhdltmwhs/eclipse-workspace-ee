package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class JDBCFlowMain_Test {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String id = "javabackend22";
		String password = "javabackend22";
		
		String sql = "select * from emp"; 
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, id, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hireDate = rs.getDate("hiredate");
			String sal = rs.getString("sal");
			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t" + sal + "\t");
		}
		rs.close();
		st.close();
		con.close();
		

	}

}
