
package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import log.in.CriticalDataReader;

public class PostGame extends JPanel{
   private int seconds;
   private String[] scores;
     CriticalDataReader cdr = new CriticalDataReader();
     private ImageIcon img = new ImageIcon("image/asd.jpg");
    private String finalscore;
    private String diff;
    private int mode;
    private int index;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JFrame postgame = new JFrame("Mathemagical");
    private JButton retry =new JButton("Retry");
    private JButton rmm = new JButton("Main Menu");
    private JLabel title = new JLabel("Post Game");
    private JLabel totalqtxt = new JLabel("Total Correct Answers :");
        private JLabel ppqtxt = new JLabel("Points Per Questions :");

    private JLabel  Fstxt= new JLabel("Final Score :");
     private JLabel Fscore = new JLabel();
    private JLabel totalq = new JLabel();
    private JLabel ppq = new JLabel();
    
         public void paintComponent(Graphics g){
   Image image;
        try {
            image = ImageIO.read(new File("image/post game.jpg"));
             super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this);
        }
        } catch (IOException ex) {
          
        }
       
    }
  public void createPostGame()
  {
title.setFont(new Font("Kristen ITC", Font.ROMAN_BASELINE, 30)); 
title.setForeground(Color.ORANGE);
 
    totalqtxt.setFont(new Font("Kristen ITC", Font.BOLD, 25)); 
    totalqtxt.setForeground(Color.WHITE);
  
    ppqtxt.setFont(new Font("Kristen ITC", Font.BOLD, 25)); 
    ppqtxt.setForeground(Color.WHITE);
  
     Fstxt.setFont(new Font("Kristen ITC", Font.BOLD, 25)); 
     Fstxt.setForeground(Color.WHITE);
     
     Fscore.setFont(new Font("Kristen ITC",  Font.ROMAN_BASELINE, 25)); 
     Fscore.setForeground(Color.GREEN);
     
     totalq.setFont(new Font("Kristen ITC",  Font.ROMAN_BASELINE, 25)); 
     totalq.setForeground(Color.GREEN);
     
     ppq.setFont(new Font("Kristen ITC",  Font.ROMAN_BASELINE, 25)); 
     ppq.setForeground(Color.GREEN);
     
      rmm.setFont(new Font("Cooper Black",  Font.ROMAN_BASELINE, 20)); 
      rmm.setForeground(Color.WHITE);
      rmm.setBackground(Color.red);
     
      retry.setFont(new Font("Cooper Black",  Font.ROMAN_BASELINE, 20)); 
      retry.setForeground(Color.WHITE);
      retry.setBackground(Color.red);
 
     
    
   postgame.setIconImage(img.getImage());
   postgame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   postgame.setSize(600,400); 
   postgame.setLocation(screenSize.width/2,screenSize.height/2);
   postgame.setLocationRelativeTo(null);
   postgame.setResizable(false);

   postgame.add(this);
   this.setLayout(null);
 this.add(title);
   this.add(totalqtxt);
   this.add(Fstxt);
   this.add(ppqtxt);
  this.add(Fscore);
   this.add(totalq);
   this.add(ppq);
   this.add(retry);
   this.add(rmm);
   title.setBounds(230,0,300,30);
  totalqtxt.setBounds(100,70,400,30);
   Fscore.setBounds(440,70,160,30);
  Fstxt.setBounds(100,210,400,30);
   totalq.setBounds(280,210,160,30);
  ppqtxt.setBounds(100,140,400,30);
   ppq.setBounds(420,140,160,30);
   retry.setBounds(90,280,120,20);
   rmm.setBounds(280,280,250,20);
   
   retryIsPressed();
   srToMain();
  }
  public void setmode(int x,int seconds)
  {  this.seconds = seconds;
      mode=x;
  }
  public void retryIsPressed()
  {
       retry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               
                try {
                    GameProper gp= new GameProper();
                    gp.setMode(mode,seconds,diff);
                    gp.setIndex(index);
                    postgame.dispose();
                     gp.createGameProper();
                    gp.getFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                 ex.printStackTrace();
                }    
            }
        });
  }
  private void srToMain()
  { MainMenu mm = new MainMenu();
       rmm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                          cdr.userText();
                    updatescore(finalscore); 
       mm.setMyscore("Easy : "+cdr.getScore_easy()[index],"Medium : "+cdr.getScore_medium()[index],"Hard : "+cdr.getScore_hard()[index]);              
       cdr.userText();
       if(cdr.getTopScore_easy()==0)
       mm.setTopScorer_easy("Easy : No Top Scorer Yet");
       else
       mm.setTopScorer_easy("<html>Easy : "+cdr.getTopScorer_easy()+"<br>"+" Score: "+cdr.getTopScore_easy()+"</html>");
       cdr.userText();
       if(cdr.getTopScore_medium()==0)  
       mm.setTopScorer_medium("Medium : No Top Scorer Yet");
       else
       mm.setTopScorer_medium("<html>Medium : "+cdr.getTopScorer_medium()+"<br>"+" Score: "+cdr.getTopScore_medium()+"</html>"); 
       cdr.userText();
       if(cdr.getTopScore_hard()==0)          
       mm.setTopScorer_hard("Hard : No Top Scorer Yet");       
       else      
       mm.setTopScorer_hard("<html>Hard : "+cdr.getTopScorer_hard()+"<br>"+" Score: "+cdr.getTopScore_hard()+"</html>"); 
     
       postgame.dispose();
      
       mm.setindex(index);
       mm.createMainmenu();
       mm.getFrame().setVisible(true);
             
                } catch (IOException ex) {
                  ex.printStackTrace();
                }
            }
        });
  }
   public void setResult(int total_q,int f_score, int Pointsper_q) throws FileNotFoundException 
      {
     
         Fscore.setText(Integer.toString(total_q));
         totalq.setText(Integer.toString(f_score));
         ppq.setText(Integer.toString(Pointsper_q));
         finalscore=Integer.toString(f_score);
      }
  
  public javax.swing.JFrame getFrame()
    {
        return postgame;
    }
  public void setIndex(int x,String diff)
  {
      index=x;
      this.diff=diff;
  }
  private  void updatescore(String f_score) throws FileNotFoundException, IOException
  {
      if(diff.equals("easy"))
      {
          scores= cdr.getScore_easy();
      }
      else  if(diff.equals("medium"))
      {
          scores= cdr.getScore_medium();
      }
      else  if(diff.equals("hard"))
      {
          scores= cdr.getScore_hard();
      }
          
      int ff_score = Integer.parseInt(f_score);
      
      if(ff_score>Integer.parseInt(scores[index]))
      {
     scores[index]=f_score;
      FileOutputStream update_score = new FileOutputStream("userdata/score_"+diff+".txt");
      String delimiter=";";
       for(int i=0;i<scores.length;i++)
        {
            update_score.write(scores[i].getBytes());
            update_score.write(delimiter.getBytes());
            update_score.flush();
          
        }
       update_score.close();
      }
      
  }
}
