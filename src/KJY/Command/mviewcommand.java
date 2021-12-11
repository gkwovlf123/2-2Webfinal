package KJY.Command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class mviewcommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("mviewcommand에요");
		String id = request.getParameter("id");
		//id 값을 DB의 select * from member where id=?
		//1. MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.view(id);
		request.setAttribute("dto", dto); //requestScope에 dto 저장
									      //이는 mview.jsp에서 사용
	}

}
