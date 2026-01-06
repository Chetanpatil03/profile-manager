<%@page import="in.cb.bean.User"%>
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
<title>Home | Dashboard</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home.css">

<!-- Base authentication layout -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/auth.css">
</head>

<body>
	<div class="signup-card">

		<!-- LEFT PANEL -->
		<div class="left-panel">
			<h1>
				Welcome 👋
				<%=user.getName()%>
			</h1>
			<p>You have successfully logged in.</p>
		</div>

		<!-- RIGHT PANEL -->
		<div class="right-panel login-panel">
			<div class="login-box">
				<h2>Dashboard</h2>
				<p class="login-subtitle">Manage your account and profile</p>

				<p>This project demonstrates authentication, session handling,
					and user profile management using a modern UI.</p>

				<div class="switch">
					<a href="#profileModal">View Profile</a> | <a href="signup">Delete
						Profile</a> | <a href="index">Logout</a>
				</div>
			</div>
		</div>

	</div>

	<!-- PROFILE VIEW MODAL -->
	<div id="profileModal" class="modal">
		<div class="modal-content">

			<div class="profile-simple-card">

				<!-- Avatar -->
				<div class="profile-avatar" id="profile-avatar"></div>

				<!-- Name & Role -->
				<h2 class="profile-name" id="profile-name"><%=user.getName()%></h2>
				<p class="profile-role"><%=user.getDesignation()%></p>

				<!-- Info -->
				<div class="profile-details">
					<p>
						<strong>Email:</strong>
						<%=user.getEmail()%>
					</p>
					<p>
						<strong>Gender:</strong>
						<%=user.getGender()%>
					</p>
					<p>
						<strong>About:</strong>
						<%=user.getBio()%>
					</p>
				</div>

				<!-- Buttons -->
				<div class="profile-actions">
					<a href="#" class="btn-outline">Close</a> <a href="edit"
						class="btn-primary">Edit</a>
				</div>

			</div>

		</div>
	</div>

	<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
	%>
		<script> alert("<%=error%>"); </script>
	<%
		}
	%>


	<script>
		function generateInitials(name) {
			if (!name)
				return "";

			const words = name.trim().split(" ");
			let initials = "";

			if (words.length === 1) {
				initials = words[0][0];
			} else {
				initials = words[0][0] + words[words.length - 1][0];
			}

			return initials.toUpperCase();
		}

		const nameElement = document.getElementById("profile-name");
		const avatarElement = document.getElementById("profile-avatar");

		const fullName = nameElement.innerText;
		avatarElement.innerText = generateInitials(fullName);

		const colors = [ "#6a7ce3", "#7a5cc7", "#5a6de0", "#8b5cf6", "#6366f1" ];

		avatarElement.style.background = colors[Math.floor(Math.random()
				* colors.length)];
	</script>

</body>

</html>