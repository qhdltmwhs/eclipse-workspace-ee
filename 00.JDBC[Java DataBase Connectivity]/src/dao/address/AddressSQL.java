package dao.address;
/*
 * address table sql 
 */
public class AddressSQL {
	public static final String ADDRESS_INSERT="insert into address values(address_no_seq.nextval,?,?,?,?)";
	public static final String ADDRESS_DELETE="delete address where no=?";
	public static final String ADDRESS_UPDATE="update address set id=?, name= ?,phone=? ,address=? where no = ?";
	public static final String ADDRESS_SELECT_PK="select no,id,name,phone,address from address where no=?";
	public static final String ADDRESS_SELECT_ALL="select no,id,name,phone,address from address";
	
}
