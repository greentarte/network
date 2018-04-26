package t1;

import java.util.Scanner;

public class Server {
	boolean flag = true;

	public void startServer() {
		Scanner client = new Scanner(System.in);
		while (flag) {
			System.out.println("Server Ready");
			String msg = client.nextLine();
			// Receiver Thread
			Receiver receiver = new Receiver(msg);
			receiver.start();
		}
		client.close();
	}

	public static void main(String[] args) {
		System.out.println("Server Start");
		new Server().startServer();
		System.out.println("Server Stop");

	}

	// ��û�� �޾Ƽ� ó�� �ϰ�
	// �ٽ� ���� �Ѵ�.
	class Receiver extends Thread {
		String msg;

		public Receiver() {
			// �⺻ ������ �޼ҵ�
		}

		public Receiver(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(i);
			}
			System.out.println(msg + "Completed");
			// Sender Thread�� ����
			// Client���� ����
			Sender sender = new Sender(msg);
			sender.start(); // ������ȿ��� �� ���� �����带 ���� ��Ų��.
		}

	}// end Receiver

	class Sender extends Thread {
		String msg;

		public Sender() {

		}

		public Sender(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				System.out.print(i);
			}
			System.out.println(msg + " : Send Completed");
		}

	}

}// Server Class
