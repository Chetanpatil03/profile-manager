<%@ page import="in.cb.bean.User"%>
<%
User user = (User) session.getAttribute("loggedInUser");
if (user == null) {
	response.sendRedirect("login");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/auth.css">
</head>
<body>


	<div class="container">
		<div class="signup-card">

			<!-- LEFT PANEL -->
			<div class="left-panel">
				<h1>Welcome!</h1>
				<p>Edit your account and continue your journey with us. Access
					exclusive features and stay connected.</p>
			</div>

			<!-- RIGHT PANEL -->
			<div class="right-panel">
				<h2>Edit profile</h2>

				<form method="post" action="editUser">
					<input type="email" value="<%=user.getEmail()%>" readonly>
					<input type="text" value="<%=user.getName()%>" required> <input
						type="tel" value="<%=user.getPhone()%>" required> 
						
						<select name="designation" required>
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

						<option value="Teacher"
							<%="Teacher".equals(user.getDesignation()) ? "selected" : ""%>>
							Teacher</option>

						<option value="Working Professional"
							<%="Working Professional".equals(user.getDesignation()) ? "selected" : ""%>>
							Working Professional</option>

						<option value="Others"
							<%="Others".equals(user.getDesignation()) ? "selected" : ""%>>
							Others</option>
					</select> <select name="gender" required>
						<option value="">Select Gender</option>

						<option value="Male"
							<%="Male".equals(user.getGender()) ? "selected" : ""%>>
							Male</option>

						<option value="Female"
							<%="Female".equals(user.getGender()) ? "selected" : ""%>>
							Female</option>

						<option value="Other"
							<%="Other".equals(user.getGender()) ? "selected" : ""%>>
							Other</option>
					</select>

					<textarea><%=user.getBio()%></textarea>

					<button type="submit">Update</button>
				</form>
			</div>

		</div>
	</div>

</body>
</html>
