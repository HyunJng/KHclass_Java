package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVO;
import board.model.impl.BoardDAO;
import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/management.do")
public class ManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagementController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		
		UserVO uvo = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		// 검색 조건 parameter check
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		List<UserVO> userList = userDAO.getUserList(uvo);
		
		// 검색 결과를 session에 저장하고 getBoardList.jsp로 이동
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		session.setAttribute("userList", userList);
		response.sendRedirect("management.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
