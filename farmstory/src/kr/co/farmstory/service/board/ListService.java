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
		
		BoardDao dao = BoardDao.getInstance();
		
		try {
			List<BoardVO> list = dao.list("story", 0);
			req.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/board/list.jsp";
	}
	
}
