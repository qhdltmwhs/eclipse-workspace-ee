package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao2 addressDao2 = new AddressDao2();
		System.out.println("1.insert");
		addressDao2.insert("xxx", "장동건", "232-5621", "서울시민");
		//addressDao2.insert("uuu", "고소영", "676-9999", "경기도민");
		
		System.out.println("2.updateByNo");
		addressDao2.updateByNo(10, "guard", "김경호", "222-3333", "광주시민");
		
		System.out.println("3.deleteByNo");
		addressDao2.deleteByNo(20);
		
		System.out.println("4.selectByNo");
		addressDao2.selectByNo(10);
		
		System.out.println("5.selectAll");
		addressDao2.selectAll();
	}

}
