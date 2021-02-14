package basic;

import java.net.Socket;

public class OracleSocketMain {

	public static void main(String[] args) throws Exception {
	
		Socket socket = new Socket("182.237.126.19", 1521);
		System.out.println("Oracle DB connect: " + socket);
	
	}

}
