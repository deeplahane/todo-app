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

@WebServlet("/add_task")
public class AddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String name=req.getParameter("name");
		String task=req.getParameter("task");
		String status=req.getParameter("status");
		
		ToDoDAO dao=new ToDoDAO(Connector.getCon());
		boolean f=dao.addTask(name, task, status);
		HttpSession session=req.getSession();
		
		if(f) {
			Message msg=new Message("Task added successfully...","alert-success");
			session.setAttribute("msg", msg);
			res.sendRedirect("index.jsp");
		}else {
			Message msg=new Message("Oops! Something went wrong...","alert-danger");
			session.setAttribute("msg", msg);
			res.sendRedirect("add_task.jsp");
		}
		
	}
}
