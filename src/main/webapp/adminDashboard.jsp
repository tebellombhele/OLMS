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
    <nav class="navbar navbar-default">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a href="adminDashboard.jsp" class="navbar-brand">Dashboard</a>
        </div>
        <!-- Collection of nav links and other content for toggling -->
    </nav>
    <div class="login-form">
        <div class="well">
            <h1>Welcome to Administration Dashboard </h1><br>
            <ul class="nav navbar-nav">
                <li class="active"><a href="result.jsp">Add Book</a></li>
                <li><a href="updateBook.jsp">Update Book</a></li>
                <li><a href="deleteBook.jsp">Delete Book</a></li>
                <li><a href="">View Registered User</a></li>
            </ul>
             <ul class="nav navbar-nav navbar-right">
                <li><a href="adminLogin.jsp">Logout</a></li>
            </ul>
        </div>
    </div>
</body>
</html>