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

	// �̱��� ��ü
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao() {}
	
	// ���
	public TermsVO terms() throws Exception {
		
		// 1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		
		// 3�ܰ�
		Statement stmt = conn.createStatement();
		
		// 4�ܰ�
		ResultSet rs = stmt.executeQuery(SQL.SELECT_TERMS);
		
		// 5�ܰ�
		TermsVO vo = new TermsVO();
		
		if(rs.next()) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}
		
		// 6�ܰ�
		rs.close();
		stmt.close();
		conn.close();
		
		return vo;
		
	}
	
	// �α���
	public void login() throws Exception {}
	
	// ȸ������
	public void register() throws Exception {}
	
	// ���̵� �ߺ�üũ
	public void checkUid() throws Exception {}
	
	
}
