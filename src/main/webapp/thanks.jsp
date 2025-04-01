<jsp:useBean id="user" scope="request" type="com.olms.olms.bean.Student"/>
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
        <h1>${user.firstName}, Thanks for registering on our system</h1>
        <h3>Login to continue</h3>
        <form action="studentLogin.jsp">
            <button type="submit" value="Login">Login</button>
        </form>
    </div>
</div>
</body>
</html>