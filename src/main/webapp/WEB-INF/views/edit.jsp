<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth.css">
</head>
<body>

<div class="container">
    <div class="signup-card">

        <!-- LEFT PANEL -->
        <div class="left-panel">
            <h1>Welcome!</h1>
            <p>
                Edit your account and continue your journey with us.
                Access exclusive features and stay connected.
            </p>
        </div>

        <!-- RIGHT PANEL -->
        <div class="right-panel">
            <h2>Edit profile</h2>

            <form>
                <input type="text" placeholder="Full Name" required>
                <input type="email" placeholder="Email Address" required>
                <input type="password" placeholder="Password" required>  
                <input type="tel" placeholder="Phone Number" required>
                
                <select required>
                    <option value="">Select Designation</option>
                    <option>Student</option>
                    <option>Software Engineer</option>
                    <option>Data Analyst</option>
                    <option>Teacher</option>
                    <option>Working Professioinal</option>
                    <option>Others</option>	
                </select>

                <select required>
                    <option value="">Select Gender</option>
                    <option>Male</option>
                    <option>Female</option>
                    <option>Other</option>
                </select>

                <textarea placeholder="Enter Bio"></textarea>

                <button type="submit">Update</button>
            </form>
        </div>

    </div>
</div>

</body>
</html>
