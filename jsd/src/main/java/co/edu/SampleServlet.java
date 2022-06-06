package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet {
	// IOC
	@Override
	//최초 실행은 init 호출이 됨 그 이후는 서비스만 ..
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출...");
	}
	
	@Override
	//service가 없으면 get방식 요청은 doget이라는 메소드를 오버라이딩한다
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		
		System.out.println("service 호출..."); //req와 resp는 웹브라우저에서 받은 요청을 처리하기 위해 Http 요청을 처리하기 위한 req, 객체와 Http응답을 위한 resp
		
		//getMethod는 값의 요청한 정보가
		if(req.getMethod().equals("GET")) {
			System.out.println("GET 요청입니다.");
			
		} else if (req.getMethod().equals("POST")){
			System.out.println("POST 요청입니다.");
			
		}
		
		String name = req.getParameter("name"); // name=???
		String age = req.getParameter("age");
		
		PrintWriter out = resp.getWriter(); //출력 메소드
		out.print("<h3>요청파라미터 : " + name + "</h3>");
		out.print("<h3>요청파라미터 : " + age + "</h3>");
		out.close();
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 호출...");
		
	}
}
