package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    \r\n");
      out.write("    <head>\r\n");
      out.write("        <title>About</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"framework/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"framework/bootstrap.min.css\">\r\n");
      out.write("                <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <img class=\"img-responsive resize img-circle\" src=\"images/enroll1.png\" alt=\"Enrollment\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <a href=\"index.jsp\">\r\n");
      out.write("                    <li>Home</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                    <!-- remove register button from header\r\n");
      out.write("                   <a href=\"register.jsp\">\r\n");
      out.write("                    <li>Register</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                    -->\r\n");
      out.write("                    <a href=\"about.jsp\">\r\n");
      out.write("                    <li class=\"active\">About</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                    <a href=\"Login.jsp\">\r\n");
      out.write("                    <li id=\"login_button\">Login</li>\r\n");
      out.write("                </a>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"team-info \">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        \r\n");
      out.write("                        <img class=\"img-responsive img-circle profile-image center-block\" src=\"images/ibrahiem.jpg\" alt=\"ibrahiem mohamed\">\r\n");
      out.write("                        <small>Ibrahiem Mohamed</small>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <small>\"FullStack Web Developer\"</small>\r\n");
      out.write("                        <a href=\"https://www.facebook.com/ibmedo22\" target=\"_blank\"><img class=\"img-responsive center-block    contact-image \"  src=\"images/facebook-wrap.png\" alt=\"Facebook Url\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("<!--                        <img class=\"img-responsive img-circle profile-image center-block\" src=\"images/nahas.jpg\" alt=\"ibrahiem                     mohamed\">\r\n");
      out.write("                        <small>Mohamed Elnahas</small>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <small>\"backend Web Developer\"</small>\r\n");
      out.write("                        <a href=\"https://www.facebook.com/mohamed.nahas.3\" target=\"_blank\"><img class=\"img-responsive center-block contact-image \"  src=\"images/facebook-wrap.png\" alt=\"Facebook Url\"></a>-->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <img class=\"img-responsive img-circle profile-image center-block\" src=\"images/mahmoud.jpg\" alt=\"ibrahiem                     mohamed\">\r\n");
      out.write("                        <small>Mahmoud Ragab</small>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <small>\"Backend Web Developer\"</small>\r\n");
      out.write("                        <a href=\"https://www.linkedin.com/profile/view?id=345492820&trk=nav_responsive_tab_profile\" target=\"_blank\"><img class=\"img-responsive center-block contact-image \"  src=\"images/facebook-wrap.png\" alt=\"Facebook Url\"></a>\r\n");
      out.write("                    </div>\r\n");
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
