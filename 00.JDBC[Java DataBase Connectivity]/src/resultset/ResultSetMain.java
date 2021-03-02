package resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;


import dao.address.ConnectionFactory;

public class ResultSetMain {

	public static void main(String[] args) throws Exception {
		/*
		이름         널?       유형            
		---------- -------- ------------- 
		NO         NOT NULL NUMBER(7)     
		NAME                VARCHAR2(50)  
		SHORT_DESC          VARCHAR2(255) 
		PRICE               NUMBER(10,3)  
		IPGO_DATE           DATE          
		 */
		String selectSql="select no,name,short_desc,price,ipgo_date from s_product";
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		System.out.println("----------ResultSet.get타입(컬럼이름)---------------");
		ResultSet rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			int no = rs.getInt("no");
			String name=rs.getString("name");
			String short_desc=rs.getString("short_desc");
			double price=rs.getDouble("price");
			Date ipgo_date=rs.getDate("ipgo_date");
			System.out.println(no+"\t"+name+"\t"+short_desc+"\t"+price+"\t"+ipgo_date);
		}
		rs.close();
		System.out.println("----------ResultSet.get타입(컬럼index)---------------");
		rs=stmt.executeQuery(selectSql);
		if(rs.next()) {
			do{
				int no = rs.getInt(1);
				String name=rs.getString(2);
				String short_desc=rs.getString(3);
				double price=rs.getDouble(4);
				Date ipgo_date=rs.getDate(5);
				System.out.println(no+"\t"+name+"\t"+short_desc+"\t"+price+"\t"+ipgo_date);
			}while(rs.next());
		}else {
			System.out.println("상품없다...");
		}
		rs.close();
		
		rs=stmt.executeQuery(selectSql);
		System.out.println("----------ResultSet.getObject(컬럼이름)-------------");
		while(rs.next()) {
			Object no = rs.getObject("no");
			System.out.println("class type:"+no.getClass().getName());
			Object name=rs.getObject("name");
			Object short_desc=rs.getObject("short_desc");
			Object price=rs.getObject("price");
			Object ipgo_date=rs.getObject("ipgo_date");
			System.out.println(no+"\t"+name+"\t"+short_desc+"\t"+price+"\t"+ipgo_date);
		}
		rs.close();
		
		
		
		
	}

}