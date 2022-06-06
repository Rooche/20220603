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

@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");

		Gson gson = new GsonBuilder().create();

		TodoDAO dao = new TodoDAO();
		if (req.getMethod().equals("GET")) {
			List<Todo> list = dao.doList();
			resp.getWriter().print(gson.toJson(list));

		} else if (req.getMethod().equals("POST")) {
			String cont = req.getParameter("content");
			Todo td = new Todo();
			td.setContent(cont);

			dao.insertlist(td);
		}
	}
}
