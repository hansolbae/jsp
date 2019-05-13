package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ��¥ : 2019/05/07
 * �̸� : ���Ѽ�
 * ���� : JDBC ���α׷��� �ǽ��ϱ�
 */
public class JDBCTest {

	public static void main(String[] args) {
		
		// �����ͺ��̽� ����
		String host = "jdbc:mysql://192.168.0.161:3306/bhs";
		String user = "bhs";
		String pass = "1234";
		
		Connection conn = null;
		
		try {
			// 1�ܰ� - JDBC ����̹� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2�ܰ� - �����ͺ��̽� ����
			conn = DriverManager.getConnection(host, user, pass);
			
			if(conn != null) {
				System.out.println("�����ͺ��̽� ���Ӽ���...");
			}
			// 3�ܰ� - SQL �������� ��ü����
			// 4�ܰ� - SQL ����
			// 5�ܰ� - ResultSet ������ ó��(SELECT�� ���)
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 6�ܰ� - �����ͺ��̽� ����
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}