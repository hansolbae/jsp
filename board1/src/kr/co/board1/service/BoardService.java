package kr.co.board1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import kr.co.board1.bean.BoardBean;
import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {
	
	// �̱��� ��ü
	private static BoardService service = new BoardService();	// ��ü ����
	
	private BoardService() {}	// BoardService�� new���� ����
	public static BoardService getInstance() {	// BoardService�� static�̹Ƿ� �Ȱ��� static���� �����ֱ�
		return service;
	}
	
	// ��Ͽ� ī��Ʈ ��ȣ ���ϱ�
	public int getListStartCount(int total, int start) {
		return total-start;	// start�� 10���� �̹Ƿ�
	}
	
	// ���� ������
	public int getCurrentPage(String pg) {
		
		int current = 0;
		
		// null üũ
		if(pg == null) {
			current = 1; 
		}else {
			current = Integer.parseInt(pg);
		}	// �Ķ���Ͱ��� ���ڷ� �ٲ�
		
		return current;	// ���ڷ� ����
	}
	
	// Limit�� Start�� ���ϱ�
	public int getStartForLimit(String pg) {
		
		int start = 0;
		
		// null üũ
		if(pg == null) {	// 1������
			start = 1;
		}else{
			start = Integer.parseInt(pg);	// StringŸ���̹Ƿ� ����Ÿ�� int�� ��ȯ
		}
		
		return (start - 1) * 10;		// start - 1 : 1�������� seq 0������ �����ϹǷ�
	}
	
	// �������׷� ����ϱ�
	public int[] getPageGroupStartEnd(String pg, int totalPage) {
		
		int[] groupStartEnd = new int[2];	// 2��¥�� �迭
		
		int current = getCurrentPage(pg);	// pg=1�̸� current=1, pg=2�̸� current=2
		int currentGroup = (int) Math.ceil(current/10.0);	// currentGroup = ���� �������� �׷�
		int groupStart = (currentGroup - 1) * 10 + 1;	// �� �׷��� start�� ����
		int groupEnd   = currentGroup * 10;				// �� �׷��� end�� ����
		
		if(groupEnd > totalPage){		// end���� ����, totalPage : getTotalPage�޼��� ȣ���ؾ���
			groupEnd = totalPage;
		}
		
		groupStartEnd[0] = groupStart;
		groupStartEnd[1] = groupEnd;	// 2��¥�� �迭�� start��, end���� ���� ��Ƴ���
		
		return groupStartEnd;	// �����ϱ� ���� void �� int[] ��ȯ
	}
	
	// ��ü ������ �� ���ϱ�
	public int getTotalPage(int boardTotal) {
				
		int pageTotal = 0;	// ������ �� = ��ü �Խù� / 10 (+1)
		
		if(boardTotal % 10 == 0){
			pageTotal = boardTotal / 10;
		}else{
			pageTotal = boardTotal / 10 + 1;
		}
		
		return pageTotal;
	}
	
	// ��ü �Խù� ���ϱ�(�޼��� �߰�)
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
	public List<BoardBean> getBoardList(int start) throws Exception {
		
		// 1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		
		// 3�ܰ�
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_LIST);
		psmt.setInt(1, start); // �޼��� ������ �� start ���� �޾ƿ��� ���� �Ű����� �̿�
		
		// 4�ܰ�
		ResultSet rs = psmt.executeQuery(); // rs : �Խ��� �۵��� �ϳ��� ���ڵ尡 �ƴ�(����)
		
		// 5�ܰ�
		List<BoardBean> list = new ArrayList<>();
		
		while(rs.next()){	// �ϳ� �̻��� ���ڵ� �� while�� ���
			BoardBean bb = new BoardBean();
			bb.setSeq(rs.getInt(1));
			bb.setParent(rs.getInt(2));
			bb.setComment(rs.getInt(3));
			bb.setCate(rs.getString(4));
			bb.setTitle(rs.getString(5));
			bb.setContent(rs.getString(6));
			bb.setFile(rs.getInt(7));
			bb.setHit(rs.getInt(8));
			bb.setUid(rs.getString(9));
			bb.setRegip(rs.getString(10));
			bb.setRdate(rs.getString(11));
			bb.setNick(rs.getString(12));
			
			list.add(bb);
		}
		
		// 6�ܰ�
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
	// �Խù� �߰��ϱ�
	public void insertBoard() {}
	
}
