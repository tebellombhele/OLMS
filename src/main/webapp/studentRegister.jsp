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
	    <h3>Student Registration</h3>
      <form action="StudentRegistration" method="post">
        <input type="hidden" name="action" value="add">        
        <label for= "firstname">First Name</label>
        <input type="text" class="ggg" placeholder="Enter First Name" name="firstname" id="firstname"><br>
        <label for= "lastname">Last Name</label>
        <input type="text" class="ggg" placeholder="Enter Last Name" name="lastname" id="lastname"><br>
        <label for= "username">Username</label>
        <input type="text" class="ggg" placeholder="Enter User Name" name="username" id="username"><br>
        <label for= "password">Password</label>
        <input type="password" class="ggg" placeholder="Enter Password" name="password" id="password"><br>
        <label for= "email">Email</label>
        <input type="text" class="ggg" placeholder="Enter Email" name="email" id="email"><br>
        <label for= "sid">Student ID</label>
        <input type="text" class="ggg" placeholder="Enter Student ID" name="sid" id="sid"><br>
        <div class="clearfix"></div>
        <button type="submit" name="action" value="add">Sign Up</button><br>
      </form>
      <form action="index.jsp">
        <button type="submit" value="Back">Back</button>
      </form>
    </div>
  </div>
</body>
</html>