
package techquizapp.pojo;

public class Performance 
{
    private String userId;                                           
    private String examID;                                           
    private int right;                                            
    private int wrong;                                             
    private int unattempted;                                       
    private float per;                                             
    private String language;                                           

    public Performance(String examId, String language, String userId, int right, int wrong, int unattempted, double per) 
    {
            this.userId  = userId;                                    
            this.examID = examId;                                           
            this.right = right;                                            
            this.wrong = wrong;                                             
            this.unattempted = unattempted;                                       
            this.per = (float) per;                                             
            this.language = language;                                           

    }

   
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }

      public String getExamID() {
        return examID;
    }

    
    public void setExamID(String examID) {
        this.examID = examID;
    }

   
    public int getRight() {
        return right;
    }

   
    public void setRight(int right) {
        this.right = right;
    }

    
    public int getWrong() {
        return wrong;
    }

   
    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    
    public int getUnattempted() {
        return unattempted;
    }

    
    public void setUnattempted(int unattempted) {
        this.unattempted = unattempted;
    }

    
    public float getPer() {
        return per;
    }

    
    public void setPer(float per) {
        this.per = per;
    }

   
    public String getLanguage() {
        return language;
    }

   
    public void setLanguage(String language) {
        this.language = language;
    }

}
