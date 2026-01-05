<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/auth.css">
</head>

<body>



	<div class="container">
		<div class="signup-card">

			<!-- LEFT PANEL -->
			<div class="left-panel">
				<h1>Welcome Back!</h1>
				<p>Login to your account and continue your journey with us.</p>
			</div>

			<div class="right-panel login-panel">
				<div class="login-box">
					<h2>Login</h2>
					<p class="login-subtitle">Welcome back! Please login to your
						account.</p>
					<form action = "loginForm" method = "post">
						<input type="email" placeholder="Email Address" name = "email" required>
						<input type="password" placeholder="Password" name = "password" required>

						<button type="submit">Login</button>

						<p class="switch">
							Don’t have an account? <a href="signup">Sign Up</a>
						</p>
					</form>
				</div>
			</div>


		</div>
	</div>
	
	<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
	%>
		<script>
    		alert("<%=error%>");
		</script>
	<%
		}
	%>

</body>

</html>