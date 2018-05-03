package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

class Sender implements Runnable {
	OutputStream out;
	OutputStreamWriter outw;
	Socket socket;
	//Server�� Client ���̿�  ���� ������ Socket�� ���� �����
	//������ ������ ���������� ����ϱ����ؼ� Thread�� �����
	
	//OutputStream���� ���� Server�� client�� �����ϰ� socket���� �߰��� �����ؼ� ��ŵ�
	//socket���� �����ϰ� o
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
			outw.write("�ȳ�");
		} catch (Exception e) {
			//������ȿ����� �����°� ������
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
