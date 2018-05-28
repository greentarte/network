package day05;

import gnu.io.NoSuchPortException;

public class SerialManager{
	
	SerialArduino sa;
	SerialRT sr;
	
	SerialManager() throws NoSuchPortException{
		this.sa = new SerialArduino(this);
		this.sr = new SerialRT(this);
		
	}
	public void receivedMsg(String msg, int num) {
		if(num == 1) {
		
			sa.write(msg);
		}else {
			sr.write(msg);
		}
	}
	
}