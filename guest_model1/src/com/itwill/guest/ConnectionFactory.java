package com.itwill.guest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * Connection객체생성과 해제 작업을 전담하는클래스
 */
public class ConnectionFactory {
		private ConnectionFactory() {

	}

	public static Connection getConnection() throws Exception {
		
		InputStream in = ConnectionFactory.class.getResourceAsStream("db.properties");
		Properties properties=new Properties();
		properties.load(in);
		String driverClass = properties.getProperty("driverClass");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public static void releaseConnection(Connection con) throws Exception {
		con.close();
	}

}