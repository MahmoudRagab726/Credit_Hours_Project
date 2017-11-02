<%@page import="java.util.*"%>
<%@page import="org.apache.el.stream.Stream"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Model.Model"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>courses</title>
        <link rel="stylesheet" href="framework/style.css">
        <link rel="stylesheet" href="framework/bootstrap.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Amiri:700italic&subset=arabic,latin' rel='stylesheet' type='text/css'>
    </head>
    <%!
        Connection con;
        Statement st;
        ResultSet rs;
        String drivermanager;
        String url;
        String usr, psw;

        HashSet<String> listview = new HashSet<String>();

    %>


    <body>
        <%
            usr = "root";
            psw = "admin";
            drivermanager = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/sciencefac";
            Class.forName(drivermanager);
            con = DriverManager.getConnection(url, usr, psw);
            st = con.createStatement();
            HttpSession s = request.getSession();
            Model m2 = (Model) s.getAttribute("DBObject");
            String user = m2.getSSN();

            if (s.getAttribute("propertyList") != null) {
                listview = (HashSet<String>) request.getSession().getAttribute("propertyList");
                System.out.println("propertyList : size : " + listview.size());
            }


        %>
        <header>
            <div class="row">
                <img class="img-responsive resize img-circle" src="images/enroll1.png" alt="Enrollment">
                <ul>
                    <a href="index.jsp">
                        <li>Home</li>
                    </a>
                    <a href="StudentBackend?statuse=student">
                        <li class="active">Courses</li>
                    </a>
                    <a >

                        <li id="user_name"><%=user%></li>
                    </a>
                    <a >

                        <li id="login_button"><%=user%></li>
                    </a>
                </ul>
            </div>
        </header>
        <div class="container">
            <div class="courses">
                <div class="row">

                    <div class="col-md-4">
                        subname
                    </div>
                    <div class="col-md-4">
                        Number Of Hours
                    </div>
                    <div class="col-md-4">
                        Select
                    </div>
                    <div class="line">
                        <hr width="80%" align="center">
                    </div>



                    <form action="StudentBackend" method="post">

                        <div class="row" id="course-submit">

                            <%
                                try {
                                    for (String courseName : listview) {
                                        System.out.println("wlcom : " + courseName);
                                        String showsql = "select * from subject where course_num = '" + courseName + "'";
                                        rs = st.executeQuery(showsql);
                                        while (rs.next()) {
                                            String subname = rs.getString(2);
                                            String hours = rs.getString(4);
                                            String cours_num = rs.getString(1);

                            %>

                            <div class="col-md-4">
                                <output id="course-name" name="coursename" for="course-name"><%=subname%></output>

                            </div>
                            <div class="col-md-4">
                                <output id="hours-number" name="numberofhours" for="hours"><%=hours%></output>
                            </div>
                            <div class="col-md-4">
                                <input id="checkbox" checked="true" type="checkbox" name="check" value=<%=cours_num%> >

                            </div>
                            <br>
                            <%

                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            %>



                        </div>
                        <div class="submit-button">
                            <input type="hidden" name="statuse" value="insretChecked" >
                            <input class="submitbtn" type="submit" value="SUBMIT" id="submit" width=60px>
                            
                        </div>
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