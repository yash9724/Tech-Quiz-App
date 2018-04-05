
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Exam;


public class ExamDAO 
{
    public static String getExamID() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        int rowCount = 0;
        ResultSet rs = st.executeQuery("select count(*) as totalrows from exam");
        if(rs.next())
        {
            rowCount = rs.getInt(1);
        }
        
        String newID = "EX-" + (rowCount + 1);
        
        return newID;
               
    }
    
    public static boolean addExam(Exam newExam) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into Exam values(?,?,?)");
        ps.setString(1, newExam.getExamID());
        ps.setString(2,newExam.getLanguage());
        ps.setInt(3,newExam.getTotalQuestions());
        
        int ans = ps.executeUpdate();
        
        return ans == 1;
    }
    
    public static ArrayList<String> getExamIdBySubject( String subject ) throws SQLException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("Select * from exam where lower(language) = ?");
        }
        
        catch(NullPointerException e)
        {
            System.exit(0);
        }
        
        ps.setString(1, subject.toLowerCase());
        ResultSet rs = ps.executeQuery();
        ArrayList<String> idList = new ArrayList<>();
        while(rs.next())
        {
            idList.add(rs.getString("exam"));
        }
          
        return idList;
    }
    
    
    public static int getQuestionCountByExam(String examID) throws SQLException
    {
        
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("Select total_question from Exam where exam = ?");
        }
        
        catch(NullPointerException e)
        {
            System.exit(0);
        }
        
        
        ps.setString(1, examID);
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        return rs.getInt("total_question");
        
    }
    

   
}
