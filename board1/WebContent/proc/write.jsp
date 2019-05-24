<!-- 처리페이지 : html태그 필요없음 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/*
	request.setCharacterEncoding("UTF-8");

	String subject  = request.getParameter("subject");
	String content  = request.getParameter("content");
	String regip	= request.getRemoteAddr();
	*/
	
	// 테스트용
	String path = "C:/test"; // 파일저장경로
	
	// 배포용(board1>data 디렉토리의 실제 경로)
	// String path = request.getServletContext().getRealPath("/data");
	
	int maxSize = 1024 * 1024 * 10; // 최대 허용 파일용량 = 10MB (1024(=1KB)*1024=1MB)
	// 추가한 라이브러리(cos.jar)의 클래스, mr객체 안에 subject, content를 뽑아낼 것
	MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());	
	String subject  = mr.getParameter("subject");
	String content  = mr.getParameter("content");
	String fileName = mr.getFilesystemName("file");	// 파일명(단순 문자열, 실제 파일x)
	String regip    = request.getRemoteAddr();
	String newName  = null;
	
	// 세션에서 사용자 아이디 가져오기
	UserBean ub = (UserBean) session.getAttribute("user");
	String uid = ub.getUid();
	
	if(fileName != null){	// null일 경우 파일 첨부x, null이 아닐 경우 파일 첨부o
		// 1.파일명 생성
		// 확장자명 분리
		int i = fileName.lastIndexOf("."); // 특정 문자열을 뽑아내는 메서드 이용 : 확장자명을 따로 분리하기 위함
		String ext = fileName.substring(i);	// = 확장자(ex.jpg)
		
		// 파일명에 들어갈 날짜 및 시간
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
		String now = sdf.format(new Date());
		
		// 파일명 생성
		newName = now+uid+ext; // uid=현재 로그인되어 있는 사용자 아이디, ex.newName=20190524104512_abcd.txt
		
		// 2.파일명 변경
		// 1단계 - 파일객체 생성
		File oldFile = new File(path+"/"+fileName);
		File newFile = new File(path+"/"+newName);
		
		// 2단계 - 스트림 생성
		FileInputStream  fis = new FileInputStream(oldFile);
		FileOutputStream fos = new FileOutputStream(newFile);
		
		// 3단계 - 스트림에 버퍼연결
		BufferedInputStream  bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// 4단계 - 데이터 읽기와 쓰기(Copy & Paste)
		while(true){
			// 입력 버퍼스트림으로 데이터 읽기
			int value = bis.read();	// oldFile의 데이터를 읽어들임
			
			if(value == -1){		// 읽어들일 데이터가 없다면
				break;
			}
			// 출력 버퍼스트림으로 데이터 쓰기
			bos.write(value);
		}
		
		// 5단계 - 스트림해제
		bis.close();
		bos.close();
		fis.close();
		fos.close();
		
		// 원본은 이제 필요없기 때문에 지운다.
		oldFile.delete();
	}
	
	// 게시물 내용 INSERT + INSERT된 게시물 내용 번호 SELECT
	// 1단계, 2단계
	Connection conn = DBConfig.getConnection();
	
	// 트랜젝션 시작 begin : (3단계, 4단계)두 개의 쿼리문을 하나의 동작으로 실행하게 해준다.
	conn.setAutoCommit(false);	// 커밋이 기본적으로 자동인데, 여기에서는 꺼놓음
	
	// 3단계
	Statement stmt = conn.createStatement();
	
	PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_BOARD);
	psmt.setString(1, subject);
	psmt.setString(2, content);
	psmt.setString(3, uid);
	psmt.setString(4, regip);
	
	// 4단계
	psmt.executeUpdate();
	ResultSet rs = stmt.executeQuery(SQL.SELECT_MAX_SEQ);
	
	// 트랜젝션 끝 commit
	conn.commit();
	
	// 5단계 - 결과셋 처리(SELECT일 경우)
	int parent = 0;
	if(rs.next()){
		parent = rs.getInt(1);
	}
	
	// 6단계 - 데이터베이스 종료
	psmt.close();
	conn.close();
	
	
	if(fileName != null){
		// 첨부파일 내용 INSERT
		// 1단계, 2단계
		Connection conn1 = DBConfig.getConnection();
		
		// 3단계
		PreparedStatement psmt1 = conn1.prepareStatement(SQL.INSERT_FILE);
		psmt1.setInt(1, parent);
		psmt1.setString(2, fileName);
		psmt1.setString(3, newName);
		
		// 4단계
		psmt1.executeUpdate();
		
		// 5단계
		// 6단계
		psmt1.close();
		conn1.close();
	}
	
	// 글목록 화면 이동
	response.sendRedirect("../list.jsp");
	
%>