package KJY.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KJY.Command.BCommand;
import KJY.Command.MCommand;
import KJY.Command.MlistCommand;
import KJY.Command.bListcommand;
import KJY.Command.bdeleteCommand;
import KJY.Command.binsertCommand;
import KJY.Command.bupdateCommand;
import KJY.Command.bviewcommand;
import KJY.Command.mdeletecommand;
import KJY.Command.minsertCommand;
import KJY.Command.mupdatecommand;
import KJY.Command.mviewcommand;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		System.out.println("com : " + com);
		String viewPage = "";
		if(com!=null && com.trim().equals("list")) {
			System.out.println("list를 찾았다");
			MCommand command = new MlistCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/mList.jsp";
			//1. model 부분의 서비스를 실행
			//2. 해당되는 view를 이동
		}
		else if(com!=null && com.trim().equals("insertForm")) {
			viewPage = "/WEB-INF/view/minsertForm.jsp";
			
		}
		else if(com!=null && com.trim().equals("insert")) {
			//1. minsertCommand 생성
			MCommand command = new minsertCommand();
			//2. minsertCommand의 execute 메소드를 실행
			command.execute(request, response);
			viewPage = "/WEB-INF/view/list.do";
		}
		else if(com!=null && com.trim().equals("view")) {
			//1. mviewcommand 생성
			MCommand command = new mviewcommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "/WEB-INF/view/mView.jsp";
		}
		else if(com!=null && com.trim().equals("update")) {
			//1. mviewcommand 생성
			MCommand command = new mupdatecommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "list.do";
			
		}
		else if(com!=null && com.trim().equals("delete")) {
			//1. mviewcommand 생성
			MCommand command = new mdeletecommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "list.do";
			
		}
		else if(com!=null && com.trim().equals("Boardlist")) {
			//1. mviewcommand 생성
			BCommand command = new bListcommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "/WEB-INF/view/bList.jsp";
			
		}
		else if(com!=null && com.trim().equals("bview")) {
			//1. mviewcommand 생성
			BCommand command = new bviewcommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "/WEB-INF/view/bView.jsp";
		}
		else if(com!=null && com.trim().equals("insertBoard")) {
			//1. mviewcommand 생성
			BCommand command = new binsertCommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "/WEB-INF/view/binsertForm.jsp";
		}
		else if(com!=null && com.trim().equals("binsert")) {
			//1. minsertCommand 생성
			BCommand command = new binsertCommand();
			//2. minsertCommand의 execute 메소드를 실행
			command.execute(request, response);
			viewPage = "/WEB-INF/view/Boardlist.do";
		}
		else if(com!=null && com.trim().equals("bupdate")) {
			//1. mviewcommand 생성
			BCommand command = new bupdateCommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "/WEB-INF/view/Boardlist.do";
			
		}
		else if(com!=null && com.trim().equals("bdelete")) {
			//1. mviewcommand 생성
			BCommand command = new bdeleteCommand();
			//2. execute 메소드 실행
			command.execute(request, response);
			//3. 해당되는 viewpage 설정
			viewPage = "/WEB-INF/view/Boardlist.do";
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
