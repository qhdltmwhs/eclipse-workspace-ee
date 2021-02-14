package statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;


public class PreparedStatementMain {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend22";
		String password = "javabackend22";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		
		String insertSql1 = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
		
		
		/*
		PreparedStatement pst = con.prepareStatement(insertSql1);
		pst.setInt(1, 1234);
		pst.setString(2, "ALICE");
		pst.setString(3, "CLERK");
		pst.setInt(4, 7369);
		pst.setDate(5, new Date(System.currentTimeMillis()));
		pst.setDouble(6, 8000.89);
		pst.setDouble(7, 0);
		pst.setInt(8, 10);
		int rowCount = pst.executeUpdate();
		System.out.println(rowCount + " 행 insert...");
		*/
		/*
		String insertSql2 = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,sysdate,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(insertSql2);
		pst.setInt(1, 9000);
		pst.setString(2, "TOM");
		pst.setString(3, "SALESMAN");
		pst.setInt(4, 7369);
		pst.setDouble(5, 7878.89);
		pst.setNull(6, Types.DOUBLE);
		pst.setNull(7, Types.INTEGER);
		int rowCount = pst.executeUpdate();
		System.out.println(rowCount + " 행 insert...");
		*/
		/*
		String insertSql3 = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,to_date(?,?),?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(insertSql3);
		pst.setInt(1, 9001);
		pst.setString(2, "UNCLETOM");
		pst.setString(3, "MANAGER");
		pst.setInt(4, 7369);
		pst.setString(5, "2000/02/12");
		pst.setString(6, "YYYY/MM/DD");
		pst.setDouble(7, 30000);
		pst.setDouble(8, 200);
		pst.setInt(9, 30);
		int rowCount = pst.executeUpdate();
		System.out.println(rowCount + " 행 insert...");
		*/
		/*
		String insertSql4 = "insert into emp values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(insertSql4);
		pst.setInt(1, 9002);
		pst.setString(2, "GUARD");
		pst.setString(3, "OPERATOR");
		pst.setInt(4, 7369);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date hireDate = sdf.parse("2020/12/25");
		pst.setDate(5, new java.sql.Date(hireDate.getTime()));
		pst.setDouble(6, 90000);
		pst.setDouble(7, 999);
		pst.setInt(8, 30);
		int rowCount = pst.executeUpdate();
		System.out.println(rowCount + " 행 insert...");
		*/
		
		int startSal = 1000;
		int endSal = 2000;
		String job = "SALESMAN";
		
		String selectSql = "select * from emp where sal >= "+startSal+" and sal <= "+endSal+"and job = '"+job+"'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(selectSql);
		
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String jobs = rs.getString("job");
			double sal = rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
		}
		rs.close();
		
		String selectSql2 = "select * from emp where sal >= ? and sal <= ? and job = ?";
		PreparedStatement pst = con.prepareStatement(selectSql2);
		pst.setInt(1, startSal);
		pst.setInt(2, endSal);
		pst.setString(3, job);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String jobs = rs.getString("job");
			double sal = rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
			
		}
		rs.close();
		
		
		
		
	}	
}
