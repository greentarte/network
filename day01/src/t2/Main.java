package t2;

class T1 extends Thread {

	int result = 1;
	boolean flag = true;

	public int getResult() {
		return this.result;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		while (flag) {
			result++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Main {

	public static void main(String[] args) {

		// 쓰레드의 상태 값을 가져오는것
		T1 t1 = new T1();
		t1.start();
		int result = 0;
		while (result <= 20) {
			result = t1.getResult();
			System.out.println(result);
			if (result == 20) {
				t1.setFlag(false);
				break;
			}

		}

	}

}
