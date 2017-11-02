/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 *
 * @author Mahmoud Ragab
 */
public class NewClass {
  static Connection con;
    static Statement st;
    static ResultSet rs;
   static String drivermanager;
   static String url;
   static String usr,psw;
   static String [] data;
    public NewClass() {
        usr="root";
        psw="admin";
        drivermanager="com.mysql.jdbc.Driver";
        url="jdbc:mys=sql://localhost:3306/sciencefac";
    }
    public static void db() {
        try{
        String sqlstatment="select * from login where ssn='11111111111111' and password='111111111'";

            rs=st.executeQuery(sqlstatment);
            if(rs.next()){
               //redirect to user page
                String s=rs.getString(3);
                if(s.equals("admin")){
                    System.out.println("admin");
                    
                }else if(s.equals("student")){
                    System.out.println("student");
                    
                    
                }
            }
    }catch(Exception ex){
            System.out.println("exception");
}
    }
    
    public static void main(String[] args) throws SQLException  {
        NewClass n=new NewClass();
        n.db();
        
    }
    
}
