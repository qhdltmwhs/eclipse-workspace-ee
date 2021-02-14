package dao.address.third;

import java.util.ArrayList;

public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao3 addressDao3=new AddressDao3();
		System.out.println("-----------1.insert------------");
		Address newAddress=new Address(0, "kiwi", "이효리", "789-5656", "제주도민");
		addressDao3.insert(newAddress);
		System.out.println("-----------2.updateByNo-------------");
		Address updateAddress=new Address(9, "nine", "구구구", "999-9999", "구미시");
		addressDao3.updateByNo(updateAddress);
		System.out.println("----------3.deleteByNo------------");
		addressDao3.deleteByNo(13);
		System.out.println("--------4.selectByNo-------------");
		/*
		 * addressDao3야 번호인자로줄께 address DTO,VO 객체한개줘
		 */
		Address findAddress=addressDao3.selectByNo(30);
		System.out.println(findAddress);
		findAddress=addressDao3.selectByNo(33);
		System.out.println(findAddress);
		System.out.println("---------5.selectAll------------");
		/*
		 * addressDao3야  addressDTO,VO Collection 객체줘
		 */
		ArrayList<Address> addressList=addressDao3.selectAll();
		System.out.println(addressList);
		
	}

}