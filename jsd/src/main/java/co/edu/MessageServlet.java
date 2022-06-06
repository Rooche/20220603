package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	
	   @Override
	   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("utf-8");
	      resp.setCharacterEncoding("utf-8");
	      resp.setContentType("text/json;charset=utf-8");
	      
	      Gson gson = new GsonBuilder().create();
	      
	      MessageDAO dao = new MessageDAO();
	      if(req.getMethod().equals("GET")) {
	         List<Message> list = dao.messageList();
	         resp.getWriter().print(gson.toJson(list));
	         
	      }else if(req.getMethod().equals("POST")) {
	         String cont = req.getParameter("content");
	         String writ = req.getParameter("writer");
	         Message msg = new Message();
	         msg.setContent(cont);
	         msg.setWriter(writ);
	         
	         dao.insertMessage(msg);
	         
	      }
	   }
	   
	}