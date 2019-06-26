package processor;

import GUI.PostGame;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Game{
Random rand = new Random();
QandA_Reader qr = new QandA_Reader();
private int seconds;
private ImageIcon gameover = new ImageIcon("image/gameover.jpg");
private ImageIcon check = new ImageIcon("image/check.png");
private int index;
private boolean visible;
private ImageIcon generated_question[];
private String generated_answer[];
private int x;
private int mode;
private int scoreIncrease;
private String Answer;
private String diff;
private int mistake =0;
private int Score =0;
private int totalQ_Answered=0;
    public void setDifficulty(int x,int seconds,String diff) throws FileNotFoundException
    {mode=x;
     this.seconds=seconds;
        if(x==1)
        {
            scoreIncrease=10;
                this.diff=diff;
       qr.easy();
       getQA();
        }
        else if(x==2)
        {
                this.diff=diff;
       scoreIncrease=20;
       qr.medium();
       getQA();
        }
        else if(x==3)
        {    this.diff=diff;
       scoreIncrease=30;
       qr.hard();
       getQA();
        }
    }
    private void getQA() 
    {
     generated_question= qr.getQuestions();
     generated_answer=qr.getAnswers();
     setQA();
    }
    public void setQA()
    {
        int x=0;
                x=rand.nextInt(qr.getQTOTAL());
                this.x=x;
    }
    public ImageIcon game()
    { 
        return generated_question[x];
    }
    public void Checker(String Answer) throws FileNotFoundException
    {   
        this.Answer = Answer;
        if(this.Answer.equals(""))
        {     mistake++;
                     JOptionPane.showMessageDialog(null,"No Answer",
              "Wrong",JOptionPane.ERROR_MESSAGE);
            status(); 
        }
       else if(this.Answer.equalsIgnoreCase(generated_answer[x]))
        {++totalQ_Answered;
            Score+=scoreIncrease;
                     JOptionPane.showMessageDialog(null,"Correct",
              "Correct",JOptionPane.INFORMATION_MESSAGE,check);
            status(); 
        }
        else 
        {
            mistake++;
               JOptionPane.showMessageDialog(null,"Wrong",
              "Wrong",JOptionPane.ERROR_MESSAGE);
            status();
        }
    }
      public void  status() throws FileNotFoundException
        {
            if(mistake<3)
            {
             NextQuestion_Generator();
             visible=true;
            }
            else
            {
                 visible=false;
                 end();
            }
        }
      public void end() throws FileNotFoundException
      {
             JOptionPane.showMessageDialog(null,"",
              "Game Over!",JOptionPane.INFORMATION_MESSAGE,gameover);
          visible=false;
          PostGame pg= new PostGame();
          pg.setIndex(index,diff);
          pg.setmode(mode,seconds);
          pg.setResult(totalQ_Answered,Score, scoreIncrease);
          pg.createPostGame();
          pg.getFrame().setVisible(true);
       totalQ_Answered=0;
       mistake=0;
       Score=0;
      }
      public void NextQuestion_Generator()
      {
          setQA();
      }
      public boolean visible()
      {
          return visible;
      }
      public int getmistake()
      {
          return mistake;
      }
      public int getscore()
      {
          return Score;
      }
      public void setIndex(int x)
      {
          index=x;
      }
}
    
     


