
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Questions;
import techquizapp.pojo.QuestionsStore;


public class QuestionDAO {

public static void addQuestions(QuestionsStore qStore) throws SQLException
{
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
    
    ArrayList<Questions> questionList = qStore.getAllQuestions();
    
    for(Questions q : questionList)
    {
        ps.setString(1,q.getExamID());
        ps.setInt(2, q.getQuesNo());
        ps.setString(3, q.getQuestion());
        ps.setString(4, q.getAnswer1());
        ps.setString(5, q.getAnswer2());
        ps.setString(6, q.getAnswer3());
        ps.setString(7, q.getAnswer4());
        ps.setString(8, q.getCorrectAnswer());
        ps.setString(9, q.getLanguage());
        
        
        ps.executeUpdate();
        
    }
}

public static ArrayList<Questions> getQuestionByExam(String examID) throws SQLException
{
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("Select * from questions where examid = ? order by qno");
    ps.setString(1, examID); 
    ArrayList<Questions> questionList = new ArrayList<>();
    
    ResultSet rs = ps.executeQuery();
    
    while(rs.next())
    {
     
        String question = rs.getString("question");
        String language = rs.getString("language");
        String answer1 = rs.getString("answer1");
        String answer2 = rs.getString("answer2");
        String answer3 = rs.getString("answer3");
        String answer4 = rs.getString("answer4");
        String correctAnswer = rs.getString("correct_Answer");
        int quesNo = rs.getInt("qno");
        
         Questions ques = new Questions(examID, question, language,answer1, answer2, answer3, answer4, correctAnswer, quesNo);
         
         questionList.add(ques);
    
    }
    
    return questionList;
}

public static void updateQuestions( QuestionsStore qStore ) throws SQLException
{
    Connection conn = DBConnection.getConnection();
    String str ="Update questions set  question = ?, answer1 = ?, answer2 = ?, answer3 = ? , answer4 = ?,correct_answer = ? , language = ?  where qno = ? and examid = ?";
    PreparedStatement ps = conn.prepareStatement(str);
    
    ArrayList<Questions> questionList = qStore.getAllQuestions();
    
    
     for(Questions q : questionList)
    {
        ps.setString(9,q.getExamID());
        ps.setInt(8, q.getQuesNo());
        ps.setString(1, q.getQuestion());
        ps.setString(2, q.getAnswer1());
        ps.setString(3, q.getAnswer2());
        ps.setString(4, q.getAnswer3());
        ps.setString(5, q.getAnswer4());
        ps.setString(6, q.getCorrectAnswer());
        ps.setString(7, q.getLanguage());
        
        
        ps.executeUpdate();
        
    }
}
   
}

