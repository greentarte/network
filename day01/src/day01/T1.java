package day01;

class Thread1 extends Thread {
	String msg;
	boolean flag = true;

	public Thread1(String msg) {
		this.msg = msg;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void run() {
		int i = 0;
		while (flag) {
			System.out.println(msg + " " + i++);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread2 implements Runnable {
	String msg;
	boolean flag = true;

	public Thread2(String msg) {
		this.msg = msg;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		// 쓰레드가 진행되는 영역
		int i = 0;
		while (flag) {
			System.out.println(msg + "  " + i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class T1 {

	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1("T1"); // 객체이름을 가지고 생성해야되서 고정적이라서 값변화가 어려움

		// 아래와 같은 방법으로 형성시 같은 함수로 변수를 변경하면서 다양하게 쓰레드 생성 가능
		Thread2 r =new Thread2("t2");
		Thread t2 = new Thread(r); // 다양하게 값을 바꿀 수 있음
		t1.start();
		t2.start();
		Thread.sleep(5000); //main 쓰레드 5초 딜레이
		t1.setFlag(false);
		r.setFlag(false);
		// 쓰레드2개와 메인쓰레드 총 3개로 작업을 할 수 있다.
	}

}
