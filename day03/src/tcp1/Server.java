<<<<<<< HEAD
package tcp1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// �������α׷��� ����.... �ſ� �߿�
public class Server {
	
	// ��ſ��� ���� �� ���� ��Ʈ..  
	int port;
	ServerSocket serverSocket;
	Socket socket;
	OutputStream os;
	OutputStreamWriter osw;
	boolean flag;
	
	public Server() throws IOException {
		port = 7777;
		flag = true;
		serverSocket = new ServerSocket(port);
	}
	
	public void startServer() {	
		System.out.println("Start Server...");
		System.out.println("Ready Server...");
		while(flag) {
			try {
				socket = serverSocket.accept();
				System.out.println("Connected Client... " + socket.getInetAddress());
				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os);
				Thread.sleep(10000);
				osw.write("��� �Ϸ�..");
			} catch (IOException e) {
				System.out.println("��� �� ���� �߻�...");
			} catch (Exception e) {
				
			} finally {
				if(osw != null)
					try {
						osw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		System.out.println("End Server...");
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
package tcp1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;			// ���� ������ ��Ʈ��ȣ
	ServerSocket serverSocket;  // ��Ʈ�� ����(bind)�Ǿ� �����û�� ��ٸ�
	Socket socket;		// �� ���μ������� ����� ���
	OutputStream out;	//  
	OutputStreamWriter outw; // �ѱ� ������ ���
	Boolean flag = true;

	//����ó�� try/catch���ϸ� �ֿܼ��� ���û� main���� �˼��� ����. �׷��� �������(throws)
	public Server() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); 
	}

	public void startServer() throws IOException {
		System.out.println("Start Server....");

		while (flag) {
			try {
				System.out.println("Ready Server....");
				socket = serverSocket.accept(); //����ɶ����� ��ٸ���.(����ɶ����� ������ �ȳ�����)
				System.out.println("Accepted Client...." + socket.getInetAddress());
				out = socket.getOutputStream();
				outw = new OutputStreamWriter(out);
				
				//�������� ������ �������� �ʴ�. 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				outw.write("�ȳ�");

			} catch (IOException e) {
				throw e; //������� , �̷��� �ϴ� ������ ���̳θ��� ���ؼ�
			} finally {
				if (outw != null) {
					outw.close();
				}
				
				if (socket != null) {
					socket.close();
				}
		
			}
		}
		System.out.println("End Server....");

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
