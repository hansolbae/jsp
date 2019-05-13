package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ��¥ : 2019/05/07
 * �̸� : ���Ѽ�
 * ���� : INSERT �ǽ��ϱ�
 */
public class InsertTest {

	// try~catch�� ��� throws Exception ����� �� ����
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
		String sql = "INSERT INTO `USER` VALUES ('jingjing', '¡¡��', 1, '����', '��û��');";
		stmt.executeUpdate(sql);
		
		// 5�ܰ� - ����� ó��(SELECT�� ���)
		// INSERT���̹Ƿ� 5�ܰ�X
		
		// 6�ܰ� - �����ͺ��̽� ����
		conn.close();
		
		System.out.println("������ INSERT �Ϸ�...");
	}
	
}
