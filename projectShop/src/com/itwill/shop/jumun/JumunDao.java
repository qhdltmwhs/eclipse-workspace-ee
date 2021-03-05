package com.itwill.shop.jumun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

public class JumunDao {
	
	private DataSource dataSource;
	public JumunDao() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/db.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}
	/*
	 * 주문전체(특정사용자)
	 */
	public ArrayList<Jumun> list(String sUserId) throws Exception{
		ArrayList<Jumun> jumunList=new ArrayList<Jumun>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from jumun where userid=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jumunList.add(new Jumun(rs.getInt("j_no"),
										rs.getString("j_desc"),
								       rs.getDate("j_date"),
								       rs.getInt("j_price"),
								       rs.getString("userid"),
								       null));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return jumunList;
	}
	/*
	 * 주문1개보기(주문상세리스트)
	 */
	public Jumun detail(int j_no)throws Exception{
		String selectSql=
"select * from jumun j join jumun_detail jd on j.j_no=jd.j_no  join  product p on jd.p_no=p.p_no where j.j_no = ?";
		Jumun jumun=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(selectSql);
		pstmt.setInt(1,j_no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			jumun=new Jumun(rs.getInt("j_no"), 
					rs.getString("j_desc"),
					rs.getDate("j_date"),
					rs.getInt("j_price"),rs.getString("userid"));
			do {
				jumun.getJumunDetailList()
					.add(new JumunDetail(
								rs.getInt("jd_no"), 
								rs.getInt("jd_qty"), 
								rs.getInt("j_no"), 
								new Product(rs.getInt("p_no"),
											rs.getString("p_name"),
											rs.getInt("p_price"),
											rs.getString("p_image"),
											rs.getString("p_desc"),
											rs.getInt("p_click_count"))
								)
							);
			}while(rs.next());
		}
		
		
		return jumun;
	}
	
	
}
