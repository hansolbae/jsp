package kr.co.board1.service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {
	
	// ��ü �Խù� ���ϱ�
	public int getTotalPage(int boardTotal) {
				
		int pageTotal = 0;	// ������ �� = ��ü �Խù� / 10 (+1)
		
		if(boardTotal % 10 == 0){
			pageTotal = boardTotal / 10;
		}else{
			pageTotal = boardTotal / 10 + 1;
		}
		
		return pageTotal;
	}
	
	// ��ü ������ �� ���ϱ�(�޼��� �߰�)
	public int getTotalBoard() throws Exception {
		
		// 1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		
		// 3�ܰ� - SQL ���ఴü ����
		Statement stmt = conn.createStatement();	// �������� ���ν�ų ���� �����Ƿ� Statement ���
		
		// 4�ܰ� - SQL ����
		ResultSet rs = stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
		
		// 5�ܰ� - ����� ó��(SELECT)
		int total = 0;
		
		if(rs.next()) {		// ���� Ŀ���� ��ġ�� COUNT(*)�̹Ƿ� ���� Ŀ���� �̵��Ͽ� COUNT�� ���(96)�� ���ڵ�� �̵��ϵ��� next() ���
			total = rs.getInt(1);			// �÷������� ��� �������� ���(�÷��� �� ���̹Ƿ� 1)	
		 // total = rs.getInt("COUNT(*)");	// �÷������� ��� �������� ���
		}
		
		// 6�ܰ� - �����ͺ��̽� ����
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
		
	}
	
	
	// (����ϱ� ����)�Խù� ��� ���ϱ�
	public void getBoardList() {}
	
	// �Խù� �߰��ϱ�
	public void insertBoard() {}
	
}
