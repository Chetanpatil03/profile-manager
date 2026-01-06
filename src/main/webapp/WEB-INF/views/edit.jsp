<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="in.cb.bean.User"%>

<%
User user = (User) session.getAttribute("loggedInUser");
if (user == null) {
	response.sendRedirect("login");
	return;
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/auth.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/edit.css">
</head>

<body>

	<div class="container">
		<div class="signup-card">

			<!-- LEFT PANEL -->
			<div class="left-panel">
				<h1>Welcome!</h1>
				<p>Edit your account and continue your journey with us.</p>
			</div>

			<!-- RIGHT PANEL -->
			<div class="right-panel">
				<h2>Edit Profile</h2>

				<form method="post" action="updateProfile">

					<input type="email" name="email" value="<%=user.getEmail()%>"
						readonly> <input type="text" name="name"
						value="<%=user.getName()%>" required> <input type="tel"
						name="phone" value="<%=user.getPhone()%>" required> <select
						name="designation" required>
						<option value="">Select Designation</option>
						<option value="Student"
							<%="Student".equals(user.getDesignation()) ? "selected" : ""%>>
							Student</option>
						<option value="Software Engineer"
							<%="Software Engineer".equals(user.getDesignation()) ? "selected" : ""%>>
							Software Engineer</option>
						<option value="Data Analyst"
							<%="Data Analyst".equals(user.getDesignation()) ? "selected" : ""%>>
							Data Analyst</option>
					</select> <select name="gender" required>
						<option value="">Select Gender</option>
						<option value="Male"
							<%="Male".equals(user.getGender()) ? "selected" : ""%>>
							Male</option>
						<option value="Female"
							<%="Female".equals(user.getGender()) ? "selected" : ""%>>
							Female</option>
					</select>

					<textarea name="bio"><%=user.getBio()%></textarea>

					<div class="form-actions">
					
					<button type="button" class="btn-home"
							onclick="location.href='home'">
							<span class="btn-icon">🏠</span> Home
						</button>
						
						<button type="submit" class="btn-update">
							<span class="btn-icon">💾</span> Update
						</button>

						
					</div>



				</form>
			</div>
		</div>
	</div>

	<%
	String success = (String) request.getAttribute("success");
	String error = (String) request.getAttribute("error");

	if (success != null) {
	%>
	<div style="color: green;"><%=success%></div>
	<%
	}
	if (error != null) {
	%>
	<div style="color: red;"><%=error%></div>
	<%
	}
	%>

</body>
</html>
