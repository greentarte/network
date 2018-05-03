package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

class Sender implements Runnable {
	OutputStream out;
	OutputStreamWriter outw;
	Socket socket;
	//Server와 Client 사이에  각각 개별의 Socket을 만들어서 통신함
	//각각의 개별로 병렬적으로 통신하기위해서 Thread를 사용함
	
	//OutputStream으로 먼저 Server와 client와 연결하고 socket으로 추가로 연결해서 통신됨
	//socket으로 연결하고 o
	public Sender() {
	}

	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		out = socket.getOutputStream();
		outw = new OutputStreamWriter(out);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			outw.write("안녕");
		} catch (Exception e) {
			//쓰레드안에서는 던지는게 물가능
			e.printStackTrace();
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
