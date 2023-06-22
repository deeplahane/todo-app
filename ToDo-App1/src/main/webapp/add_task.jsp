<%@page import="com.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="components/all_css.jsp"%>
<meta charset="ISO-8859-1">
<title>Add Task</title>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="components/navbar.jsp"%>

	<!-- main body start -->

	<div class="container mt-4 ">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card ">
					<div class="card-head text-center mt-4">
						<h2 style="color: #007bff">Add Task</h2>
					</div>
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
					<div class="card-body">
						<form action="add_task" method="post">
							<div class="form-group">
								<label for="input1">Name</label> <input type="text"
									class="form-control" id="input1" placeholder="Jhon Doe"
									name="name">

							</div>
							<div class="form-group">
								<label for="input">Task</label> <input type="text"
									class="form-control" id="input" placeholder="Go to gym"
									name="task">

							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select
									class="form-control" id="inputState" name="status">
									<option selected>---Select---</option>
									<option value="pending">Pending</option>
									<option value="complete">Complete</option>
								</select>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">ADD</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- main body end -->
</body>
</html>