package kr.co.farmstory.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory.controller.CommonService;
import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.BoardVO;

public class ListService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String grp  = req.getParameter("grp");
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		
		BoardDao dao = BoardDao.getInstance();
		
		try {
			
			int start = getLimitStart(pg);
			
			// ��ü �Խù� ���� ���ϱ�
			int total = dao.getTotalCount(cate);
			int page = getPage(total);
			
			// ����Ʈ ī��Ʈ ��ȣ
			int count = getListCount(total, start);
			
			List<BoardVO> list = dao.list(cate, 0);
			req.setAttribute("list", list);
			req.setAttribute("grp", grp);
			req.setAttribute("cate", cate);
			req.setAttribute("page", page);
			req.setAttribute("count", count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/board/list.jsp";
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
		return total - start + 1;
	}

}
