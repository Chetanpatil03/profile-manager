<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome | Auth System</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
	
</head>
<body>

    <div class="home-card">
        <h1>Welcome</h1>
        <p>
            A simple and secure authentication system.  
            Login to your account or create a new one to get started.
            <a href = "home">go to home.</a>
        </p>

        <div class="btn-group">
            <a href="login" class="btn btn-login">Login</a>
            <a href="signup" class="btn btn-signup">Sign Up</a>
        </div>
    </div>

</body>
</html>
    