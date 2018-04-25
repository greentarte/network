package t3;

import java.util.Scanner;

class Receiver implements Runnable {
	String cmd;

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1); //중요한 중간에 cmd값을 입력할 시간을 만듬
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(cmd !=null && cmd.equals("s")) {
				// Send message
				for(int i=0; i<=50; i++) {
					System.out.println(i);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(cmd !=null && cmd.equals("e")) {
						break;
					}
				}
				// send Message End....
			}else if(cmd !=null && cmd.equals("e")) {
				break;
			}
		}
	}

}

public class Main {

	public static void main(String[] args) {
		Receiver r =new Receiver();
		Thread t = new Thread(r);
		t.start();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Cmd s");
		String cmd = sc.nextLine();
		r.setCmd(cmd.trim());
		
		System.out.println("Input Cmd e");
		String cmd2 = sc.nextLine();
		r.setCmd(cmd2.trim());
						
		sc.close();
	}

}
