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

	// 요청을 받아서 처리 하고
	// 다시 전송 한다.
	class Receiver extends Thread {
		String msg;

		public Receiver() {
			// 기본 생성자 메소드
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
			// Sender Thread를 통해
			// Client에게 전송
			Sender sender = new Sender(msg);
			sender.start(); // 쓰레드안에서 또 따른 쓰레드를 실행 시킨다.
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
