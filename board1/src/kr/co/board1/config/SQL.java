package kr.co.board1.config;

public class SQL {
	
	// 회원관련
	public static final String SELECT_TERMS = "SELECT * FROM `JSP_TERMS`;"; // 쿼리문에 ; 생략가능
	public static final String SELECT_USER = "SELECT * FROM `JSP_USER` WHERE uid=? AND pass=PASSWORD(?);";
	public static final String INSERT_USER = "INSERT INTO `JSP_USER` SET "
												 // sql += "uid='"+id+"',";
												 +"uid=?,"
											     // PASSWORD() 내장함수 이용
												 +"pass=PASSWORD(?),"
												 +"name=?,"
												 +"nick=?,"
											     +"email=?,"
											     +"hp=?,"
												 // grade : 디폴트 값(2)이 설정되어 있으므로 생략
											     +"zip=?,"
											     +"addr1=?,"
											     +"addr2=?,"
											     +"regip=?,"
											     +"rdate=NOW()";
	
	// uid=? → prepareStatement 사용
	public static final String SELECT_USER_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE uid=?;";
	public static final String SELECT_NICK_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE nick=?;";
	public static final String SELECT_EMAIL_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE email=?;";
	public static final String SELECT_HP_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE hp=?;";
	
	
	// 게시판관련
	public static final String INSERT_BOARD = "INSERT INTO `JSP_BOARD` SET "
											+ "title=?,"	// 글제목 : 맵핑해야하므로 있어야 함
											+ "content=?,"	// 글내용 : 맵핑해야하므로 있어야 함
											+ "uid=?,"		// 사용자 아이디
											+ "regip=?,"	// 사용자 IP주소
											+ "rdate=NOW()";
	
	public static final String SELECT_LIST = "SELECT a.*, b.nick FROM `JSP_BOARD` AS a "
										   + "JOIN `JSP_USER` AS b ON a.uid = b.uid "
										   + "ORDER BY seq DESC "	// 시퀀스 번호가 큰 순서대로(최신순) 출력
										   + "LIMIT ?, 10";			// LIMIT 0, 10/ LIMIT 10, 10/ LIMIT 20, 10 ... '?', PreparedStatement 처리
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `JSP_BOARD`;";
	
}
