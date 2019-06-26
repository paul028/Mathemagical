package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import processor.Game;


public class GameProper extends JPanel{
    private  Timer t;
    private String diff;
    private int seconds;
    Game game = new Game();
    private ImageIcon img = new ImageIcon("image/asd.jpg");
    private int index;
     private JProgressBar timer = new JProgressBar();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JFrame gameproper =new JFrame("Mathemagical");
    private JLabel timerText = new JLabel("TIMER: ");
    private JLabel ansText = new JLabel("Input Answer:");
    private JLabel question = new JLabel();
    private JLabel mistake = new JLabel("Mistake :");
    private JLabel countm = new JLabel("0");
    private JLabel difficulty = new JLabel();
    private JLabel score = new JLabel("Score :");
    private JLabel score_receive = new JLabel();
    private JTextField inputAns =new JTextField("");
    private JButton submit = new JButton("Submit");
    private JButton clear = new JButton("Clear");
    private JButton quit = new JButton("Quit");
       public void paintComponent(Graphics g){
   Image image;
        try {
            image = ImageIO.read(new File("image/game proper.jpg"));
             super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this);
        }
        } catch (IOException ex) {
          
        }
       
    }
       public void createGameProper()
       
       {
        submit.setFont(new Font("Cooper Black", Font.BOLD, 30));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.blue);
        quit.setFont(new Font("Cooper Black", Font.BOLD, 30));
        quit.setForeground(Color.WHITE);
        quit.setBackground(Color.ORANGE);
        clear.setFont(new Font("Cooper Black", Font.BOLD, 30));
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.RED);
                
                difficulty.setFont(new Font("Elephant", Font.ITALIC, 75));
                difficulty.setForeground(Color.GREEN);
               
                timerText.setFont(new Font("Cooper Black", Font.PLAIN, 30));
                timerText.setForeground(Color.YELLOW);
                ansText.setFont(new Font("Cooper Black", Font.PLAIN, 30));
                ansText.setForeground(Color.WHITE);
                mistake.setFont(new Font("Cooper Black", Font.PLAIN, 30));
                mistake.setForeground(Color.WHITE);
                countm.setFont(new Font("Cooper Black", Font.PLAIN, 30));
                countm.setForeground(Color.WHITE);
                score.setFont(new Font("Cooper Black", Font.PLAIN, 30)); 
                score.setForeground(Color.WHITE);
                score_receive.setFont(new Font("Cooper Black", Font.PLAIN, 30));
                score_receive.setForeground(Color.WHITE);
      gameproper.setIconImage(img.getImage());
      gameproper.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      gameproper.setSize(800,600); 
      gameproper.setLocation(screenSize.width/2,screenSize.height/2);
      gameproper.setLocationRelativeTo(null);
      gameproper.setResizable(false);
      gameproper.add(this);

    this.setLayout(null);
     this.add(timerText);
      this.add(timer);
    this.add(question);
     this.add(ansText);
   this.add(inputAns);
     this.add(submit);
     this.add(clear);
     this.add(quit);
     this.add(mistake);
      this.add(score);
   this.add(countm);
   this.add(difficulty);
     this.add(score_receive);
     difficulty.setBounds(160,30,900,120);
      timerText.setBounds(30,3,150,20);
      timer.setBounds(150,2,500,25);
      question.setBounds(180,80,450,300); // x y l w
      ansText.setBounds(180,280,300,100);
      inputAns.setBounds(420,320,200,25);
      
      mistake.setBounds(180,370,150,30);
      score.setBounds(430,370,150,30);
      countm.setBounds(330,370,100,30); //total mistake
      score_receive.setBounds(540,370,100,30); // total score;
      timer.setMaximum(seconds);
      submit.setBounds(320,440,180,40);
      quit.setBounds(550,440,180,40);
      clear.setBounds(100,440,180,40);

       
      timerstart();
      SubmitIsPressed();
      ClearIsPressed();
      quitisPressed();
       }
       private void quitisPressed()
       {
               quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Object[] options = {"Yes","No"};
                
                 int choice =JOptionPane.showOptionDialog(null,"Do you want to Quit?","Message",
                     JOptionPane.YES_NO_OPTION,JOptionPane.YES_NO_OPTION,null,options,options[1]);
        if(choice==JOptionPane.YES_OPTION)
            {
                    try {
                        gameproper.dispose();
                         t.stop();
                         game.setIndex(index);
                        game.end();
                        
                    } catch (FileNotFoundException ex) {
                       ex.printStackTrace();
                    }
            }
            }
        });
       }
        private void timerstart()
    {
        ActionListener al;
        timer.setValue(seconds);
        al = new ActionListener(){

            public void actionPerformed(ActionEvent ae) {
              if(timer.getValue()>=1)
                  timer.setValue(timer.getValue()-1);
              else if(timer.getValue()==0)
              {
                  t.stop();
                  submit.doClick();
              }
            }
        };
        t= new Timer(1000,al);
                   if(!t.isRunning())
         {
         t.start();
         }
    }
  private void SubmitIsPressed()
    {
        inputAns.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) { if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  submit.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
          submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    game.setIndex(index);
                    t.stop();
                    if(inputAns.getText()==inputAns.getText())
                    {
                          JOptionPane.showMessageDialog(null,"No Answer",
              "Wrong",JOptionPane.ERROR_MESSAGE);
                    }
                    game.Checker(inputAns.getText());
                    getquestion();
                    inputAns.setText("");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
   private void ClearIsPressed()
    {
          clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              inputAns.setText("");
            }
        });
    }
        private void getquestion() throws FileNotFoundException
      {if(game.visible()==true)
      { timer.setValue(seconds);
      countm.setText(Integer.toString(game.getmistake()));
      score_receive.setText(Integer.toString(game.getscore()));
          question.setIcon(game.game());
        timerstart();
      }
        else
      {  
          gameproper.dispose();
      }
      }
      public void setMode(int x,int seconds, String diff) throws FileNotFoundException
      {     this.seconds = seconds;
            this.diff=diff;
            difficulty.setText(this.diff.toUpperCase());
          game.setDifficulty(x,seconds,this.diff);
          question.setIcon(game.game());
          game.setIndex(index);
          if(game.getmistake()==1)
          {
          countm.setText("<html><font color='green'"+game.getmistake()+"</font></html>");
          }
          if(game.getmistake()==2)
          {
               countm.setText("<html><font color='orange'"+game.getmistake()+"</font></html>");
          }
          if(game.getmistake()==3)
          {
               countm.setText("<html><font color='orange'"+game.getmistake()+"</font></html>");
          }
          score_receive.setText(Integer.toString(game.getscore()));
      }
          public javax.swing.JFrame getFrame()
    {
        return gameproper;
    }
         public void setIndex(int x)
         {
            index =x;
         }
       
}
