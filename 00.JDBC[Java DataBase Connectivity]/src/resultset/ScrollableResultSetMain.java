package resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.address.ConnectionFactory;

public class ScrollableResultSetMain {

	public static void main(String[] args) throws Exception {
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user="javabackend22";
		String password="javabackend22";
		Connection con = ConnectionFactory.getConnection(driverClass, url, user, password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		/*
		 *  Cusor를 자유롭게  움직일수있는 ResultSet생성
		 */
		ResultSet rs = stmt.executeQuery("select * from emp order by empno desc");
		System.out.println("----------rs.next()----------");
		while (rs.next()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));
		}
		System.out.println("----------rs.previous()----------");
		while (rs.previous()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));
		}
		System.out.println("----------rs.first()----------");
		rs.first();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));
		
		System.out.println("----------rs.last()----------");
		rs.last();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));
		
		System.out.println("----------rs.beforeFirst()----------");
		rs.beforeFirst();
		//Exception in thread "main" java.sql.SQLException: 결과 집합을 모두 소모했음
		rs.next();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));
		
		System.out.println("----------rs.afterLast()----------");
		rs.afterLast();
		//Exception in thread "main" java.sql.SQLException: 결과 집합을 모두 소모했음
		if(rs.isBeforeFirst() || rs.isAfterLast()) {
			System.out.println("rs cusor가 beforeFirst or afterLast 에 위치해 있어요~~~");
		}
		
		System.out.println("----------rs행의 갯수----------");
		rs.last();
		int rowCount = rs.getRow();
		System.out.println("행의수 : "+rowCount);
		
		System.out.println("----------rs.absolute(row번호)----------");
		if(rs.absolute(3)) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal"));
		}
		rs.close();
	
	}

}