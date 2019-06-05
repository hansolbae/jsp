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
			
			// ��ü �Խù� ���� ���ϱ�
			int total = dao.getTotalCount();
			int page = getPage(total);
			
			// ����Ʈ ī��Ʈ ��ȣ
			int count = getListCount(total, start);
			
			// ������ �׷� ����, �� ���ϱ�
			//int[] groupStartEnd = getPageGroupStartEnd();
			
			List<BoardVO> list = dao.selectList(start);
			
			// View���� ���
			req.setAttribute("list", list);
			req.setAttribute("page", page);
			req.setAttribute("count", count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/list.jsp";
	}
	
	// Limit start ���
	private int getLimitStart(String pg) {	// ��޹��� : private �޼���(public ���)
		
		int start = 0;
		
		if(pg == null) {
			start = 1;
		} else {
			start = Integer.parseInt(pg);
		}
		
		return (start - 1) * 10;
	}

	// ��� page ��ȣ ���
	private int getPage(int total) {
		
		int page = 0;
		
		if(total%10 == 0) {
			page = total / 10;
		} else {
			page = (total / 10) + 1;
		}
		
		return page;
	}
	
	// ī��Ʈ ��ȣ ���
	private int getListCount(int total, int start) {
		return total - start;
	}
	/*
	private int[] getPageGroupStartEnd(String pg, int totalPage) {
		
		int[] startEnd = new int[2];
		
		int current = getCurrentPage(pg);	// pg=1�̸� current=1, pg=2�̸� current=2
		int currentGroup = (int) Math.ceil(current/10.0);	// currentGroup = ���� �������� �׷�
		int groupStart = (currentGroup - 1) * 10 + 1;	// �� �׷��� start�� ����
		int groupEnd   = currentGroup * 10;				// �� �׷��� end�� ����
		
		if(groupEnd > totalPage){		// end���� ����, totalPage : getTotalPage�޼��� ȣ���ؾ���
			groupEnd = totalPage;
		}
		
		groupStartEnd[0] = groupStart;
		groupStartEnd[1] = groupEnd;	// 2��¥�� �迭�� start��, end���� ���� ��Ƴ���
		
		
		return startEnd;
	}
	*/
	
	
	
	
	
	
}
