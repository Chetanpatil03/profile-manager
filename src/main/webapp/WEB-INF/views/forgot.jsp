<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/auth.css">
</head>

<body>

	<div class="container">
		<div class="signup-card">

			<!-- LEFT PANEL -->
			<div class="left-panel">
				<h1>Forgot Password?</h1>
				<p>Don’t worry. We’ll help you verify your account and reset
					your password securely.</p>
			</div>

			<!-- RIGHT PANEL -->
			<div class="right-panel login-panel">
				<div class="login-box">

					<h2>Verify Account</h2>
					<p class="login-subtitle">Enter your details to continue</p>

					<form action="forgotPassword" method="post">

						<input type="email" name="email" placeholder="Email Address"
							required> 
						<input type="text" name="phone"
							placeholder="Last 4 digits of phone number" maxlength="4"
							required>

						<button type="submit">Verify</button>

						<p class="switch">
							Remember your password? <a href="login">Login</a>
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
