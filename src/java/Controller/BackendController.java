package Controller;

import Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import DB.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BackendController extends HttpServlet {
    Connection con;
    Statement st;
    ResultSet rs;
    String drivermanager;
    String url;
    String usr,psw;
    String [] data;
    @Override
    public void init(){
        usr="root";
        psw="admin";
        drivermanager="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/sciencefac";
     
        try{
        Class.forName(drivermanager);
        con=DriverManager.getConnection(url,usr,psw);
        st=con.createStatement();
        
        
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    String hidden;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         hidden =request.getParameter("status");
        if(hidden.equals("login")){
        try{
            // get parameters from login form and set them into 
            // the model class and put the object in the session 
            HttpSession session=request.getSession();
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            // DB Model Store 
            
            Model m=new Model();
            m.setSSN(username);
            m.setPSW(password);
            session.setAttribute("DBObject", m);
            
            // DB Query
            String sqlstatment="select * from login where ssn = '"+username+"' and password = '"+password+"'";

            rs=st.executeQuery(sqlstatment);
            if(rs.next()){
               //redirect to user page
                String s=rs.getString(3);
                if(s.equals("admin")){
                    response.sendRedirect("register.jsp?valid=valid");
                    
                }else if(s.equals("student")){
                    response.sendRedirect("StudentBackend?statuse=student");
                    
                    
                }
                
            }else{
                response.sendRedirect("Login.jsp?valid=notvalid");
                System.out.println("Error");
            }

        }catch(Exception e){
            try {
                System.out.println(e);
                rs.close();
                st.close();
                con.close();
                response.sendRedirect("Login.jsp?valid=notvalid");
            }
            /// we send a parameter hidden with the form if this parameter is "register" do the following code
            // it also the request come from register.jsp Page
            catch (SQLException ex) {
                System.out.println("ex");
            }
            
        }      
        
        
    }else if(hidden.equals("register")){
        try{
        String  userssn=request.getParameter("acadmic_ID").trim();
        String userName=request.getParameter("username").trim();
        String password=request.getParameter("password").trim();
        String conPassword=request.getParameter("confirm_password");
        if(userName!=null&userssn!=null&password!=null&conPassword!=null){
            if(userName.length()>15 & userssn.length()==14 & password.length()>8&conPassword.length()>8){
                String sqlstatment="insert into student values('"+userssn+"','"+userName+"','chemist','1')";
                String sqlstatment2="insert into login values('"+userssn+"','"+password+"','student')";
                
                
//               st.executeUpdate(sqlstatment);
//               st.executeUpdate(sqlstatment2);
               String sql1="SELECT * FROM subject";
               DBExcution dbe=new DBExcution();
               boolean Flag=dbe.RegisterStatments(sqlstatment, sqlstatment2, sql1,userssn);
                if(Flag==true){
                    response.sendRedirect("register.jsp?valid=valid");
                }else{
                    response.sendRedirect("register.jsp?valid=notvalid");
                }
//               rs=st.executeQuery(sql1);
//                   data=new String[73];
//               int x=0;
//               while(rs.next()){
////               String sqlstatment3="insert into student_subject values('"+userssn+"','"+rs.getString("course_num")+"','unchecked')";
////               int x=st.executeUpdate(sqlstatment3);
////                   System.out.println("????"+x);
//                   String dataset=rs.getString(1);
//                   data[x]=dataset;
//                   x++;
//                   //System.out.println(rs.getString("course_num"));
//               }for (int i = 0; i < data.length; i++) {
//                   String sqlstatment3="insert into student_subject values('"+userssn+"','"+data[i]+"','unchecked')";
//                   st.executeUpdate(sqlstatment3);
//                    
//                }
//               
//               response.sendRedirect("register.jsp?valid=valid");
            }else{
                response.sendRedirect("register.jsp?valid=notvalid");
            }
            
        }else{
            response.sendRedirect("register.jsp?valid=notvalid");
        }
//   
          
    }catch(Exception e){
            e.printStackTrace();
    }
        // admin to determine hours limit function 
        
    }else if(hidden.equals("hours_rules")){
        try{
        String min=(request.getParameter("Minhours").trim());
        String max=(request.getParameter("Maxhours").trim());
        if(min!=null&max!=null){
            int minn=Integer.parseInt(min);
            int maxx=Integer.parseInt(max);
        if(minn!=0&maxx!=0){
            String sql2="select min_hours from houre_rules";
            rs=st.executeQuery(sql2);
            String key=null;
            int key2=0;
            
            
            while(rs.next()){
                key2=Integer.parseInt(key=rs.getString(1));
                System.out.println(key2);
                
            }
            String sql="update houre_rules set min_hours ="+min+",max_hours ="+max+" where min_hours ="+key2+"";
            
                DBExcution db=new DBExcution();
                boolean Flag=db.rules(sql);  
                if(Flag==true){
                    response.sendRedirect("Hours.jsp?valid=valid");
                }
                else{
                       response.sendRedirect("Hours.jsp?valid=notvalid");
                }
            }else{
            response.sendRedirect("Hours.jsp?valid=notvalid");
        }
        }else{
            response.sendRedirect("Hours.jsp?valid=notvalid");
        }
        }catch(Exception e){
            response.sendRedirect("Hours.jsp?validation=notvalid");
        }
    }
    }

}
