package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.ArrayList;

public final class Student_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String data[][];
 HashSet karSet = new HashSet(); 
 HashSet karSet1 = new HashSet(); 
 HashSet karSet2 = new HashSet(); 
  String[] checkedIds  ={""}; 
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
      response.setContentType("text/html;charset=utf-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    \r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Home</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"framework/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"framework/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <img class=\"img-responsive resize img-circle\" src=\"images/enroll1.png\" alt=\"Enrollment\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <a href=\"index.jsp\">\r\n");
      out.write("                    <li class=\"active\">Home</li>\r\n");
      out.write("                    \r\n");
      out.write("                    <!-- remove register button from header \r\n");
      out.write("                </a>\r\n");
      out.write("                    <a href=\"register.jsp\">\r\n");
      out.write("                    <li>Register</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                    -->\r\n");
      out.write("                    <a href=\"about.jsp\">\r\n");
      out.write("                    <li>About</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                <a href=\"Login.jsp\">\r\n");
      out.write("                <li id=\"login_button\">Login</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"info\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
 data = new String[100][4];  
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("         \r\n");


try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sciencefac","root","ROOT");  
PreparedStatement ps=con.prepareStatement("select * from subject ");
//ps.setString(1,n);
out.print("<br>");
ResultSet rs=ps.executeQuery();

out.print("Non-Dependant Courses");
out.print("<table border='5' cellspacing=5 cellpadding=2 id='myTable'>");
out.print("<tr><td><a href='#' name='ID' onmouseover='javascript:viewAllInfo(this.name)'><B>ID</B></a></td><td><B>Name</B></td><td><B>Hours</B></td></tr>");
int i=0;

while(rs.next()){
  if(rs.getString(3).equals(""))
{
out.print("<tr><td><a href='#' name='"+rs.getString(1)+"' onmouseover='javascript:viewAll(this.name)'>"+rs.getString(1)+"</a></td>");
out.print("<td>"+rs.getString(2)+"</td>");
out.print("<td>"+rs.getString(4)+"</td>");


        

 out.print("</tr>");
}
 
  if(!rs.getString(3).equals(""))
{
    
data[i][3] = rs.getString(3);

}
  checkedIds= request.getParameterValues("checkbox");
i++;
 
 
}
out.print("</table>");


con.close();

}catch(Exception e){e.printStackTrace();}



      out.write('\r');
      out.write('\n');


    try{
   
 Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sciencefac","root","ROOT");  

for(int xx =0; xx<100 ; xx++)  { 
    
PreparedStatement ps1=con.prepareStatement("select * from subject  where course_num like '" + data[xx][3] + "%' group by course_num ");
//ps.setString(1,n);
int i=0 ;
ResultSet rs1=ps1.executeQuery();
while(rs1.next()){
  if(!rs1.getString(3).equals("")){
karSet.add(rs1.getString(1));
karSet1.add(rs1.getString(2));
karSet2.add(rs1.getString(4));
// Creating an Array
     
}
}
   } 

con.close();
}catch(Exception e){e.printStackTrace();}  


      out.write('\r');
      out.write('\n');
 
    out.print("Dependant Courses");
    out.print("<table border='5' cellspacing=5 cellpadding=2 id='myTable'>");
    out.print("<tr><td><a href='#' name='ID' onmouseover='javascript:viewAllInfo(this.name)'><B>ID</B></a></td><td><B>Name</B></td><td><B>Hours</B></td></tr>");
    String[] array = new String[karSet.size()];
    String[] array1 = new String[karSet1.size()];
    String[] array2 = new String[karSet2.size()];
     karSet.toArray(array);
     karSet1.toArray(array1);
     karSet2.toArray(array2);
     
         for(int ii=0;ii<15;ii++){
               out.print("<tr><td><a href='#' name='"+array[ii]+"' onmouseover='javascript:viewAll(this.name)'>"+array[ii]+"</a></td>");
               out.print("<td>"+array1[ii]+"</td>");
          //     out.print("<td>"+ array2[ii]+"</td>");
               out.print("</tr>");
    
     }
    out.print("</table>");

      out.write("\r\n");
      out.write("<p>Please choose only 5 Courses in the term </p>\r\n");
      out.write("<p>Please insert only the one  course number in each field</p>\r\n");
      out.write("<form action=\"BackendController\" method=\"post\" >\r\n");
      out.write("1st subject:<br>\r\n");
      out.write("<input type=\"text\" name=\"1st\">\r\n");
      out.write("<br>\r\n");
      out.write("2nd subject:<br>\r\n");
      out.write("<input type=\"text\" name=\"2nd\">\r\n");
      out.write("3th subject:<br>\r\n");
      out.write("<input type=\"text\" name=\"3th\">\r\n");
      out.write("<br>\r\n");
      out.write("4rd subject:<br>\r\n");
      out.write("<input type=\"text\" name=\"4rd\">\r\n");
      out.write("5th subject:<br>\r\n");
      out.write("<input type=\"text\" name=\"5th\">\r\n");
      out.write("<br>\r\n");
      out.write("<input type=\"hidden\" value=\"submit\" name=\"status\">\r\n");
      out.write("<input type=\"submit\" value=\"subject\" id=\"submit\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("            <small>&copy; Ibrahiem Mohamed , FullStack Web Developer.</small>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("        <script src=\"js/app.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <td><html:link action=\"deletedefect\" >Delete\r\n");
      out.write("    <html:param name=\"DefID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myCollection.defectId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />   \r\n");
      out.write("</html:link></td>   \r\n");
      out.write(" \r\n");
      out.write("<td><html:link action=\"updatedefect\" >Update\r\n");
      out.write("    <html:param name=\"DefID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myCollection.defectId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />   \r\n");
      out.write("</html:link></td> \r\n");
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
