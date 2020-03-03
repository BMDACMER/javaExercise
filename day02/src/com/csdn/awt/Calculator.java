package com.csdn.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class Calculator {
 
	public static void main(String[] args) {
		new MyFrame("计算器");
	}
 
}
class MyFrame extends Frame{
	private static final long serialVersionUID = 1L;
 	private TextArea ta,tb;
	public MyFrame(String title){
		super(title);
		SetTextAreas();
		SetButtonArea();
		SetMainFram();
	}
 
	private void SetButtonArea() {
		
		addButton("7",33,28,20,178);
		addButton("8",33,28,58,178);
		addButton("9",33,28,96,178);
		addButton("/",33,28,134,178);
		addButton("%",33,28,172,178);
			
		addButton("4",33,28,20,210);
		addButton("5",33,28,58,210);
		addButton("6",33,28,96,210);
		addButton("*",33,28,134,210);
		addButton("1/x",33,28,172,210);
		
		addButton("1",33,28,20,242);
		addButton("2",33,28,58,242);
		addButton("3",33,28,96,242);
		addButton("-",33,28,134,242);
		
		addButton("0",71,28,20,274);
		addButton(".",33,28,96,274);
		addButton("+",33,28,134,274);
			
		addButton("=",33,60,172,242);
	}
 
	double m,n;
	String  k;
	boolean flag =true;
	boolean flag2 =false;
	private void addButton(String string, int i, int j,int x,int y) {
		final Button b = new Button(string);
		b.setLocation(x, y);
		b.setSize(i, j);
		b.setFont(new Font("标楷体", Font.BOLD, 15));
		b.setBackground(Color.pink); 
		b.setForeground(Color.darkGray);
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				counts();
				
			}
 
			private void counts() {
				if(ta.getText().equals("")&&(b.getActionCommand().equals("+")||
						b.getActionCommand().equals("-")||
						b.getActionCommand().equals("*")||
						b.getActionCommand().equals("/")||
						b.getActionCommand().equals("%")||
						b.getActionCommand().equals("1/x")||
						b.getActionCommand().equals("="))) {
					
				}else if(ta.getText().equals(".")&&(b.getActionCommand().equals("+")||
						b.getActionCommand().equals("-")||
						b.getActionCommand().equals("*")||
						b.getActionCommand().equals("/")||
						b.getActionCommand().equals("%")||
						b.getActionCommand().equals("1/x")||
						b.getActionCommand().equals("="))){
					
				}else {
				if(		b.getActionCommand().equals("+")||
						b.getActionCommand().equals("-")||
						b.getActionCommand().equals("*")||
						b.getActionCommand().equals("%")||
						b.getActionCommand().equals("1/x")||
						b.getActionCommand().equals("/")){
					if(flag2 = true) {
						flag2 = false;
					}
				if(flag) {
					n = new Double(ta.getText()).doubleValue();
					flag = false;
				}else {
					if(k=="="){
						
					}else {
						m = new Double(ta.getText()).doubleValue();
						if(k == "-") {
							if(n==0)
								n = m;
							else
								n=n-m;
						}else if(k == "+") {
							if(n==0)
								n = m;
							else
								n=n+m;
						}else if(k == "*") {
							if(n==0)
								n = m;
							else
								n=n*m;
						}else if(k=="%"){
							if(n==0)
								n=m;
							else
								m=m*100;
						}else if(k=="1/x"){
							if(n==0)
								n=m;
							else
								n=1/m;
						}else if(k == "/") {
							if(n==0)
								n = m;
							else
								n=n/m;
						}
					}
				}
					k = b.getActionCommand();
						ta.setText("");	
				}else if(b.getActionCommand().equals("=")) {
					m = new Double(ta.getText()).doubleValue();
					if(k == "+") {
						ta.setText("");
						ta.append(n+"+"+m);
						ta.append(System.getProperty("line.separator"));
						n = n+m;
						ta.append("="+n);
					}else if(k == "-") {
						ta.setText("");
						ta.append(n+"-"+m);
						ta.append(System.getProperty("line.separator"));
						n = n-m;
						ta.append("="+n);
					}else if(k == "*") {
						ta.setText("");
						ta.append(n+"*"+m);
						ta.append(System.getProperty("line.separator"));
						n = n*m;
						ta.append("="+n);
					}else if(k == "%") {
						ta.setText("");
						ta.append("%"+m);
						ta.append(System.getProperty("line.separator"));
						m = m*100;
						ta.append("="+m+"%");
					}else if(k == "1/x") {
						ta.setText("");
						ta.append(1+"/"+m);
						ta.append(System.getProperty("line.separator"));
						n = 1/m;
						ta.append("="+n);			
					}else if(k == "/") {
						ta.setText("");
						ta.append(n+"/"+m);
						ta.append(System.getProperty("line.separator"));
						n= n/m;
						ta.append("="+n);
					}
					k="=";
					flag2 = true;
				}else {
					if(flag2) {
						flag = true;
						flag2 = false;
						ta.setText("");
						m = n =0;
					}
					ta.append(b.getActionCommand());
				}
			}
		}
	});	
		this.add(b);
	}
	private void SetTextAreas() {
		ta = new TextArea("0",8,52,3);
		ta.setBackground(Color.lightGray);
		ta.setSize(190, 50);
		ta.setFont(new Font("标楷体", Font.BOLD, 15));
		ta.setLocation(20,60);
		this.add(ta);
		tb = new TextArea("开发人员：XXX",8,52,3);
		tb.setBackground(Color.pink);
		tb.setSize(190,25);
		tb.setFont(new Font("标楷体", Font.BOLD, 16));
		tb.setForeground(Color.blue);
		tb.setLocation(20,130);
		this.add(ta);
		this.add(tb);
	}
	@SuppressWarnings("deprecation")
	private void SetMainFram() {
		this.setLayout(null);
		this.setSize(220,310);
		this.setVisible(true);
		this.setLocation(310, 340);
		this.setResizable(false);
		ta.setEditable(false);
		tb.setEditable(false);
		this.setCursor(Cursor.HAND_CURSOR);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});			
		
	}
}