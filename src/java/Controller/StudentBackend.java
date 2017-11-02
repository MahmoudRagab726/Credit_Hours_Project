package Controller;

import Model.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentBackend extends HttpServlet {

    String sqlstatment;

    Connection con;
    Statement st;
    ResultSet rs;
    String drivermanager;
    String url;
    String usr, psw;
    String[] data;
    String level;
    String[] uncheckedList = new String[74];
    String[] checkedList = new String[74];
    String[] dependantList = new String[74];
    HashSet<String> viewList = new HashSet<String>();
    String[] copyList;
    int uncheckedCount = 0;
    int checkedCount = 0;
    int dependantCount = 0;
    int viewCount = 0;
    int copyCount = 0;

    public void init() {
        System.out.println("Started ");
        usr = "root";
        psw = "admin";
        drivermanager = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/sciencefac";

        try {
            Class.forName(drivermanager);
            con = DriverManager.getConnection(url, usr, psw);
            st = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String insertcheck = request.getParameter("statuse");
        if (insertcheck.equals("insretChecked")) {
            try {
                HttpSession s = request.getSession();

                Model m = (Model) s.getAttribute("DBObject");
                String ssn = m.getSSN();

                String[] query = new String[73];
                String[] value = new String[73];
                value = request.getParameterValues("check");
                int count = 0;
                for (int i = 0; i < value.length; i++) {
                    String name = value[i];
//                    switch(name){
//                        case "B122":
//                            
//                            
//                            sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"' and course_num='"+name+"'";
//                            query[count]=sqlstatment;
//                            System.out.println(sqlstatment);
//                           
//                            count++;
//                            
//                            break;
//                        case "B311":
//                            
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             System.out.println(sqlstatment);
//                             count++;
//                            break;
//                        case "CH000":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             System.out.println(sqlstatment);
//                             count++;
//                            break;
//                        case "CH111":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             System.out.println(sqlstatment);
//                             count++;
//                            break;
//                        case "CH122":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                            System.out.println(sqlstatment);
//                            count++;
//                            break;
//                        case "CH133":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                            query[count]=sqlstatment;
//                             System.out.println(sqlstatment);
//                             count++;
//                            break;
//                        case "CH134":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                           System.out.println(sqlstatment);
//                           count++;
//                            break;
//                        case "CH145":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             System.out.println(sqlstatment);
//                             count++;
//                            break;
//                        case "CH176":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                         System.out.println(sqlstatment);
//                         count++;
//                            break;
//                        case "CH177":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                            query[count]=sqlstatment;
//                             count++;
//                            break;
//                        
//                        case "G111":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                            query[count]=sqlstatment;
//                           count++;
//                            break;
//                        case "G141":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             count++;
//                            break;
//                        case "M119":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             count++;
//                            break;
//                        case "M2121":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             count++;
//                            break;
//                        case "P111":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                            count++;
//                            break;
//                        case "P189":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                           count++;
//                            break;
//                        case "P4912":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                             count++;
//                            break;
//                        case "Z1110":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"' and course_num='"+name+"'";
//                            query[count]=sqlstatment;
//                             count++;
//                            break;
//                        case "Z125":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                           count++;
//                            break;
//                        case "Z4211":
//                             sqlstatment="update student_subject set status ='checked' where ssn='"+ssn+"'and course_num='"+name+"'";
//                             query[count]=sqlstatment;
//                            count++;
//                            break;
//                      
//                        
//                    }

                }
                for (int z = 0; z < count; z++) {
                    System.out.println(query[z]);
                    st.executeUpdate(query[z]);

                }
                response.sendRedirect("index.jsp");

            } catch (Exception e) {
                response.sendRedirect("courses.jsp");
            }

        } else if (insertcheck.equals("student")) {
            try {
                HttpSession s = request.getSession();
                Model m = (Model) s.getAttribute("DBObject");
                String ssn = m.getSSN();
                String statment = "select * from student where ssn='" + ssn + "'";
                rs = st.executeQuery(statment);

                while (rs.next()) {
                    level = rs.getString("level");

                }
                System.out.println(">>>" + level);
       

                // select all subjects that are unchecked subjects and store them into array  uncheckedlist
                String uncheckedSubjects = "select * from student_subject where status ='unchecked' and ssn ='" + ssn + "'";
                rs = st.executeQuery(uncheckedSubjects);
                
                while (rs.next()) {
                    String subname = rs.getString("course_num");
                    uncheckedList[uncheckedCount] = subname;
                    uncheckedCount++;
                }

                // select all subjects that are checked subjects and store it into array checkedlist
                String checkeSubjects = "select * from student_subject where status ='checked' and ssn ='" + ssn + "'";
                rs = st.executeQuery(checkeSubjects);
                while (rs.next()) {
                    String subname = rs.getString("course_num");
                    checkedList[checkedCount] = subname;
                    checkedCount++;
                }
                
                // get all subjects that have a dependant subject and store in dependantList
                String subjectsWithDependant = "select * from subject where dependant != 'not'";
                rs = st.executeQuery(subjectsWithDependant);
                while (rs.next()) {
                    String subname = rs.getString("dependant");
                    dependantList[dependantCount] = subname;
                    dependantCount++;
                   
                }
                String notDependant = "select * from subject where dependant = 'not'";
                rs = st.executeQuery(notDependant);
               
                while (rs.next()) {
                    String sub = rs.getString("course_num");
                    
                    for (String unchecked : uncheckedList) {
                        if (sub.equals(unchecked)) {
                            viewList.add(unchecked);
                            viewCount++;
                          
                        }
                    }

                }
               

                for (int i = 0; i < dependantCount; i++) {
                    String subjectcode = dependantList[i];
                    String testsubject = "select * from student_subject where course_num = '" + subjectcode + "' and ssn ='" + ssn + "'";
                    rs = st.executeQuery(testsubject);

                    while (rs.next()) {
                        String viewsubject = rs.getString("status");

                    // here you must use .equale(method) to compare between strings 
                        //but don't use == operator
                        if (viewsubject.equals("checked")) {
                            String sq = "select * from subject where dependant = '" + subjectcode + "'";
                            rs = st.executeQuery(sq);
                       //put result set into session
                            // s.setAttribute("rsListView", rs);
                            while (rs.next()) {
                                String ssss = rs.getString("course_num");
                                viewList.add(ssss);
                                viewCount++;
                            }
                        }

                    }

                }
                
                s.setAttribute("DBObject", m);
                // this is the way you can send data structure from servlet to jsp page
                s.setAttribute("propertyList", viewList);
                s.setAttribute("validation", "true");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/courses.jsp");
                requestDispatcher.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                for (int i = 0; i < uncheckedList.length; i++) {
                    uncheckedList[i] = " ";
                }
                for (int i = 0; i < checkedList.length; i++) {
                    checkedList[i] = " ";
                }
                for (int i = 0; i < dependantList.length; i++) {
                    dependantList[i] = " ";

                }
                checkedCount = 0;
                uncheckedCount = 0;
                viewCount = 0;
                dependantCount = 0;
                viewList.clear();

            }

        }

    }
}
