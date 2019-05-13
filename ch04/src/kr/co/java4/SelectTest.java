package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ��¥ : 2019/05/07
 * �̸� : ���Ѽ�
 * ���� : Select �ǽ��ϱ�
 */
public class SelectTest {

	public static void main(String[] args) throws Exception {
		
		// �����ͺ��̽� ����
		String host = "jdbc:mysql://192.168.0.161:3306/bhs";
		String user = "bhs";
		String pass = "1234";
		
		// 1�ܰ� - JDBC ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2�ܰ� - �����ͺ��̽� ����
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		// 3�ܰ� - SQL ���ఴü ����
		Statement stmt = conn.createStatement();
		
		// 4�ܰ� - SQL ����
		// executeUpdate() - INSERT, UPDATE, DELETE
		// executeQuery() - SELECT : SELECT���� �����ؼ� �� ����� ��ȯ�� = ResultSet(rs)
		ResultSet rs = stmt.executeQuery("SELECT * FROM `USER`;");
		
		// 5�ܰ� - ����� ó��(SELECT�� ���)
		while(rs.next()) {
			String uid  = rs.getString(1);
		 // String name  = rs.getString(2);
			String name  = rs.getString("name");
			int gender   = rs.getInt(3);
			String hobby = rs.getString("hobby");
			String addr  = rs.getString(5);
			
			System.out.println("========================");
			System.out.println("���̵� : " + uid);
			System.out.println("��   �� : " + name);
			System.out.println("��   �� : " + gender);
			System.out.println("��   �� : " + hobby);
			System.out.println("��   �� : " + addr);
			System.out.println("------------------------");
		}
		
		// 6�ܰ� - �����ͺ��̽� ����
		conn.close();
	}
	
}
