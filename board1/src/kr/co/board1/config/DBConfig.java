package kr.co.board1.config;

// 출처
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	// 데이터베이스 정보
	private static final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	private static final String USER = "bhs";
	private static final String PASS = "1234";
	
	public static Connection getConnection() throws Exception {	// 클래스 메서드 정의 및 throw 선언
		
		// 1단계
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn; // void → Connection 변경해야 return 가능
	}
	
}
