package kr.co.board2.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.BoardDao;
import kr.co.board2.vo.BoardVO;

public class ListService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String pg = req.getParameter("pg");
		
		BoardDao dao = BoardDao.getInstance();
		
		try {
			
			int start = getLimitStart(pg);
			
			// 전체 게시물 갯수 구하기
			int total = dao.getTotalCount();
			int page = getPage(total);
			
			// 리스트 카운트 번호
			int count = getListCount(total, start);
			
			// 페이지 그룹 시작, 끝 구하기
			//int[] groupStartEnd = getPageGroupStartEnd();
			
			List<BoardVO> list = dao.selectList(start);
			
			// View에서 사용
			req.setAttribute("list", list);
			req.setAttribute("page", page);
			req.setAttribute("count", count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/list.jsp";
	}
	
	// Limit start 계산
	private int getLimitStart(String pg) {	// 고급문법 : private 메서드(public 대신)
		
		int start = 0;
		
		if(pg == null) {
			start = 1;
		} else {
			start = Integer.parseInt(pg);
		}
		
		return (start - 1) * 10;
	}

	// 출력 page 번호 계산
	private int getPage(int total) {
		
		int page = 0;
		
		if(total%10 == 0) {
			page = total / 10;
		} else {
			page = (total / 10) + 1;
		}
		
		return page;
	}
	
	// 카운트 번호 계산
	private int getListCount(int total, int start) {
		return total - start;
	}
	/*
	private int[] getPageGroupStartEnd(String pg, int totalPage) {
		
		int[] startEnd = new int[2];
		
		int current = getCurrentPage(pg);	// pg=1이면 current=1, pg=2이면 current=2
		int currentGroup = (int) Math.ceil(current/10.0);	// currentGroup = 현재 페이지의 그룹
		int groupStart = (currentGroup - 1) * 10 + 1;	// 각 그룹의 start값 구함
		int groupEnd   = currentGroup * 10;				// 각 그룹의 end값 구함
		
		if(groupEnd > totalPage){		// end값의 조건, totalPage : getTotalPage메서드 호출해야함
			groupEnd = totalPage;
		}
		
		groupStartEnd[0] = groupStart;
		groupStartEnd[1] = groupEnd;	// 2개짜리 배열에 start값, end값을 각각 담아놓음
		
		
		return startEnd;
	}
	*/
	
	
	
	
	
	
}
