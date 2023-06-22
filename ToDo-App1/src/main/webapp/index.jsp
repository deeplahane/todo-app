<%@page import="java.util.List"%>
<%@page import="com.dao.ToDoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.connect.Connector"%>
<%@ page import="com.entities.Message"%>
<%@ page import="com.entities.TodoDetails"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="components/all_css.jsp"%>

<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<%@include file="components/navbar.jsp"%>


	<!-- main body start -->
	<!-- <h1 class="text-center mt-4" style="color: #007bff">TODO APP</h1> -->
	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>" role="alert">
		<%=m.getContent()%>
	</div>
	<%
	session.removeAttribute("msg");
	}
	%>

	<div class="container mt-4">
		<table class="table table-striped" border="1px">
			<thead class="text-white" style="background-color: #808080">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Task</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				ToDoDAO dao = new ToDoDAO(com.connect.Connector.getCon());
				List<TodoDetails> task = dao.getToDo();
				for (TodoDetails t : task) {
				%>
				<tr>
					<th scope="row"><%=t.getId()%></th>
					<th><%=t.getName()%></th>
					<td><%=t.getTask()%></td>
					<td><%=t.getStatus()%></td>
					<td><a href="edit_task.jsp?id=<%= t.getId() %> "
						class="btn btn-sm btn-secondary">Edit</a> <a href=" delete?id=<%= t.getId() %> "
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<!-- main body end -->

</body>
</html>