package kr.co.farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.farmstory.config.DBConfig;
import kr.co.farmstory.config.SQL;
import kr.co.farmstory.vo.BoardVO;

public class BoardDao {

	// �̱��� ��ü
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private BoardDao() {}
	
	// �Խù� �ۼ��ϱ�
	public void write(BoardVO vo) throws Exception {
		
		// 1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		
		// 3�ܰ�
		PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_BOARD);
		psmt.setString(1, vo.getCate());
		psmt.setString(2, vo.getTitle());
		psmt.setString(3, vo.getContent());
		psmt.setInt(4, vo.getFile());
		psmt.setString(5, vo.getUid());
		psmt.setString(6, vo.getRegip());
		
		// 4�ܰ�
		psmt.executeUpdate();
		
		// 5�ܰ�
		// 6�ܰ�
		psmt.close();
		conn.close();
		
	}
	
}
