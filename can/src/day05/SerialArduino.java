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

public class SerialArduino implements SerialPortEventListener{
	
	private static final String portName = "COM7";
	private BufferedInputStream bin;
	private InputStream in;
    private OutputStream out;
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private SerialManager sm;
	
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
	public SerialArduino(SerialManager sm) throws NoSuchPortException {
		this.sm = sm;
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
	private class SerialWriter implements Runnable {
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
	/*         serialData = serialData.toUpperCase();
	         char c[] = serialData.toCharArray();
	         int cdata = 0;
	         for (char cc : c) {
	            cdata += cc;
	         }
	         cdata = (cdata & 0xFF);

	         String returnData = "";
	         returnData += serialData + Integer.toHexString(cdata).toUpperCase();
	         returnData += "\r";*/
	         return serialData;
	      }

	      public void run() {
	         try {

	            byte[] inputData = data.getBytes();

	            out.write(inputData);
	            //�ݴ����� C���� JAVA���� �� �� �����Ƿ� inputStrem outputStream�� �̿��ؼ� �ְ� �޾ƾ� �Ѵ�
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }

	   }
	
	
	public void write(String msg) {
		
		SerialWriter sw = new SerialWriter(msg);
	      new Thread(sw).start();
		
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
	         byte[] readBuffer = new byte[8];

	         try {

	            if (bin.available() > 0) {
	               int numBytes = bin.read(readBuffer);
	              // System.out.println(numBytes);
	            }

	            String ss = new String(readBuffer).trim();
	            
	            System.out.println("from arduino data :"+ss);
	            
	            String nid = ss.substring(0,2);
	            String ndata = ss.substring(2,ss.length());  
	            
	            ss = String.format("W28%08d%016d", Integer.parseInt(nid),Integer.parseInt(ndata));

	            sm.receivedMsg(ss, 2);
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         break;
	      }
		
	}

}