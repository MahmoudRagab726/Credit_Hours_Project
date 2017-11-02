
package DB;
import java.sql.*;
public class DBExcution {
    Connection con;
    Statement st;
    ResultSet rs;
    String drivermanager;
    String url;
    String usr,psw;
     String [] data;
    public DBExcution() {
        usr="root";
        psw="admin";
        drivermanager="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/sciencefac";
        
        try{
        Class.forName(drivermanager);
        con=DriverManager.getConnection(url,usr,psw);
        st=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
//    public boolean LoginStatments(String sql){
//        try{
//        rs=st.executeQuery(sql);
//         while(rs.next()){
//               //redirect to user page
//                String s=rs.getString(3);
//                if(s.equals("admin")){
//                    return true;
//                    
//                }else if(s.equals("student")){
//                    
//                    
//                     return  false;
//                    
//                }
//         
//        
//    }
//   
//    
//            }catch(Exception e){
//            
//              return false;
//            
//        }}
    
    public boolean RegisterStatments(String sql1,String sql2,String sql3 ,String userssn) throws SQLException{
        try{
           
        st.executeUpdate(sql1);
        st.executeUpdate(sql2);
        rs=st.executeQuery(sql3);
     
               data=new String[73];
               int x=0;
               System.out.println(">>>>"+userssn);
               while(rs.next()){

                   String dataset=rs.getString(1);
                   data[x]=dataset;
                   x++;
                   //System.out.println(rs.getString("course_num"));
               }
               for (int i = 0; i < data.length; i++) {
                   String sqlstatment3="insert into student_subject values('"+userssn+"','"+data[i]+"','unchecked')";
                   st.executeUpdate(sqlstatment3);
                    
                }
               
               return true;
           
        
        }catch(Exception e){
            
              return false;
            
        }
        
    }
    public boolean rules(String sql){
        try{
            st.executeUpdate(sql);
            return true;
            
        }catch(Exception e){
            return false;
        }
        
     
    }
    
    
    }
