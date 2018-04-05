 // author: Yash               date: 11/01/2018


package techquizapp.pojo;


public class Exam 
{
    private String exam;
    private String language;
    private int totalQuestion;

    
    

    public Exam(String exam, String language, int totalQuestion) {
        this.exam = exam;
        this.language = language;
        this.totalQuestion = totalQuestion;
    }
    public String getExamID() {
        return exam;
    }

    /**
     * @param exam the exam to set
     */
    public void setExamID(String exam) {
        this.exam = exam;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the totalQuestion
     */
    public int getTotalQuestions() {
        return totalQuestion;
    }

    /**
     * @param totalQuestion the totalQuestion to set
     */
    public void setTotalQuestions(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }
    
}
