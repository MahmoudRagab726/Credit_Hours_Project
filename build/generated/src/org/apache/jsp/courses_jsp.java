package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.apache.el.stream.Stream;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import Model.Model;

public final class courses_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        Connection con;
        Statement st;
        ResultSet rs;
        String drivermanager;
        String url;
        String usr, psw;

        HashSet<String> listview = new HashSet<String>();

    
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <title>courses</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"framework/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"framework/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\">\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Amiri:700italic&subset=arabic,latin' rel='stylesheet' type='text/css'>\r\n");
      out.write("    </head>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

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


        
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <img class=\"img-responsive resize img-circle\" src=\"images/enroll1.png\" alt=\"Enrollment\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <a href=\"index.jsp\">\r\n");
      out.write("                        <li>Home</li>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a href=\"courses.jsp\">\r\n");
      out.write("                        <li class=\"active\">Courses</li>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a >\r\n");
      out.write("\r\n");
      out.write("                        <li id=\"user_name\">");
      out.print(user);
      out.write("</li>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a >\r\n");
      out.write("\r\n");
      out.write("                        <li id=\"login_button\">");
      out.print(user);
      out.write("</li>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"courses\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        subname\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        Number Of Hours\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        Select\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"line\">\r\n");
      out.write("                        <hr width=\"80%\" align=\"center\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <form action=\"StudentBackend\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row\" id=\"course-submit\">\r\n");
      out.write("\r\n");
      out.write("                            ");

                                try {
                                    for (String courseName : listview) {
                                        System.out.println("wlcom : " + courseName);
                                        String showsql = "select * from subject where course_num = '" + courseName + "'";
                                        rs = st.executeQuery(showsql);
                                        while (rs.next()) {
                                            String subname = rs.getString(2);
                                            String hours = rs.getString(4);
                                            String cours_num = rs.getString(1);

                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"col-md-4\">\r\n");
      out.write("                                <output id=\"course-name\" name=\"coursename\" for=\"course-name\">");
      out.print(subname);
      out.write("</output>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-4\">\r\n");
      out.write("                                <output id=\"hours-number\" name=\"numberofhours\" for=\"hours\">");
      out.print(hours);
      out.write("</output>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-4\">\r\n");
      out.write("                                <input id=\"checkbox\" checked=\"true\" type=\"checkbox\" name=\"check\" value=");
      out.print(cours_num);
      out.write(" >\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            ");


                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"submit-button\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"statuse\" value=\"insretChecked\" >\r\n");
      out.write("                            <input class=\"submitbtn\" type=\"submit\" value=\"SUBMIT\" id=\"submit\" width=60px>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("            <small>&copy; Ibrahiem Mohamed , FullStack Web Developer.</small>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("        <script src=\"js/app.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
