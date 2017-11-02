<%@page import="Model.Model"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Edit Hours</title>
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
                    <a href="Hours.jsp">
                        <li class="active">Edit Rules</li>
                    </a>

                    <a href="about.jsp">
                        <li>About</li>
                    </a>
                    <a href="Login.jsp">
                        <li id="login_button"><%=user%></li>
                    </a>
                </ul>
            </div>
        </header>
        <div class="container">
            <div id="hours">
                <form class="hours" action="BackendController" method="post">
                    
                    <%
                        String validation = request.getParameter("valid");
                        if (validation.equals("notvalid")) {

                    %>
                    <p style="color: red" for="acadmic_id">&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;Can't Update Rules <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;try Again !!!!</p>

                    <%} else if (validation.equals("valid")) {

                    %>
                    <p style="color: red" for="acadmic_id">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Done !!!!</p>
                    <%}%> 
                    <p>
                        <label for="Minhours">Minimun Hours</label>
                        <input id="Minhours" name="Minhours" type="text">
                        <!-- </p>-->
                    <p>
                        <label for="Maxhours">Maxmium Hours</label>
                        <input id="Maxhours" name="Maxhours" type="text">
                    </p>
                    <!-- <p>-->
                    <input type="hidden" value="hours_rules" name="status">
                    <input  type="submit" value="SUBMIT" id="submit">
                    </p>
                </form>
            </div>



        </div>
        <footer>
            <small>&copy; Ibrahiem Mohamed , FullStack Web Developer.</small>
        </footer>
        <script src="http://code.jquery.com/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/app.js" type="text/javascript" charset="utf-8"></script>
    </body>

</html>