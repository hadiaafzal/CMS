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
//INSERT INTO studentsapplications SELECT * FROM students;
public int studentsAppPass(String id){
    
    int status=0;
    
    String sql1="INSERT INTO students SELECT * FROM studentsapplications where st_id='"+id+"' ;";
    String sql2="DELETE FROM studentsapplications where st_id='"+id+"'";
    try{
    st.executeUpdate(sql1);
    st.executeUpdate(sql2);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public int studentsAppReject(String id){
    
    int status=0;
    
    String sql="DELETE FROM studentsapplications where st_id='"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}

public int teachersAppPass(String id){
    
    int status=0;
    
    String sql1="INSERT INTO teachers SELECT * FROM teachersapplications where t_id='"+id+"' ;";
    String sql2="DELETE FROM teachersapplications where t_id='"+id+"'";
    try{
    st.executeUpdate(sql1);
    st.executeUpdate(sql2);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public int teachersAppReject(String id){
    
    int status=0;
    
    String sql="DELETE FROM teachersapplications where t_id='"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public int studentsApp(String id, String fname, String lname, String email, String pno, String pass, String dept){
    
    int status=0;
    
    String sql="INSERT INTO `studentsapplications` (`st_id`, `st_fname`, `st_lname`, `st_email`, `st_pno`, `st_pass`, `st_dept`)VALUES ('"+id+"','"+fname+"','"+lname+"','"+email+"','"+pno+"','"+pass+"','"+dept+"')";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public ResultSet studentAppDetails(){

    String sql="select*from studentsapplications";
    try{
    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
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
public int teachersApp(String id, String fname, String lname, String email, String pno, String pass, String dept){
    
    int status=0;
    
    String sql="INSERT INTO `teachersapplications` (`t_id`, `t_fname`, `t_lname`, `t_email`, `t_pno`, `t_pass`, `t_dept`)VALUES ('"+id+"','"+fname+"','"+lname+"','"+email+"','"+pno+"','"+pass+"','"+dept+"')";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public ResultSet teacherAppDetails(){

    String sql="select*from teachersapplications";
    try{
    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
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
/**/
public ResultSet adminDetails(String id, String pass){

    String sql="select*from admins where a_id='"+id+"' AND a_pass='"+pass+"'";
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

                    
public ResultSet AdminName(String id){

    String sql="select *from admins where a_id='"+id+"'";
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
public int stdChangePass(String id,String cpass){
    
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
                 
public int AdPass(String id,String cpass){
    
    int status=0;
    
    String sql="UPDATE `admins` SET `a_pass` = '"+cpass+"' WHERE `admins`.`a_id` = '"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}




public int teaChangePass(String id,String cpass){
    
    int status=0;
    
    String sql="UPDATE `teachers` SET `t_pass` = '"+cpass+"' WHERE `teachers`.`t_id` = '"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}


public ResultSet announcement(String id){
    
String sql = "SELECT `announcement` from `announcements` WHERE `announcements`.`t_id` = '"+id+"'";  
try{

    rs=st.executeQuery(sql);
    }catch(Exception e){
    System.out.print(e);
    }
    return rs;
}
                       /**/
public int makeAnnouncement(String id,String announcement,String fullname){
 int status=0;
    
String sql = "INSERT INTO `announcements` (`t_id`, `announcement`,`t_fullname`) VALUES ('" + id + "', '" + announcement + "', '" + fullname + "'   )";  
try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;
}



public int stdChangeDetails(String id,String email,String pno){
    
    int status=0;
    
    String sql="UPDATE `students` SET `st_email` = '"+email+"', `st_pno` = '"+pno+"' WHERE `students`.`st_id` = '"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public int teaChangeDetails(String id,String email,String pno){
    
    int status=0;
    
    String sql="UPDATE `teachers` SET `t_email` = '"+email+"', `t_pno` = '"+pno+"' WHERE `teachers`.`t_id` = '"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public int AdChangeDetails(String id,String email,String pno){
    
    int status=0;
    
    String sql="UPDATE `admins` SET `a_email` = '"+email+"', `a_pno` = '"+pno+"' WHERE `admins`.`a_id` = '"+id+"'";
    try{
    st.executeUpdate(sql);
    status =1;
    }catch(Exception e){
    System.out.println(e);
    }
    return status;

}
public ResultSet AllTeachers() {
    String sql = "SELECT * FROM teachers";
    try {
        Statement stLocal = con.createStatement();
        return stLocal.executeQuery(sql);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

public ResultSet AllSubject() {
    String sql = "SELECT * FROM subject";
    try {
        Statement stLocal = con.createStatement();
        return stLocal.executeQuery(sql);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
public int assignSub(String subName,String tid,String day,String time,String sclass){
    
    int status=0;
    
    String sql1="UPDATE `assignedsubject` SET `t_id` = '"+tid+"', `sub_day` = '"+day+"', `sub_time` = '"+time+"', `sub_class` = '"+sclass+"' WHERE `assignedsubject`.`sub_name` = '"+subName+"'";
    String sql2="DELETE FROM subject where sub_name='"+subName+"'";
    try{
    st.executeUpdate(sql1);
    st.executeUpdate(sql2);
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
