package kr.co.ch02;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class Computer {
	
	private String cpu;
	private String ram;
	private String hdd;
	
	public Computer(String cpu, String ram, String hdd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	
	public int calc(int a, int b) {
		int result = a + b;
		return result;
	}
	
	public void internet(JspWriter out) throws IOException {
		out.println("<p>컴퓨터로 인터넷...</p>");
	}
}
