
package techquizapp.pojo;

import java.util.Objects;

public class Answer 
{
    private String examID;
    private String subject;
    private int qno;
    private String chooseAnswer;
    private String correctAnswer;

    public Answer(String examID, String subject, int qno, String chooseAnswer, String correctAnswer) {
        this.examID = examID;
        this.subject = subject;
        this.qno = qno;
        this.chooseAnswer = chooseAnswer;
        this.correctAnswer = correctAnswer;
    }

    
    
    @Override
    public String toString() 
    {
        return "Answer{" + "examID=" + examID + ", subject=" + subject + ", qno=" + qno + ", chooseAnswer=" + chooseAnswer + ", correctAnswer=" + correctAnswer + '}';
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examID, other.examID)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.chooseAnswer, other.chooseAnswer)) {
            return false;
        }
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        return true;
    }

    /**
     * @return the examID
     */
    public String getExamID() {
        return examID;
    }

    /**
     * @param examID the examID to set
     */
    public void setExamID(String examID) {
        this.examID = examID;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the qno
     */
    public int getQno() {
        return qno;
    }

    /**
     * @param qno the qno to set
     */
    public void setQno(int qno) {
        this.qno = qno;
    }

    /**
     * @return the chooseAnswer
     */
    public String getChooseAnswer() {
        return chooseAnswer;
    }

    /**
     * @param chooseAnswer the chooseAnswer to set
     */
    public void setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
    }

    /**
     * @return the correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
