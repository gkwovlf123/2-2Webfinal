package KJY.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DAO.MemberDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;

public class bdeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String no = request.getParameter("no");
		BoardDTO dto = new BoardDTO();
		dto.setNo(Integer.parseInt(no));
		BoardDAO dao = new BoardDAO();
		dao.bdelete(dto.getNo()+"");
	}

}
