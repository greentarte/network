package day05;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import gnu.io.NoSuchPortException;

public class SerialManager{
	
	SerialArduino sa;
	SerialRT sr;
	Frame f;
	Button b1, b2;
	
	Panel p1,p2;
	
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	
	SerialManager() throws NoSuchPortException{
		makeUi();
		this.sa = new SerialArduino(this);
		this.sr = new SerialRT(this);
		
	}
	public void receivedMsg(String msg, int num) {
		if(num == 1) {
			
			int id = Integer.parseInt(msg.substring(0,2));
			int data = Integer.parseInt(msg.substring(2,6));
			
			switch(id) {
				
			case 5:
				if(data == 1) {
				tf5.setText("LED Turn on");
				tf5.setBackground(Color.yellow);
				}else {
				tf5.setText("LED Turn off");
				tf5.setBackground(Color.white);
				}
				break;
			case 6:
				if(data == 1) {
				tf6.setText("Wiper turn on");
				tf6.setBackground(Color.yellow);
				}
				else {
				tf6.setBackground(Color.white);
				tf6.setText("Wiper turn off");
				}
				
				break;
			case 7:
				if(data == 1) {
				tf6.setText("Sleeping detecting");
				tf6.setBackground(Color.yellow);
				}
				else {
				tf6.setBackground(Color.white);
				tf6.setText("Wiper turn off");
				}
				
				break;
			case 8:
				if(data == 1) {
				tf6.setText("Wiper turn on");
				tf6.setBackground(Color.yellow);
				}
				else {
				tf6.setBackground(Color.white);
				tf6.setText("Wiper turn off");
				}
				
				break;
			}
			sa.write(msg);
		}else {
			int id = Integer.parseInt(msg.substring(9,11));
			int data = Integer.parseInt(msg.substring(23,27));
			
			switch(id){
			
			case 1:
				tf1.setText("Accelerator : "+data);
				tf2.setText("Break : 0 ");
				break;
			case 2:
				tf2.setText("Break : "+data);
				tf1.setText("Accelerator : 0 ");
				break;
			case 3:
				tf3.setText("Light : "+data);
				break;
			case 4:
				if(data == 1)
				tf4.setText("Motion : Detected");
				else
				tf4.setText("Motion : not Detected");
				break;
				
				
			}
			sr.write(msg);
		}
	}
	
	public void makeUi() {
		
		
		f = new Frame();
		
		f.setLayout(new GridLayout(1,2));
		
		p1 = new Panel();
		p2 = new Panel();
		
		p1.setLayout(new GridLayout(4,1));
		p2.setLayout(new GridLayout(4,1));
		

		
		
		
		tf1 = new JTextField("Accelerator");
//		tf1.set
//		tf1.setBackground(Color.BLACK);
		tf2 = new JTextField("BREAK");
		tf3 = new JTextField("LIGHT");
		tf4 = new JTextField("MOTION");
		
		tf5 = new JTextField("LED");
		tf6 = new JTextField("Wiper");
		tf7 = new JTextField("Sleeping detect System");
		tf8 = new JTextField("Turn Signal");
		
		
		tf1.setFont(new Font("serif",Font.BOLD,30));
		tf2.setFont(new Font("serif",Font.BOLD,30));
		tf3.setFont(new Font("serif",Font.BOLD,30));
		tf4.setFont(new Font("serif",Font.BOLD,30));
		tf5.setFont(new Font("serif",Font.BOLD,30));
		tf6.setFont(new Font("serif",Font.BOLD,30));
		tf7.setFont(new Font("serif",Font.BOLD,30));
		tf8.setFont(new Font("serif",Font.BOLD,30));
		
		
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf5.setHorizontalAlignment(JTextField.CENTER);
		tf6.setHorizontalAlignment(JTextField.CENTER);
		tf7.setHorizontalAlignment(JTextField.CENTER);
		tf8.setHorizontalAlignment(JTextField.CENTER);
		
		
		
		
		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(tf4);
		
		p2.add(tf5);
		p2.add(tf6);
		p2.add(tf7);
		p2.add(tf8);
		
		f.add(p1);
		f.add(p2);
		
		f.setLocation(0,0);
		f.setSize(1000,600);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
				System.exit(0);
			}
		});
		
		
	}
	
}