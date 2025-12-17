/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cms;

import java.sql.*;


/**
 *
 * @author Dell
 */
public class CMS {
    Connection con;
Statement st;
ResultSet rs;



CMS(){

    
    try{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");
st=con.createStatement ();
System.out.println("Db is connected");

}catch(Exception e) {
    System.out.println(e);
}
}
public int rstudents(String id, String fname, String lname, String email, String pno, String pass, String dept){
    
    int status=0;
    
    String sql="INSERT INTO `students` (`st_id`, `st_fname`, `st_lname`, `st_email`, `st_pno`, `st_pass`, `st_dept`)VALUES ('"+id+"','"+fname+"','"+lname+"','"+email+"','"+pno+"','"+pass+"','"+dept+"')";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public ResultSet studentDetails(String id, String pass){

    String sql="select*from students where st_id='"+id+"' AND st_pass='"+pass+"'";
    try{
    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
}
public int rteachers(String id, String fname, String lname, String email, String dept, String pno, String pass){
    
    int status=0;
    
    String sql="INSERT INTO `teachers` (`t_id`, `t_fname`, `t_lname`, `t_email`, `t_dept`, `t_pno`, `t_pass`) VALUES ('"+id+"', '"+fname+"', '"+lname+"', '"+email+"', '"+dept+"', '"+pno+"', '"+pass+"')";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public ResultSet teacherDetails(String id, String pass){

    String sql="select*from teachers where t_id='"+id+"' AND t_pass='"+pass+"'";
    try{

    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
}
public ResultSet studentName(String id){

    String sql="select *from students where st_id='"+id+"'";
    try{
    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
}
public ResultSet teacherName(String id){

    String sql="select *from teachers where t_id='"+id+"'";
    try{
    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
}
public int changePass(String id,String cpass){
    
    int status=0;
    
    String sql="UPDATE `students` SET `st_pass` = '"+cpass+"' WHERE `students`.`st_id` = '"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       CMS db=new CMS();
        login lg=new login();
       lg.setVisible(true);
    }
    
}
