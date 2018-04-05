
package techquizapp.pojo;

import java.util.ArrayList;



public class AnswerStore 
{
   ArrayList <Answer> answerList;

    public AnswerStore()
    {
        answerList = new ArrayList<>();
                
    }
    
    public void addAnswer(Answer answer)
    {
        answerList.add(answer);
    }
    
    public Answer getAnswer(int pos)
    {
        return answerList.get(pos);
    }
    
    public void removeAnswer(int pos)
    {
        answerList.remove(pos);
    }
    
    public void setAnswer(int pos,Answer answer)
    {
        answerList.set(pos, answer);
        
    }
    
    public ArrayList<Answer> getAllAnswers()
    {
        return answerList;
    }
    
    public int getCount()
    {
        return answerList.size();
    }
    
    public Answer getAnswerByQno(int qno)
    {
        for(Answer ans: answerList)
        {
            if(ans.getQno() == qno )
                return ans;
        }
        
        return null;
    }
    
    public int removeAnswer(Answer answer)
    {
        //for(Answer ans : answerList)
        //{
            int pos = answerList.indexOf(answer);
            answerList.remove(pos);
            return pos;
        //}    
    }
}
