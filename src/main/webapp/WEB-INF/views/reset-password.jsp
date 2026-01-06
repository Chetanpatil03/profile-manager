<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Reset Password</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/auth.css">
</head>

<body>

	<div class="container">
		<div class="signup-card">

			<!-- LEFT PANEL -->
			<div class="left-panel">
				<h1>Reset Password</h1>
				<p>Create a new password to secure your account.</p>
			</div>

			<!-- RIGHT PANEL -->
			<div class="right-panel login-panel">
				<div class="login-box">

					<h2>New Password</h2>
					<p class="login-subtitle">Choose a strong password</p>

					<form method="post" action="resetPassword">

						<input type="password" name="newPassword"
							placeholder="New Password" required> <input
							type="password" name="confirmPassword"
							placeholder="Confirm Password" required>

						<button type="submit">Update Password</button>

						<p class="switch">
							Back to <a href="login">Login</a>
						</p>

					</form>
				</div>
			</div>

		</div>
	</div>

	<%
	String error = (String) request.getAttribute("error");
	String success = (String) request.getAttribute("success");
	%>

	<%
	if (error != null) {
	%>
	<script>
        alert("<%=error%>");
    </script>
	<%
	}
	%>

	<%
	if (success != null) {
	%>
	<script>
        alert("<%=success%>
		");
	</script>
	<%
	}
	%>


</body>
</html>
