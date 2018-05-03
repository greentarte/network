<<<<<<< HEAD
package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port;
	private boolean flag;
	private ServerSocket serverSocket;
	
	public Server() throws IOException {
		port = 7777;
		flag = true;
		serverSocket = new ServerSocket(port);
	}
	
	// Accept Client Socket And
	// Sender Thread Create(Send Socket) and Start
	public void startServer() throws IOException {	
		System.out.println("Start Server...");
		System.out.println("Ready Server...");
		while(flag) {
			Thread clientThread = new Thread(new Sender(serverSocket.accept()));
			clientThread.start();
		}
		System.out.println("End Server...");
	}
	
	class Sender implements Runnable {
		
		private Socket socket;
				
		public Sender(Socket socket) {
			this.socket = socket;
			System.out.println("Connected Client... " + socket.getInetAddress());
		}
		
		@Override
		public void run() {
			try (OutputStream os = socket.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);)
			{
				Thread.sleep(3000);
				osw.write("��� �Ϸ�..");
			} catch (IOException e) {
				System.out.println("��� �� ���� �߻�..");
			} catch (InterruptedException e) {
				System.out.println("�۾� �� ���� �߻�..");
			} finally {
				System.out.println("Disconnected Client... " + socket.getInetAddress());
					try {
						if(socket != null)
							socket.close();
					} catch (IOException e) {
						System.out.println("��� ���� �� ���� �߻�..");
					}
			}
		}
	}
			
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.startServer();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			
		}
	}
}
=======
package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	OutputStream out;
	OutputStreamWriter outw; // �ѱ� ������ ���
	Boolean flag = true;

	public Server() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); // ����ó�� try/catch���ϸ� �ֿܼ��� ���û� main���� �˼��� ����. �׷��� �������(throws)
	}

	// Accept Client Socket And Sender Thread Create and Start
	public void startServer() {
		Sender sender = new Sender();
		Thread t1 = new Thread(sender);
		t1.start();
	}

	class Sender implements Runnable {

		public Sender() {}
		@Override
		public void run() {
			
			while (flag) {
				try {

//  				�̺κ��� ������� �и�ó���ؾ��ϴµ� ���� �׳� �����常 ������� �и��� ������.
//					System.out.println("Ready Server....");
//					socket = serverSocket.accept(); // ����ɶ����� ��ٸ���.
//					System.out.println("Accepted Client...." + socket.getInetAddress());
//					out = socket.getOutputStream();
//					outw = new OutputStreamWriter(out);

					
					System.out.println("Ready Server....");
					socket = serverSocket.accept(); // ����ɶ����� ��ٸ���.
					System.out.println("Accepted Client...." + socket.getInetAddress());
					out = socket.getOutputStream();
					outw = new OutputStreamWriter(out);

					// �������� ������ �������� �ʴ�.
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outw.write("�ȳ�");

				} catch (IOException e) {
					try {
						throw e;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // ������� , �̷��� �ϴ� ������ ���̳θ��� ���ؼ�
				} finally {
					if (outw != null) {
						try {
							outw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}

		}

	}

	public static void main(String[] args) {
		Server server = null;
		try {
			server = new Server();
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
>>>>>>> ffa569a4e43001199d5979ad8de6588d7872a310
