<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>College Online Library Management System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>

<div class="login-form">
    <div class = "well">
        <h1>Welcome to the Online Library management System</h1>
        <h3 id="login-line">Login As</h3>

        <form action="adminLogin.jsp">
            <button type="submit" value="Admin">Admin</button>
        </form>
        <br>
        <form action="studentLogin.jsp">
            <button type="submit" value="Student">Student</button>
        </form>

        <h5>Not yet a member. Click below to register...
            <form action="studentRegister.jsp">
                <button type="submit" value="Register">Register</button>
            </form>
        </h5>
    </div>
</div>

</body>
</html>