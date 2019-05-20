package kr.co.board1.service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {
	
	// 전체 게시물 구하기
	public int getTotalPage(int boardTotal) {
				
		int pageTotal = 0;	// 페이지 수 = 전체 게시물 / 10 (+1)
		
		if(boardTotal % 10 == 0){
			pageTotal = boardTotal / 10;
		}else{
			pageTotal = boardTotal / 10 + 1;
		}
		
		return pageTotal;
	}
	
	// 전체 페이지 수 구하기(메서드 추가)
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
	public void getBoardList() {}
	
	// 게시물 추가하기
	public void insertBoard() {}
	
}
