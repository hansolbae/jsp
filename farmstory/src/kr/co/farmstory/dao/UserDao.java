package kr.co.farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.farmstory.config.SQL;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.config.DBConfig;
import kr.co.farmstory.dao.UserDao;

public class UserDao {

	// 싱글톤 객체
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao() {}
	
	// 약관
	public TermsVO terms() throws Exception {
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계
		Statement stmt = conn.createStatement();
		
		// 4단계
		ResultSet rs = stmt.executeQuery(SQL.SELECT_TERMS);
		
		// 5단계
		TermsVO vo = new TermsVO();
		
		if(rs.next()) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}
		
		// 6단계
		rs.close();
		stmt.close();
		conn.close();
		
		return vo;
		
	}
	
	// 로그인
	public void login() throws Exception {}
	
	// 회원가입
	public void register() throws Exception {}
	
	// 아이디 중복체크
	public void checkUid() throws Exception {}
	
	
}
