package kr.co.java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 날짜 : 2019/05/07
 * 이름 : 배한솔
 * 내용 : INSERT 실습하기
 */
public class InsertTest {

	// try~catch문 대신 throws Exception 사용할 수 있음
	public static void main(String[] args) throws Exception {
		
		// 데이터베이스 정보
		String host = "jdbc:mysql://192.168.0.161:3306/bhs";
		String user = "bhs";
		String pass = "1234";
		
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		// 3단계 - SQL 실행객체 생성
		Statement stmt = conn.createStatement();
		
		// 4단계 - SQL 실행
		String sql = "INSERT INTO `USER` VALUES ('jingjing', '징징이', 1, '독서', '충청도');";
		stmt.executeUpdate(sql);
		
		// 5단계 - 결과셋 처리(SELECT일 경우)
		// INSERT문이므로 5단계X
		
		// 6단계 - 데이터베이스 종료
		conn.close();
		
		System.out.println("데이터 INSERT 완료...");
	}
	
}
