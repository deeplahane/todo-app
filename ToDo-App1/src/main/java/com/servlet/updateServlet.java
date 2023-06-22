package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connect.Connector;
import com.dao.ToDoDAO;
import com.entities.Message;
import com.entities.TodoDetails;

@WebServlet("/update")
public class updateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String task=req.getParameter("task");
		String status=req.getParameter("status");
		
		ToDoDAO dao=new ToDoDAO(Connector.getCon());
		
		HttpSession session=req.getSession();
		TodoDetails t=new TodoDetails();
		t.setId(id);
		t.setName(name);
		t.setTask(task);
		t.setStatus(status);
		
	 boolean f=dao.updateTaskById(t);
		
		if(f) {
			Message msg=new Message("Task updated successfully...","alert-success");
			session.setAttribute("msg", msg);
			res.sendRedirect("index.jsp");
		}else {
			Message msg=new Message("Oops! Something went wrong...","alert-danger");
			session.setAttribute("msg", msg);
			res.sendRedirect("add_task.jsp");
		}
		
	}
}
