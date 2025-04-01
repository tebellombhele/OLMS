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
    <div class="navbar-header">
        <a href="studentDashboard.jsp" class="navbar-brand">Dashboard</a>
    </div>
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">

    </div>
</nav>

<div class="login-form">
    <div class = "well">
        <h1>Thanks for joining our online library</h1><br>
        <ul class="nav navbar-nav">
            <li class="active">
                <form action = "StudentLogin" method = "post">
                    <button type ="submit" name="Action" value="view">View All Books</button>
                    <button type ="submit" name="Action" value="issue">View Issued Books</button>
                    <button type ="submit" name="Action" value="issue">Recommend Books</button>
                </form>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="studentLogin.jsp">Logout</a></li>
        </ul>
    </div>
</div>

</body>
</html>