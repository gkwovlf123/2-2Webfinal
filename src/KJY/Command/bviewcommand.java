package KJY.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DAO.MemberDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;

public class bviewcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = dao.view(no);
			request.setAttribute("dto", dto);
											      
	}

}
