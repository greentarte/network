package day05;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialTest implements SerialPortEventListener {
	// CommPortIdentifier commPortIdentifier;

	private BufferedInputStream bin;
	private InputStream in;
	private OutputStream out;
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;

	public SerialTest() {
	}

	public SerialTest(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("Connect Com Port");
		try {
			connectSerial();
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start();
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}
	}

	public void connectSerial() throws Exception {

		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 5000);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // ��żӵ�
						SerialPort.DATABITS_8, // ������ ��Ʈ
						SerialPort.STOPBITS_1, // stop ��Ʈ
						SerialPort.PARITY_NONE); // �и�Ƽ
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				out = serialPort.getOutputStream();
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	public void sendMsg(String msg) {
		SerialWriter sw = new SerialWriter(msg);
		new Thread(sw).start();
	}

	public class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			this.data = ":G11A9\r";
		}

		public SerialWriter(String serialData) {
			// CheckSum Data ����
			// W28 00000000 000000000000 53 \r
			String sdata = sendDataFormat(serialData);
			System.out.println(sdata);
			this.data = sdata;
		}

		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}
			cdata = (cdata & 0xFF);

			String returnData = ":";
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {

				byte[] inputData = data.getBytes();

				out.write(inputData);
				// �ݴ����� C���� JAVA���� �� �� �����Ƿ� inputStrem outputStream�� �̿��ؼ� �ְ� �޾ƾ� �Ѵ�
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		SerialTest serialTest = null;
		int[] category = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] speed = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		try {
			serialTest = new SerialTest("COM7");
			String result;
//			String.format("W28%08d%016d", category[0], speed[9]);
			// String msg = "W28000000000000000000000000"; // �տ� 8���� key�� �ڿ� 16���� data ,,,
			// check sum 2�� ����
			for(int i=0; i<10; i++) {
				result = String.format("W28%08d%016d", category[i], speed[i]);
				Thread.sleep(1000);
				serialTest.sendMsg(result);
			}			
		} catch (NoSuchPortException e) {
			System.out.println("connect Fail !");
			e.printStackTrace();
		}

	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128];

			try {

				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer);
				}

				String ss = new String(readBuffer);
				System.out.println("Receive Low Data:" + ss);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

}