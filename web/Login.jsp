<!DOCTYPE html>
<html>
    
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" href="framework/style.css">
        <link rel="stylesheet" href="framework/bootstrap.min.css">
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

    </head>
    
    <body>
        <header>
            <div class="row">
                <img class="img-responsive resize img-circle" src="images/enroll1.png" alt="Enrollment">
                <ul>
                    <a href="index.jsp">
                    <li>Home</li>
                    
                    <a href="about.jsp">
                    <li>About</li>
                </a>
                    <a href="Login.jsp">
                    <li id="login_button">Login</li>
                </a>
                </ul>
            </div>
        </header>
        <div class="container">
            <div id="submit1">
                <form class="formed" action="BackendController" method="post">
                    <p>
                        <label for="username">Username</label>
                        <input id="username" name="username" type="text">
                        <!-- </p>-->
                        <p>
                            <label for="password">Password</label>
                            <input id="password" name="password" type="password">
                        </p>
                        <!-- <p>-->
                        <input type="hidden" value="login" name="status">
                        <input type="submit" value="Submit" id="submit">
                
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