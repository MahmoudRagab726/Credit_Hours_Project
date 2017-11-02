<%@page import="Model.Model"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ThrowStatement"%>
<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
    <link rel="stylesheet" href="framework/style.css">
    <link rel="stylesheet" href="framework/bootstrap.min.css">
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>

<body>
    <%
        HttpSession s=request.getSession();
                    Model m=(Model)s.getAttribute("DBObject");
                    String user=m.getSSN();
        
    %>
        
    <header>
        <div class="row">
            <img class="img-responsive resize img-circle" src="images/enroll1.png" alt="Enrollment">
            <ul>
                <a href="index.jsp">
                    <li>Home</li>
                </a>
                <a href="register.jsp?valid=valid">
                        <li>Register</li>
                    </a>
                <!-- remove register button from header-->
                <a href="Hours.jsp?valid=valid">
                    <li class="active">Edit Rules</li>
                </a>
                
                <a href="about.jsp">
                    <li>About</li>
                </a>
                <a>
                    <li id="login_button"><%=user%></li>
                </a>
            </ul>
        </div>
    </header>
    <div class="container">
        <div id="register">
            <form class="formed" action="BackendController" method="post">
    <%
        String validation=request.getParameter("valid");
        if(validation.equals("notvalid")){
            
        
    %>
    <p style="color: red" for="acadmic_id">&nbsp; &nbsp;Can't Register This Student<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;try Again !!!!</p>
    
    <%}else if(validation.equals("valid")){
            
        %>
        <p style="color: red" for="acadmic_id">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Done !!!!</p>
        <%}%>      
        <p>
                    <label for="acadmic_id">Student SSN </label>
                    <input id="Acadmic_id" name="acadmic_ID" type="text">
                </p>
                    <p>
                    <label for="username">Username</label>
                    <input id="username" name="username" type="text">
                </p>
                <p>
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password">
                    <span>Enter a password longer than 8 characters</span>
                </p>
                <p>
                    <label for="confirm_password">Confirm Password</label>
                    <input id="confirm_password" name="confirm_password" type="password">
                    <span>Please confirm your password</span>
                </p>
                <p>
                    <input type="hidden" value="register" name="status">
                    <input type="submit" value="Register" id="register">
                </p>
            </form>
        </div>
    </div>
    </div>
    <footer>
        <small>&copy; Ibrahiem Mohamed , FullStack Web Developer.</small>
    </footer>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/app.js" type="text/javascript" charset="utf-8"></script>
</body>



</html>