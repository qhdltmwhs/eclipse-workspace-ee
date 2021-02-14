package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressInsertMain {

	public static void main(String[] args) throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "javabackend72";
		String password = "javabackend72";
		
		String insertSql =
				"insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시')";
		
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		
		/*
		 * 4. Statement객체를 사용해 SQL문(DML) 전송 
		 */
		/*
		int executeUpdate(String sql)
		           throws SQLException
		Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement or an SQL statement that returns nothing, such as an SQL DDL statement.
		
		Note:This method cannot be called on a PreparedStatement or CallableStatement.

		Parameters:
		sql - an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, such as a DDL statement.
		
		Returns:
		either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
		st.execute(insertSql);
		*/
		int rowCount = st.executeUpdate(insertSql);
		System.out.println(rowCount + "행 insert");
		
		st.close();
		con.close();
		
		
		
	}

}
