package com.itwill.address;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AddressService {
	private AddressDao addressDao;

	public AddressService() {
		addressDao = new AddressDao();
	}

	public int deleteByNo(int no) throws Exception {
		return addressDao.deleteByNo(no);

	}

	public int insert(Address address) throws Exception {
		return addressDao.insert(address);
	}

	public ArrayList<Address> selectAll() throws Exception {
		return addressDao.selectAll();
	}

	public Address selectByNo(int no) throws Exception {
		return addressDao.selectByNo(no);

	}

	public int updateByNo(Address address) throws Exception {
		return addressDao.updateByNo(address);
	}
}