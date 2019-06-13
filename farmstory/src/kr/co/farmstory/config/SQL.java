package kr.co.farmstory.config;

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
											+ "cate=?,"
											+ "title=?,"	// 글제목 : 맵핑해야하므로 있어야 함
											+ "content=?,"	// 글내용 : 맵핑해야하므로 있어야 함
											+ "file=?,"
											+ "uid=?,"		// 사용자 아이디
											+ "regip=?,"	// 사용자 IP주소
											+ "rdate=NOW()";
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(seq) FROM `JSP_BOARD`";
	public static final String INSERT_FILE = "INSERT INTO `JSP_FILE` (`parent`, `oldName`, `newName`, `rdate`) VALUES (?, ?, ?, NOW())";
	public static final String SELECT_LIST = "SELECT a.*, b.nick FROM `JSP_BOARD` AS a "
										   + "JOIN `JSP_USER` AS b ON a.uid = b.uid "
										   + "WHERE parent=0 AND cate=? "	// parent=0 : 원글(댓글x)
										   + "ORDER BY seq DESC "			// 시퀀스 번호가 큰 순서대로(최신순) 출력
										   + "LIMIT ?, 10";					// LIMIT 0, 10/ LIMIT 10, 10/ LIMIT 20, 10 ... '?', PreparedStatement 처리
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `JSP_BOARD` where cate=?;";
	public static final String SELECT_VIEW = "SELECT * FROM `JSP_BOARD` AS a "
											+ "LEFT JOIN `JSP_FILE` AS b "
											+ "ON a.seq = b.parent "
											+ "WHERE seq=?";
			
	public static final String UPDATE_HIT = "UPDATE `JSP_BOARD` SET hit=hit+1 WHERE seq=?;";
	public static final String UPDATE_DOWNLOAD = "UPDATE `JSP_FILE` SET download=download+1 WHERE parent=?";
	public static final String DELETE_BOARD = "DELETE FROM `JSP_BOARD` WHERE seq=?";
	public static final String INSERT_COMMENT = "INSERT INTO `JSP_BOARD` SET "
												+ "parent=?, "
												+ "content=?, "
												+ "uid=?, "
												+ "regip=?, "
												+ "rdate=NOW()";
	
	public static final String SELECT_COMMENT_LIST = "SELECT a.*, b.nick FROM `JSP_BOARD` AS a "
													+ "JOIN `JSP_USER` AS b ON a.uid = b.uid "
													+ "WHERE parent=? ORDER BY seq ASC";
	
	public static final String SELECT_COUNT_COMMENT = "SELECT COUNT(*) FROM `JSP_BOARD` AS a, `JSP_BOARD` AS b "
													+ "WHERE b.parent=? && a.seq=b.parent";
	
}
