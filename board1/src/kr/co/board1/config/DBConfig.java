package kr.co.board1.config;

// ��ó
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	// �����ͺ��̽� ����
	private static final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	private static final String USER = "bhs";
	private static final String PASS = "1234";
	
	public static Connection getConnection() throws Exception {	// Ŭ���� �޼��� ���� �� throw ����
		
		// 1�ܰ�
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2�ܰ�
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn; // void �� Connection �����ؾ� return ����
	}
	
}
