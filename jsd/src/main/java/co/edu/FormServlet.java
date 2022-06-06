package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formServlet")
public class FormServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
	}
	
	@Override
	//doPost는 doGet이 실행후 실행이 된다
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter(); // 출력 스트림
		
		String user = req.getParameter("user"); //파라미터 속성이 네임속성(user) form.jsp input에 있음
		String pass = req.getParameter("passwd"); //파라미터 속성이 네임속성(passwd) form.jsp input에 있음
		String cmd = req.getParameter("cmd"); // 멀티파트에서는 이 3개를 못읽어온다고 함
		
		MessageDAO dao = new MessageDAO();
		
		if(cmd.equals("search")) {
		Message msg = dao.getMessage(user,  pass);
		
		out.print("<h3>메세지 정보</h3>"); // 우리가 만든 html => DOM이 해석해서 적절한 페이지를 만들어줌
		out.print("<p>메세지 내용 " + msg.getContent() + "</p>");
		out.print("<p>작성자 " + msg.getWriter() + "</p>");
		
		}else if(cmd.equals("insert")){
			out.print("<p>입력한 user정보 " + user + "</p>");
			out.print("<p>입력한 pass정보 " + pass + "</p>");
		}
		
		// multipart request
		
	}
}
