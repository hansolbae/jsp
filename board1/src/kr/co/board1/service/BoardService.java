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
	
	// 싱글톤 객체
	private static BoardService service = new BoardService();	// 객체 생성
	
	private BoardService() {}	// BoardService를 new하지 못함
	public static BoardService getInstance() {	// BoardService가 static이므로 똑같이 static으로 맞춰주기
		return service;
	}
	
	// 목록용 카운트 번호 구하기
	public int getListStartCount(int total, int start) {
		return total-start;	// start는 10개씩 이므로
	}
	
	// 현재 페이지
	public int getCurrentPage(String pg) {
		
		int current = 0;
		
		// null 체크
		if(pg == null) {
			current = 1; 
		}else {
			current = Integer.parseInt(pg);
		}	// 파라미터값을 숫자로 바꿈
		
		return current;	// 숫자로 리턴
	}
	
	// Limit용 Start값 구하기
	public int getStartForLimit(String pg) {
		
		int start = 0;
		
		// null 체크
		if(pg == null) {	// 1페이지
			start = 1;
		}else{
			start = Integer.parseInt(pg);	// String타입이므로 숫자타입 int로 변환
		}
		
		return (start - 1) * 10;		// start - 1 : 1페이지는 seq 0번부터 시작하므로
	}
	
	// 페이지그룹 계산하기
	public int[] getPageGroupStartEnd(String pg, int totalPage) {
		
		int[] groupStartEnd = new int[2];	// 2개짜리 배열
		
		int current = getCurrentPage(pg);	// pg=1이면 current=1, pg=2이면 current=2
		int currentGroup = (int) Math.ceil(current/10.0);	// currentGroup = 현재 페이지의 그룹
		int groupStart = (currentGroup - 1) * 10 + 1;	// 각 그룹의 start값 구함
		int groupEnd   = currentGroup * 10;				// 각 그룹의 end값 구함
		
		if(groupEnd > totalPage){		// end값의 조건, totalPage : getTotalPage메서드 호출해야함
			groupEnd = totalPage;
		}
		
		groupStartEnd[0] = groupStart;
		groupStartEnd[1] = groupEnd;	// 2개짜리 배열에 start값, end값을 각각 담아놓음
		
		return groupStartEnd;	// 리턴하기 위해 void → int[] 변환
	}
	
	// 전체 페이지 수 구하기
	public int getTotalPage(int boardTotal) {
				
		int pageTotal = 0;	// 페이지 수 = 전체 게시물 / 10 (+1)
		
		if(boardTotal % 10 == 0){
			pageTotal = boardTotal / 10;
		}else{
			pageTotal = boardTotal / 10 + 1;
		}
		
		return pageTotal;
	}
	
	// 전체 게시물 구하기(메서드 추가)
	public int getTotalBoard() throws Exception {
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계 - SQL 실행객체 생성
		Statement stmt = conn.createStatement();	// 쿼리문에 맵핑시킬 것이 없으므로 Statement 사용
		
		// 4단계 - SQL 실행
		ResultSet rs = stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
		
		// 5단계 - 결과셋 처리(SELECT)
		int total = 0;
		
		if(rs.next()) {		// 현재 커서의 위치는 COUNT(*)이므로 다음 커서로 이동하여 COUNT의 결과(96)의 레코드로 이동하도록 next() 사용
			total = rs.getInt(1);			// 컬럼갯수로 결과 가져오는 경우(컬럼이 한 개이므로 1)	
		 // total = rs.getInt("COUNT(*)");	// 컬럼명으로 결과 가져오는 경우
		}
		
		// 6단계 - 데이터베이스 종료
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
	}
	
	// (출력하기 위한)게시물 목록 구하기
	public List<BoardBean> getBoardList(int start) throws Exception {
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_LIST);
		psmt.setInt(1, start); // 메서드 실행할 때 start 값을 받아오기 위해 매개변수 이용
		
		// 4단계
		ResultSet rs = psmt.executeQuery(); // rs : 게시판 글들은 하나의 레코드가 아님(복수)
		
		// 5단계
		List<BoardBean> list = new ArrayList<>();
		
		while(rs.next()){	// 하나 이상의 레코드 → while문 사용
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
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
	// 게시물 추가하기
	public void insertBoard() {}
	
}
