<<<<<<< HEAD
package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	boolean flag = true;
	String address = "192.168.0.16";
	Socket socket;
	Scanner scanner;

	public Client() {
		int count = 0;
		while(count<10) {
			try {
				socket = new Socket(address, 8888);
				if(socket != null && socket.isConnected()) {
					count = 11;
				}
				System.out.println("Connected Server ..");
			} catch (IOException e) {
				count++;
				System.out.println("Retry to connect..." + count);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}	
		}
		
	}

	public void startClient() throws Exception {
		new Receiver(socket).start();
		Sender sender = new Sender(socket);
		scanner = new Scanner(System.in);
		
		while (flag != false) {
			System.out.println("클라이언트 입력 하세요 : ");
			String str = scanner.nextLine();
			
			if (str.trim().equals("q")) {
				Thread t = new Thread(sender);
				sender.setSendMsg("q");
				t.start();
				flag = false;
				scanner.close();
				break;
			}
			
			Thread t = new Thread(sender);
			sender.setSendMsg(str);
			t.start();
		}
		
		Thread.sleep(1000);
		socket.close();
		// System.exit(0);
		
	}

	class Sender implements Runnable {
		Socket socket;
		OutputStream out;
		DataOutputStream outw;
		String sendMsg;

		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			out = socket.getOutputStream();
			outw = new DataOutputStream(out);
		}

		public void setSendMsg(String sendMsg) {
			this.sendMsg = sendMsg;
		}

		@Override
		public void run() {
			try {
				if (outw != null) {
					outw.writeUTF(sendMsg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	class Receiver extends Thread {
		Socket socket;
		InputStream in;
		DataInputStream inr;
		
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			inr = new DataInputStream(in);
		}

		@Override
		public void run() {
			while (inr != null) {
				try {
					String str = inr.readUTF();
					System.out.println(str);
					if (str.trim().equals("q")) {
						inr.close();
						break;
					}
				} catch (Exception e) {
					System.out.println("Server Closed");
					break;
				}
			}

			try {
				Thread.sleep(1000);
				flag = false;
				socket.close();
				System.exit(0);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String args[]) {
		try {
			new Client().startClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
=======
package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import tcp4.Server.Receiver;
import tcp4.Server.Sender;

public class Client {
	String ip;
	int port;
	Socket socket;
	boolean flag = true;
	InputStream in = null;
	DataInputStream din = null;
	OutputStream out = null;
	DataOutputStream dout = null;

	public Client() {
		ip = "70.12.114.143";
		port = 7777;
		flag = true;
	}

	public void startClient() throws UnknownHostException, IOException {
		socket = new Socket(ip, port);
		in = socket.getInputStream();
		din = new DataInputStream(in);
		out = socket.getOutputStream();
		dout = new DataOutputStream(out);

		Scanner scanner = new Scanner(System.in);
		Receiver receiver = new Receiver();
		receiver.start();
		while (flag) {
			System.out.println("Input Client.. ");
			String str = scanner.nextLine();

			if (str.equals("q")) {
				scanner.close();
				break;
			}
			//
			Thread t = new Thread(new Sender(str));
			t.start();
		}
		System.out.println("Stop Client");
	}

	class Receiver extends Thread { // 클라이언트에서 받는 역할만 함
		@Override

		public void run() {
			System.out.println("Client Receiver");
			while (true) {
				try {
					System.out.println("서버로부터 아래의 메시지가 왔습니다.");
					System.out.println(din.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Sender implements Runnable {
		String msg;

		public Sender(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			try {
				dout.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Client ::: ");
		Client client = new Client();
		try {
			client.startClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
>>>>>>> ffa569a4e43001199d5979ad8de6588d7872a310
