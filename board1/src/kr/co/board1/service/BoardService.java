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
	public int[] getPageGroupStartEnd(String pg, int totalPage) {	// 메서드 생성 및 매개변수
		
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
	
	// 조회수 업데이트
	public void updateHit(String seq) throws Exception {
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(SQL.UPDATE_HIT);
		psmt.setString(1, seq);
		
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		
		
		// 6단계
		psmt.close();
		conn.close();
		
	}
	
	// 글보기 select
	public BoardBean viewBoard(String seq) throws Exception {	// 쿼리문 실행할 때 예외처리해야함
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_VIEW); // 글번호로 글 식별하여 출력
		psmt.setString(1, seq);	// setString : '' ↔ setInt : 따옴표 없음
		
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		BoardBean bb = new BoardBean();	// bean 객체 생성하여 if문을 반복하여 데이터를 넣음
		
		if(rs.next()){	// 1개의 레코드를 반복하므로 while문 사용하지 않아도 됨
			
			bb.setSeq(rs.getInt(1));
			bb.setParent(rs.getInt(2));
			bb.setComment(rs.getInt(3));
			bb.setCate(rs.getString(4));
			bb.setTitle(rs.getString(5));
			bb.setContent(rs.getString(6));
			bb.setFile(rs.getInt(7));	// file은 1또는 0 → int
			bb.setHit(rs.getInt(8));
			bb.setUid(rs.getString(9));
			bb.setRegip(rs.getString(10));
			bb.setRdate(rs.getString(11));
			bb.setOldName(rs.getString(13));
			bb.setNewName(rs.getString(14));
			bb.setDownload(rs.getInt(15));	// 다운로드 횟수
			
		}
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
		return bb; // 메서드의 반환타입 void → BoardBean
	}
	
	// 댓글 리스트
	public List<BoardBean> commentList(String parent) throws Exception {
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_COMMENT_LIST);
		psmt.setString(1, parent);	// 하나의 ?에 값 맵핑, 문자열('') 또는 숫자(''없음)로 맵핑해도 쿼리문 실행 가능
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		List<BoardBean> list = new ArrayList<>();
	/* 인터페이스                                            구체화                */
		
		while(rs.next()) {			// bb객체 생성하여 12개의 데이터를 저장함 → list에 저장함
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
		
		return list;	// return해주기 위해 반환타입 void → List<BoardBean>
	}
	
	// 댓글 카운트 업데이트
	public String countComment(String parent) throws Exception {
		
		// 1단계, 2단계
		Connection conn = DBConfig.getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_COUNT_COMMENT);
		psmt.setString(1, parent);
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		String cntComment = null;
		while(rs.next()) {
			cntComment = rs.getString(1);
		}
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
		return cntComment;
	}
}
