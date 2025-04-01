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
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="result.jsp">Add Book</a></li>
            <li><a href="updateBook.jsp">Update Book</a></li>
            <li><a href="deleteBook.jsp">Delete Book</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="adminLogin.jsp">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="login-form">
    <div class="well">
        <h3>Delete a Book</h3>
        <form action="DeleteBook" method="post" align="center">
            <input type="hidden" name="action" value="delete">
            <label for= "bookid">Book ID</label>
            <input type="text" class="ggg" placeholder="Enter Book ID" name="bookid" id="bookid" ><br>
            <div class="clearfix">
                <button type="submit" name="action" value="delete">Delete</button><br>
                <p>${message}</p>
            </div>
        </form>
    </div>
</div>
</body>
</html>


