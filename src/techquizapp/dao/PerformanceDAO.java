
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;


public class PerformanceDAO 
{
    public static ArrayList<String> getAllStudentId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        String query = "Select distinct userid from performance";
        ArrayList<String> studentIdList = new ArrayList<>();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
            String id = rs.getString(1);
            studentIdList.add(id);
        }
        
        return studentIdList;
        
    }
    
   
    public static ArrayList<String> getAllExamId(String userId) throws SQLException
   {
        Connection conn = DBConnection.getConnection();
        String query = "Select distinct examid from performance where userId = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ArrayList<String> examIdList = new ArrayList<>();
        ps.setString(1,userId);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            String id = rs.getString("examid");
            examIdList.add(id);
        }
        
        return examIdList;
   }
   
   
   
    public static StudentScore getStudentScore(String studentId,String examid) throws SQLException
   {
       Connection conn= DBConnection.getConnection();
       String query = "Select per , language from performance where userid = ? and examid = ?";
       PreparedStatement ps = conn.prepareStatement(query);
       ps.setString(1, studentId);
       ps.setString(2,examid);
       ResultSet rs = ps.executeQuery();
       rs.next();
       
       StudentScore scoreObj = new StudentScore();
       scoreObj.setLanguage(rs.getString(2));
       scoreObj.setPer(rs.getFloat(1));
       
       return scoreObj;
       
   
   }
   
   public static ArrayList<Performance> getAllData() throws SQLException
   {
       String query = "Select * from performance";
       ArrayList<Performance> performanceList = new ArrayList<>(); 
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       
       ResultSet rs = st.executeQuery(query);
       
       while(rs.next())
       {
           String userId = rs.getString("userid");
           String examId = rs.getString("examid");
           String language = rs.getString("language");
           int right = rs.getInt("right");
           int wrong = rs.getInt("wrong");
           int unattempted = rs.getInt("unattempted");
           double per = rs.getDouble("per");
           
           
           Performance p = new Performance(examId, language, userId,right , wrong ,unattempted, per);
           
           performanceList.add(p);
           
           
       }
       
       return performanceList;
   }
   
   public static boolean addPerformance(Performance performance) throws SQLException
   {
       Connection conn = DBConnection.getConnection();
       
       String query = "Insert into Performance values(?,?,?,?,?,?,?)";
       PreparedStatement ps = conn.prepareStatement(query);
       
       ps.setString(1,performance.getUserId());
       ps.setString(2, performance.getExamID());
       ps.setInt(3,performance.getRight());
       ps.setInt(4, performance.getWrong());
       ps.setInt(5, performance.getUnattempted());
       ps.setDouble(6,performance.getPer());
       ps.setString(7, performance.getLanguage());
       
       int ans = ps.executeUpdate();
       
       return ans == 1;
       
       
   }
           
}
