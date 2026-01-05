<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth.css">
</head>
<body>

<%
	
%>

<div class="container">
    <div class="signup-card">

        <!-- LEFT PANEL -->
        <div class="left-panel">
            <h1>Welcome!</h1>
            <p>
                Create your account and start your journey with us.
                Access exclusive features and stay connected.
            </p>
        </div>

        <!-- RIGHT PANEL -->
        <div class="right-panel">
            <h2>Create Account</h2>

            <form action = "${pageContext.request.contextPath}/saveUser" method = "post">
                <input type="text" placeholder="Full Name" name = "name" required>
                <input type="email" placeholder="Email Address" name = "email" required>
                <input type="password" placeholder="Password" name ="pass" required>  
                <input type="tel" placeholder="Phone Number" name = "phone" required>
                
                <select name = "designation" required >
                    <option value="">Select Designation</option>
                    <option>Student</option>
                    <option>Software Engineer</option>
                    <option>Data Analyst</option>
                    <option>Teacher</option>
                    <option>Working Professioinal</option>
                    <option>Others</option>
                </select>

                <select name="gender"  required>
                    <option value="">Select Gender</option>
                    <option>Male</option>
                    <option>Female</option>
                    <option>Other</option>
                </select>

                <textarea placeholder="Enter Bio" name = "bio"></textarea>

                <button type="submit">Sign Up</button>

                <p class="switch">
                    Already have an account?
                    <a href="login">Login</a>
                </p>
            </form>
        </div>

    </div>
</div>

</body>
</html>
