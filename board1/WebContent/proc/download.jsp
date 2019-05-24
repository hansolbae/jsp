<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	String oldName = request.getParameter("oldName");
	String newName = request.getParameter("newName");
	String parent = request.getParameter("seq");
	
	// 파일다운로드 카운트 업데이트
	// 1단계, 2단계
	Connection conn = DBConfig.getConnection();
	
	// 3단계
	PreparedStatement psmt = conn.prepareStatement(SQL.UPDATE_DOWNLOAD);
	psmt.setString(1, parent);
	
	// 4단계
	psmt.executeUpdate();
	
	// 5단계
	// 6단계
	psmt.close();
	conn.close();
	
	// response 헤더정보 수정(코딩하지 않고, 인터넷 검색한 결과 복사)
	oldName = new String(oldName.getBytes("UTF-8"), "iso-8859-1");	// 한글 깨짐 방지
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment; filename="+oldName);
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "private");
	
	// 테스트용
	String path = "C:/test/";
	
	// 배포용
	// String path = request.getServletContext().getRealPath("/data");
	
	File file = new File(path+newName);
	
	// 스트림연결
	// 1단계 - 스트림 생성
	FileInputStream fis = new FileInputStream(file);
	
	// 2단계 - 스트림에 버퍼연결
	BufferedInputStream  bis = new BufferedInputStream(fis);
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	// 3단계 - 데이터 읽기와 쓰기(Copy & Paste)
	while(true){
		// 입력 버퍼스트림으로 데이터 읽기
		int value = bis.read();	// oldFile의 데이터를 읽어들임
		
		if(value == -1){		// 읽어들일 데이터가 없다면
			break;
		}
		// 출력 버퍼스트림으로 데이터 쓰기
		bos.write(value);
	}
	
	// 4단계 - 스트림해제
	bis.close();
	bos.close();
	fis.close();
	
%>