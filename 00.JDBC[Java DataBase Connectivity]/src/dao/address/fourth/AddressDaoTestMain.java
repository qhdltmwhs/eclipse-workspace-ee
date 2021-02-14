package dao.address.fourth;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception{
		AddressDao addressDao=new AddressDao();
		System.out.println("1.insert	-->"+addressDao.insert(new Address(0, "ooo", "������", "555-5555", "������")));
		System.out.println("2.update	-->"+addressDao.updateByNo(new Address(6, "six", "������", "666-6666", "���ֵ�")));
		System.out.println("3.selectByNo--> "+addressDao.selectByNo(6));
		System.out.println("4.deleteByNo--> "+addressDao.deleteByNo(45));
		System.out.println("5.selectAll	--> "+addressDao.selectAll());
		

	}

}