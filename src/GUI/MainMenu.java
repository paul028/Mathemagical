package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu extends JPanel{
    private ImageIcon img = new ImageIcon("image/asd.jpg");
 private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 private int index;
    private JFrame mainmenu = new JFrame("Mathemagical");
    private JButton easy = new JButton("EASY");
    private JButton medium =new JButton("MEDIUM");
    private JButton hard = new JButton("HARD");
    private JButton Logout = new JButton("Log Out");
    private JButton about = new JButton("About");
    private JLabel HighScorer_e= new JLabel();
    private JLabel HighScorer_m= new JLabel();
    private JLabel HighScorer_h= new JLabel();
    private JLabel myscore_e=new JLabel("Easy:");
    private JLabel myscore_m=new JLabel("Medium:");
    private JLabel myscore_h=new JLabel("Hard:");
    private JLabel MyStat= new JLabel("MY STATUS");
    private JLabel HighScore = new JLabel("HIGH SCORER");
    GameProper game = new GameProper();
    
     public void paintComponent(Graphics g){
   Image image;
        try {
            image = ImageIO.read(new File("image/main menu.jpg"));
             super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this);
        }
        } catch (IOException ex) {
          
        }
       
    }
    public void createMainmenu()
            
    {
    HighScore.setFont(new Font("Cooper Black", Font.BOLD, 30));
        HighScore.setForeground(Color.WHITE);
        HighScorer_e.setFont(new Font("Courier New", Font.BOLD, 20)); 
        HighScorer_e.setForeground(Color.WHITE);
        HighScorer_m.setFont(new Font("Courier New", Font.BOLD, 20)); 
        HighScorer_m.setForeground(Color.WHITE);
        HighScorer_h.setFont(new Font("Courier New", Font.BOLD, 20)); 
        HighScorer_h.setForeground(Color.WHITE);
        MyStat.setFont(new Font("Cooper Black", Font.BOLD, 30)); 
        MyStat.setForeground(Color.WHITE);
        mainmenu.setFont(new Font("Courier New", Font.BOLD, 18));
        mainmenu.setIconImage(img.getImage());
        mainmenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainmenu.setSize(800,600); 
        mainmenu.setLocation(screenSize.width/2,screenSize.height/2);
        mainmenu.setLocationRelativeTo(null);
        mainmenu.setResizable(false);
        mainmenu.add(this);
        myscore_e.setFont(new Font("Courier New", Font.BOLD, 20));
        myscore_e.setForeground(Color.WHITE);
        myscore_m.setFont(new Font("Courier New", Font.BOLD, 20));
        myscore_m.setForeground(Color.WHITE);
        myscore_h.setFont(new Font("Courier New", Font.BOLD, 20)); 
        myscore_h.setForeground(Color.WHITE);
                               
        easy.setFont(new Font("Cooper Black", Font.BOLD, 35)); 
        easy.setForeground(Color.white);
        easy.setBackground(Color.ORANGE);

      medium.setFont(new Font("Cooper Black", Font.BOLD, 33)); 
      medium.setForeground(Color.white);
      medium.setBackground(Color.GREEN);


      hard.setForeground(Color.white);
       hard.setFont(new Font("Cooper Black", Font.BOLD, 35)); 
        hard.setBackground(Color.red);
                                  
        Logout.setFont(new Font("Cooper Black", Font.BOLD, 30)); 
          Logout.setForeground(Color.white);
       Logout.setBackground(Color.BLUE);
                                     
            about.setFont(new Font("Cooper Black", Font.BOLD, 30)); 
               about.setForeground(Color.white);
      about.setBackground(Color.BLUE);     

        this.setLayout(null);
       this.add(HighScore);
       this.add(HighScorer_e);
       this.add(HighScorer_m);
       this.add(HighScorer_h);
       this.add(MyStat);
       this.add(easy);
       this.add(medium);
       this.add(hard);
       this.add(about);
       this.add(myscore_e);
       this.add(myscore_m);
       this.add(myscore_h);
       this.add(Logout); //800x600
       MyStat.setBounds(570,10,250,30);
       HighScore.setBounds(150,10,250,30);
       HighScorer_e.setBounds(50,60,500,60);
       HighScorer_m.setBounds(50,110,380,60);
       HighScorer_h.setBounds(50,160,380,60);
       myscore_e.setBounds(570,60,380,30);
       myscore_m.setBounds(570,110,380,30);
       myscore_h.setBounds(570,160,380,30);
       Logout.setBounds(550,480,190,75);
       about.setBounds(40,480,150,75);
       easy.setBounds(300,200,200,100);
       medium.setBounds(300,310,200,100);
       hard.setBounds(300,420,200,100);
       
        aboutIsPressed();
        easyIsPressed();
        mediumIsPressed();
        hardIsPressed();
        logoutisPressed();
    }
    private void easyIsPressed()
    {
           easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"<html>Game Mode: Easy"
                    + "<br>You are given 30seconds per questions to answer",
                    "Proceed",JOptionPane.INFORMATION_MESSAGE);
                try {
                    game.setIndex(index);
                    game.setMode(1,30,"easy");
                    mainmenu.dispose();
                    game.createGameProper();
                    game.getFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
                }
            }
        });
    }
   private void mediumIsPressed()
    {
            medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"<html>Game Mode: Medium"
                    + "<br>You are given 45seconds per questions to answer",
           "Proceed",JOptionPane.INFORMATION_MESSAGE);
                try {
                     game.setIndex(index);
                    game.setMode(2,45,"medium");
                    mainmenu.dispose();
                    game.createGameProper();
                    game.getFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                }
            }
        });
    }
    private void hardIsPressed()
    {
            hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"<html>Game Mode: Hard"
                    + "<br>You are given 1 minute per questions to answer",
              "Proceed",JOptionPane.INFORMATION_MESSAGE);
                try {
                     game.setIndex(index);
                         mainmenu.dispose();
                    game.setMode(3,60,"hard");
                    game.createGameProper();
                    game.getFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
                }
            }
        });
    }
    
    private void aboutIsPressed()
    {
     about.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae) {                
        JOptionPane.showMessageDialog(null,"<html>Created By: <br>Abbegail Bermido"
                + "<br>Paul Vincent Nonat<br>Ravinder Singh<br>John Lawrence Uayan<br>TIP QC -2014</html>",
                "Mathemagical",JOptionPane.CLOSED_OPTION); 
            }
        }); 
    }
    private void   logoutisPressed()
    {     loginPage lg =new loginPage();
         Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                try {
                           lg.CreateLoginPage();
                              JOptionPane.showMessageDialog(null,"See You Soon","Logging Out",JOptionPane.CLOSED_OPTION);
                               mainmenu.dispose();
                    lg.getFrame().setVisible(true);
                } catch (IOException ex) {
                 ex.printStackTrace();
                }
           
            }
        }); 
            
    }
    public void setMyscore(String easy,String medium, String hard)
    {
        myscore_e.setText(easy);
         myscore_m.setText(medium);
             myscore_h.setText(hard);
    }
 
    public void setTopScorer_easy(String High)
    {
        HighScorer_e.setText(High);
    }
      public void setTopScorer_medium(String High)
    {
        HighScorer_m.setText(High);
    }
        public void setTopScorer_hard(String High)
    {
        HighScorer_h.setText(High);
    }
         public javax.swing.JFrame getFrame()
    {
        return mainmenu;
    }
        public void setindex(int i)
        {
            index=i;
        }
     
}
