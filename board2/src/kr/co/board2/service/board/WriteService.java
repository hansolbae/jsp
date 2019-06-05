package kr.co.board2.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.BoardDao;
import kr.co.board2.vo.BoardVO;
import kr.co.board2.vo.UserVO;

public class WriteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			
			return "/write.jsp";
			
		} else {
			
			String title   = req.getParameter("subject");
			String content = req.getParameter("content");
			String regip   = req.getRemoteAddr();
			
			HttpSession session = req.getSession();	// 세션에서 사용자 아이디 가져오기
			UserVO uvo = (UserVO) session.getAttribute("user");
			String uid = uvo.getUid();
			
			BoardVO bvo = new BoardVO();
			bvo.setTitle(title);
			bvo.setContent(content);
			bvo.setRegip(regip);
			bvo.setUid(uid);
			bvo.setFile(0);
			
			BoardDao dao = BoardDao.getInstance();	// 싱글톤 객체
			
			try {
				dao.insertBoard(bvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/board2/list.do";
	}
	
}
