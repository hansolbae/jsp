<%@page import="kr.co.ch14.MemberBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");

	//데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	final String USER = "bhs";
	final String PASS = "1234";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	MemberBean mb = null;

	try {
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
			
		// 2단계 - 데이터베이스 접속
		conn = DriverManager.getConnection(HOST, USER, PASS);
		
		// 3단계 - SQL 실행객체 생성
		stmt = conn.createStatement();
		
		// 4단계 - SQL 실행
		rs = stmt.executeQuery("SELECT * FROM `MEMBER` WHERE uid='"+uid+"';");
		
		// ★ 5단계 - 결과셋처리(SELECT일 경우)
		mb = new MemberBean();
		
		if(rs.next()) {
			mb.setUid(rs.getString(2));
			mb.setName(rs.getString(3));
			mb.setHp(rs.getString(4));
			mb.setPos(rs.getString(5));
			mb.setDep(rs.getInt(6));
			mb.setRdate(rs.getString(7));
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		
		// 6단계 - 데이터베이스 종료
		rs.close();
		stmt.close();
		conn.close();
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>14-5</title>
</head>
<body>
	<h3>직원 수정</h3>
	
	<form action="14-6.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<!-- uid : 키값이므로 변경할 수 없도록 제한함(readonly 사용) -->
				<!-- readonly="readonly" → readonly -->
				<td><input type="text" name="uid" value="<%= mb.getUid() %>" readonly placeholder="아이디 입력" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%= mb.getName() %>" placeholder="이름 입력" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="<%= mb.getHp() %>" maxlength="13" placeholder="휴대폰 입력" /></td>
			</tr>
			<tr>
				<td>직급</td>
				<td>
					<select name="pos">
						<option>사원</option>
						<option>대리</option>
						<option>과장</option>
						<option>차장</option>
						<option>부장</option>
						<option>이사</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>
					<select name="dep">
						<option value="101">영업1부</option>
						<option value="102">영업2부</option>
						<option value="103">영업3부</option>
						<option value="104">영업4부</option>
						<option value="105">영업지원부</option>
						<option value="106">인사부</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>