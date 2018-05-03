<<<<<<< HEAD
package tcp1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 소켓프로그래밍 시작.... 매우 중요
public class Server {
	
	// 통신에서 빠질 수 없는 포트..  
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
				osw.write("통신 완료..");
			} catch (IOException e) {
				System.out.println("통신 중 오류 발생...");
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
	int port;			// 서버 오픈할 포트번호
	ServerSocket serverSocket;  // 포트와 연결(bind)되어 연결요청을 기다림
	Socket socket;		// 두 프로세스간의 통신을 담당
	OutputStream out;	//  
	OutputStreamWriter outw; // 한글 보낼때 사용
	Boolean flag = true;

	//예외처리 try/catch로하면 콘솔에만 나올뿐 main에선 알수가 없다. 그래서 던져줘라(throws)
	public Server() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); 
	}

	public void startServer() throws IOException {
		System.out.println("Start Server....");

		while (flag) {
			try {
				System.out.println("Ready Server....");
				socket = serverSocket.accept(); //연결될때까지 기다린다.(연결될때까지 다음줄 안내려감)
				System.out.println("Accepted Client...." + socket.getInetAddress());
				out = socket.getOutputStream();
				outw = new OutputStreamWriter(out);
				
				//다중접속 서버에 적합하지 않다. 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				outw.write("안녕");

			} catch (IOException e) {
				throw e; //던져줘라 , 이렇게 하는 이유는 파이널리를 위해서
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
