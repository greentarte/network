<<<<<<< HEAD
package tcp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	String ip;
	int port;
	Socket socket;
	InputStream is;
	InputStreamReader ir;
	BufferedReader br;
	
	public Client() {
		super();
	}

	public Client(String ip, int port) throws UnknownHostException, IOException {
		this.ip = ip;
		this.port = port;
		connectServer();
		startClient();
	}
	
	public void connectServer() {
		boolean flag = true;	// ���� ���� �÷���
		while(flag) {	// ������ ��� �� �� ���� ���� �õ� ����
			try {
				socket = new Socket(ip, port);
				if(socket != null && socket.isConnected()) {
					flag = false ;
				}
			} catch (IOException e) {
				System.out.println("Re-Try Connection...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void startClient() throws UnknownHostException, IOException {
		try {		
			System.out.println("Connected Server..");
			is = socket.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String str = br.readLine();
			System.out.println(str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(socket != null)
				socket.close();
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Client client = null;
		try {
			client = new Client("70.12.114.134", 7777);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
=======
package tcp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	String ip;
	int port;
	Socket socket;
	InputStream in;
	InputStreamReader inr;
	BufferedReader br;

	public Client() {
	}

	public Client(String ip, int port) throws UnknownHostException, IOException {
		this.ip = ip;
		this.port = port;
		connect();
		startClient();
	}

	public void connect() {
		boolean flag = true;
		while (flag) {
			try {
				socket = new Socket(ip, port);
				if (socket != null && socket.isConnected()) {
					break;
				}
			} catch (IOException e) {
				System.out.println("Re-Try");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {}
			}
		}
	}

	public void startClient() throws UnknownHostException, IOException {
		try {
			// socket = new Socket(ip,port);
			System.out.println("Connected");
			in = socket.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			String str = br.readLine();
			System.out.println(str);
		} catch (UnknownHostException e) { // ip�ȸ´� ����ó��
			throw e;
		} catch (IOException e) { // ip�� �¾Ҵµ�, ������ �׾��ų� �������� �ʴ� ����ó����
			throw e;
		} finally {
			br.close();
			socket.close();
		}
	}

	public static void main(String[] args) {
		Client client = null;

		try {
			client = new Client("70.12.114.143", 7777);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// client.startClient();

	}

}
>>>>>>> ffa569a4e43001199d5979ad8de6588d7872a310
