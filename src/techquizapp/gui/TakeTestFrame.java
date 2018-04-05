
package techquizapp.gui;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDAO;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Questions;
import techquizapp.pojo.QuestionsStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author user
 */
public class TakeTestFrame extends javax.swing.JFrame {

    private Exam exam;                            // error
    private QuestionsStore qStore;
    private AnswerStore aStore;
    //private String correctAnswer;
    private int pos ,qno;
    
    public TakeTestFrame() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUserName.setText("Hello "+UserProfile.getUserName());
        qStore = new QuestionsStore();
        aStore = new AnswerStore();
    }
    
    TakeTestFrame(Exam exam) 
    {
       this();
       this.exam = exam;
       lblTitle.setText(exam.getLanguage().toUpperCase() + " PAPER ");
       pos = 0;
       qno = pos + 1;
       lblQues.setText("Question no. "+ qno);
       loadQuestions();
       showQuestion();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQues = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQues = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        lblLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));

        lblUserName.setBackground(new java.awt.Color(0, 0, 0));
        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 102, 0));

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 102, 0));

        lblQues.setBackground(new java.awt.Color(0, 0, 0));
        lblQues.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQues.setForeground(new java.awt.Color(255, 102, 0));

        txtQues.setColumns(20);
        txtQues.setRows(5);
        jScrollPane1.setViewportView(txtQues);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techquizapp/gui/images/good luck2.jpg"))); // NOI18N

        jrbOption1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption1);
        jrbOption1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption1.setForeground(new java.awt.Color(255, 102, 0));

        jrbOption2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption2);
        jrbOption2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption2.setForeground(new java.awt.Color(255, 102, 0));
        jrbOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOption2ActionPerformed(evt);
            }
        });

        jrbOption3.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption3);
        jrbOption3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption3.setForeground(new java.awt.Color(255, 102, 0));

        jrbOption4.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption4);
        jrbOption4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOption4.setForeground(new java.awt.Color(255, 102, 0));
        jrbOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOption4ActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 102, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 102, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 102, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 102, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblLogout.setBackground(new java.awt.Color(0, 0, 0));
        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 102, 0));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQues, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbOption1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jrbOption3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbOption2)
                    .addComponent(jrbOption4))
                .addGap(115, 115, 115))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnPrevious)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancel)
                        .addGap(53, 53, 53)
                        .addComponent(btnDone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jrbOption1, jrbOption2, jrbOption3, jrbOption4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnDone, btnNext, btnPrevious});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQues, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption1)
                    .addComponent(jrbOption2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption3)
                    .addComponent(jrbOption4))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnCancel)
                    .addComponent(btnDone))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOption4ActionPerformed
       
    }//GEN-LAST:event_jrbOption4ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
      
       String chosenAnswer = chosenAnswerByUser();
       if(chosenAnswer != null)
       {
           Questions question = qStore.getQuestion(pos);
           String correctAnswer = question.getCorrectAnswer();
           Answer newAnswer = new Answer(exam.getExamID(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
           System.out.println(newAnswer);
           
           Answer answer = aStore.getAnswerByQno(qno);
           if(answer == null)
           {
               aStore.addAnswer(newAnswer);
           }
           else
           {
               if(newAnswer.getChooseAnswer().equals(answer.getChooseAnswer()) == false)
               {
                   int apos = aStore.removeAnswer(answer);
                   aStore.setAnswer(apos,newAnswer);
               }
           }
       }
       
       else
       {
           Answer newAnswer = null;
       }
       
       pos++;
       if(pos >= qStore.getCount())
       {
           pos = 0;
       }
       
       qno++;
       if( qno > qStore.getCount())
       {    
           qno = 1;
       }
       
       lblQues.setText("Question no. "+qno);
       showQuestion();
        
        
        
        
        //MY CODE------------------------------------------------------
        /* if(pos < qStore.getCount())
        {
            
            //here we need code to replace answer in case user changes answer by using previous button 
            String chosenAnswer = chosenAnswerByUser();
            Answer answer =new Answer(exam.getExamID(), exam.getLanguage(), qno, chosenAnswer,correctAnswer);
            aStore.addAnswer(answer);
            pos++;
        }
        
        //Checking if questions are left----------------------------------------------------------
        if(pos >= qStore.getCount())
        {
            JOptionPane.showMessageDialog(null,"All questions completed\nPress DONE to submit","No More Questions",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
        //if  questions are left then show next question on screen---------------------------------------------------------
        qno = pos + 1;
        lblQues.setText("Question no. "+ qno);
        showQuestion();*/
    }//GEN-LAST:event_btnNextActionPerformed

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        Font f = new Font("Tahoma", Font.BOLD,18);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
          Font f = new Font("Tahoma", Font.BOLD,13);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
       LoginScreenFrame loginScreen = new LoginScreenFrame();
       loginScreen.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void jrbOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbOption2ActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        PaperSelectionFrame selectPaper = new PaperSelectionFrame();
        selectPaper.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        // Testing code
      /*  ArrayList <Answer> answerList =  aStore.getAllAnswers();
        for( Answer ans: answerList)
        {
            System.out.println(ans.getQno() + ":  " + ans.getChooseAnswer() + "  pos: " + pos); 
        }
       */
      
      // code to store last question if user presses done before next
      
      int right = 0 , wrong = 0,unattempted = 0;
      
      for( Questions question : qStore.getAllQuestions())
      {
          int qno = question.getQuesNo();
          Answer answer = aStore.getAnswerByQno(qno);
          if(answer == null)
          {
               unattempted++;
               continue;
          }
          else
          {
              String chosenAnswer = answer.getChooseAnswer();
              String correctAnswer = answer.getCorrectAnswer();
              if(chosenAnswer.equals(correctAnswer))
                  ++right;
              else
                  wrong++;
              
          }
      }  
          
      String reportCard = String.format("Result%nRight: %d%nWrong: %d%nUnattempted: %d",right,wrong,unattempted);  
      JOptionPane.showMessageDialog(null,reportCard,"Result",JOptionPane.INFORMATION_MESSAGE);
      
      float percentage = (float)right/exam.getTotalQuestions() * 100;
      Performance performance = new Performance(exam.getExamID(), exam.getLanguage(), UserProfile.getUserName(), right, wrong,unattempted, percentage); 
      try
      {
          boolean res = PerformanceDAO.addPerformance(performance);
          if(res)
              
          {
              JOptionPane.showMessageDialog(null,"Result added to database","Added!!",JOptionPane.INFORMATION_MESSAGE);
              PaperSelectionFrame selectPaper = new PaperSelectionFrame();
              selectPaper.setVisible(true);
              this.dispose();
          }
          else
              JOptionPane.showMessageDialog(null,"Result could not be added to database","Error!!",JOptionPane.ERROR_MESSAGE);
      } 
      catch (SQLException ex) 
      {
             JOptionPane.showMessageDialog(null,"SQL Error","Error!!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
      }
        
        
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
      
       String chosenAnswer = chosenAnswerByUser();
       if(chosenAnswer != null)
       {
           Questions question = qStore.getQuestion(pos);
           String correctAnswer = question.getCorrectAnswer();
           Answer newAnswer = new Answer(exam.getExamID(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
           System.out.println(newAnswer);
           
           Answer answer = aStore.getAnswerByQno(qno);
           if(answer == null)
           {
               aStore.addAnswer(newAnswer);
           }
           else
           {
               if(newAnswer.getChooseAnswer().equals(answer.getChooseAnswer()) == false)
               {
                   int apos = aStore.removeAnswer(answer);
                   aStore.setAnswer(apos,newAnswer);
               }
           }
       }
       
       
       pos--;
       if(pos < 0)
       {
           pos = qStore.getCount() - 1;
       }
       qno--;
       if(qno <= 0)
           qno = qStore.getCount();
       lblQues.setText("Question no. "+qno);
       showQuestion();
       

       
       //----MY CODE--------------------------- 
       /*if(pos == 0)
           return;
       pos--;
       
       System.out.println("pos: " + pos);
       qno = pos + 1;
       lblQues.setText("Question no: " + qno);
       showQuestion();*/
       
    }//GEN-LAST:event_btnPreviousActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQues;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextArea txtQues;
    // End of variables declaration//GEN-END:variables

    private void loadQuestions()
    {
        try
        {
            ArrayList<Questions> questionList = QuestionDAO.getQuestionByExam(exam.getExamID());
            for(Questions ques: questionList)
            {
                qStore.addQuestion(ques);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"SQL Error","Error!!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    
    private void showQuestion()
    {
        Questions question = qStore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQues.setText(question.getQuestion());
        jrbOption1.setText(question.getAnswer1());
        jrbOption2.setText(question.getAnswer2());
        jrbOption3.setText(question.getAnswer3());
        jrbOption4.setText(question.getAnswer4());
        //correctAnswer = question.getCorrectAnswer();
        
        Answer answer = aStore.getAnswerByQno(question.getQuesNo());
        if(answer == null)
        {
            return;
        }
        
        String chosenAnswer = answer.getChooseAnswer();
        switch(chosenAnswer)
        {
            case "Answer1":      jrbOption1.setSelected(true);
                                 break;
            case "Answer2":      jrbOption2.setSelected(true);
                                 break;
            case "Answer3":      jrbOption3.setSelected(true);
                                 break;
            case "Answer4":      jrbOption4.setSelected(true);
        }
        
    }
        
        private String chosenAnswerByUser()
        {
            if(jrbOption1.isSelected())
                return "Answer1"; 
            else if(jrbOption2.isSelected())
                return "Answer2"; 
            else if(jrbOption3.isSelected())
                return "Answer3"; 
            else if(jrbOption4.isSelected())
                return "Answer4"; 
            else 
                return null; 
        }
    
    
   
    // used for debugging
    /*private void testMethod()
    {
        try
        {
            System.out.println("ExamID: "+exam.getExamID() +"\nLanguage: "+exam.getLanguage()+"\nnoOfQuestion: "+exam.getTotalQuestions());
        }
        catch(NullPointerException e)
        {
            System.out.println("In testMethod");
        }
    }
    */

}
