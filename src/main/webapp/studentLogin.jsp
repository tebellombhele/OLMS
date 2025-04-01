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
        <div class="well">
            <h3>Student Login</h3>
            <form action="StudentLogin" method="post">
                <input type="text" class="ggg" placeholder="Enter User Name" name="username"><br>
                <input type="password" class="ggg" placeholder="Enter Password" name="password"><br>
                <div class="clearfix"></div>
                <button type="submit" name="Action" value="Login">Login</button><br>
                <input type="hidden" name="Action" value="view">
            </form>
            <form action="index.jsp">
                <button type="submit" value="Back">Back</button>
            </form>
        </div>
    </div>
</body>
</html>