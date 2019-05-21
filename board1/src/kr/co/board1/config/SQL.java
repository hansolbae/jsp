package kr.co.board1.config;

public class SQL {
	
	// ȸ������
	public static final String SELECT_TERMS = "SELECT * FROM `JSP_TERMS`;"; // �������� ; ��������
	public static final String SELECT_USER = "SELECT * FROM `JSP_USER` WHERE uid=? AND pass=PASSWORD(?);";
	public static final String INSERT_USER = "INSERT INTO `JSP_USER` SET "
												 // sql += "uid='"+id+"',";
												 +"uid=?,"
											     // PASSWORD() �����Լ� �̿�
												 +"pass=PASSWORD(?),"
												 +"name=?,"
												 +"nick=?,"
											     +"email=?,"
											     +"hp=?,"
												 // grade : ����Ʈ ��(2)�� �����Ǿ� �����Ƿ� ����
											     +"zip=?,"
											     +"addr1=?,"
											     +"addr2=?,"
											     +"regip=?,"
											     +"rdate=NOW()";
	
	// uid=? �� prepareStatement ���
	public static final String SELECT_USER_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE uid=?;";
	public static final String SELECT_NICK_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE nick=?;";
	public static final String SELECT_EMAIL_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE email=?;";
	public static final String SELECT_HP_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE hp=?;";
	
	
	// �Խ��ǰ���
	public static final String INSERT_BOARD = "INSERT INTO `JSP_BOARD` SET "
											+ "title=?,"	// ������ : �����ؾ��ϹǷ� �־�� ��
											+ "content=?,"	// �۳��� : �����ؾ��ϹǷ� �־�� ��
											+ "uid=?,"		// ����� ���̵�
											+ "regip=?,"	// ����� IP�ּ�
											+ "rdate=NOW()";
	
	public static final String SELECT_LIST = "SELECT a.*, b.nick FROM `JSP_BOARD` AS a "
										   + "JOIN `JSP_USER` AS b ON a.uid = b.uid "
										   + "ORDER BY seq DESC "	// ������ ��ȣ�� ū �������(�ֽż�) ���
										   + "LIMIT ?, 10";			// LIMIT 0, 10/ LIMIT 10, 10/ LIMIT 20, 10 ... '?', PreparedStatement ó��
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `JSP_BOARD`;";
	
}
