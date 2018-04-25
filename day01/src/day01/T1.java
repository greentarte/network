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
		// �����尡 ����Ǵ� ����
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
		Thread1 t1 = new Thread1("T1"); // ��ü�̸��� ������ �����ؾߵǼ� �������̶� ����ȭ�� �����

		// �Ʒ��� ���� ������� ������ ���� �Լ��� ������ �����ϸ鼭 �پ��ϰ� ������ ���� ����
		Thread2 r =new Thread2("t2");
		Thread t2 = new Thread(r); // �پ��ϰ� ���� �ٲ� �� ����
		t1.start();
		t2.start();
		Thread.sleep(5000); //main ������ 5�� ������
		t1.setFlag(false);
		r.setFlag(false);
		// ������2���� ���ξ����� �� 3���� �۾��� �� �� �ִ�.
	}

}