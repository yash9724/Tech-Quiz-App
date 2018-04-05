package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Users;

/**
 *
 * @author Yash                         date:11/01/2018
 */
public class UsersDAO {
    
    public static boolean validateUser(Users user) throws SQLException
    {
         Connection conn = null;
         PreparedStatement ps = null;
        try
        {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("Select * from users where userId = ? and password = ? and lower(usertype) = ?");
        }
        
        catch(NullPointerException e)
        {
            System.exit(0);
        }
        
        
        ps.setString(1,user.getUserID());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType().toLowerCase());
        
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }
    
    public static boolean addNewStudent(Users newStudent) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from users where userid = ?");
        ps.setString(1,newStudent.getUserID());
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        if(rs.next() == false)
        {
            ps = conn.prepareStatement("Insert into users values(?,?,?)");
            ps.setString(1,newStudent.getUserID());
            ps.setString(2,newStudent.getPassword());
            ps.setString(3,newStudent.getUserType());
            ans = ps.executeUpdate();
        }
        
        return ans == 1;
    }
    
    public static boolean changePassword(Users student) throws SQLException
    {
         Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password = ? where userId = ? ");
        ps.setString(2, student.getUserID());
        ps.setString(1, student.getPassword());
        
        int ans = ps.executeUpdate();
        
        return ans==1;
    }
    
}
