package com.itwill.guest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * Connection객체생성과 해제 작업을 전담하는클래스
 */
public class ConnectionFactory {
	static String driverClass = "oracle.jdbc.OracleDriver";
	static String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	static String user = "javabackend0";
	static String password = "javabackend0";

	private ConnectionFactory() {

	}

	public static Connection getConnection() throws Exception {

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public static void releaseConnection(Connection con) throws Exception {
		con.close();
	}

}
