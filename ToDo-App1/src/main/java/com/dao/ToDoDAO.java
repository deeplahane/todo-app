package com.dao;
import com.entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {
	private Connection conn;
	
	public ToDoDAO(Connection conn){
		super();
		this.conn=conn;
	}
	
	public boolean addTask(String name,String task,String status) {
		boolean f=false;
		
		try {
			
			String q="INSERT INTO todo_app(name,task,status) VALUES(?,?,?);";
			
			PreparedStatement ps=conn.prepareStatement(q);
			ps.setString(1,name);
			ps.setString(2,task);
			ps.setString(3,status);
			
			int v=ps.executeUpdate();
			
			if(v==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<TodoDetails> getToDo(){
		
		List<TodoDetails> list=new ArrayList<TodoDetails>();
		
		TodoDetails t=null;
		try {
			String q="SELECT * FROM todo_app;";
			PreparedStatement pst=conn.prepareStatement(q);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				t=new TodoDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTask(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public TodoDetails updateTask(int i) {
		TodoDetails t=null;
		
		try {
			String q="SELECT * FROM todo_app WHERE id=?;";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setInt(1,i);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				t=new TodoDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTask(rs.getString(3));
				t.setStatus(rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	public boolean updateTaskById(TodoDetails t) {
		boolean f=false;
		
		try {
			String q="UPDATE todo_app SET name=?,task=?,status=? WHERE id=?";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setString(1, t.getName());
			pst.setString(2, t.getTask());
			pst.setString(3, t.getStatus());
			pst.setInt(4,t.getId());
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteTask(int i) {
		boolean f=false;
		
		try {
			
			String q="DELETE FROM todo_app WHERE id=? ;";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setInt(1,i);
			int v=pst.executeUpdate();
			
			if(v==1) {
				f=true;	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}





