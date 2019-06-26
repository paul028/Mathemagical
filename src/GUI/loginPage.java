
package GUI;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import log.in.LogIn;


public class loginPage extends JPanel{
   

    private int mistake=0;
    private Timer t;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
    private ImageIcon img = new ImageIcon("image/asd.jpg");
    private JFrame loginpage = new JFrame("MATHEMAGICAL");
    private JPanel loginpanel =new JPanel();
    private JLabel userText = new JLabel("User Name :");
    private JLabel passText = new JLabel("Password  :");                                      
    private JTextField inputUser = new JTextField();
    private JPasswordField inputPass = new JPasswordField();
    private JButton login = new JButton("Log In");
    private JButton Register = new JButton("Register");
    private JLabel countdown =new JLabel("        ");
    private JLabel notif =new JLabel("           ");
   
    
 public void paintComponent(Graphics g){
   Image image;
        try {
            image = ImageIO.read(new File("image/log in.jpg"));
             super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this);
        }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
       
    }

    public void CreateLoginPage() throws IOException
    {
         userText.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 22)); 
        userText.setForeground(Color.yellow.brighter());
        passText.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 22)); 
        passText.setForeground(Color.yellow.brighter());
        loginpage.setIconImage(img.getImage());
        loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginpage.setSize(300,400); 
        loginpage.setLocation(screenSize.width/2,screenSize.height/2);
        loginpage.setLocationRelativeTo(null);
        loginpage.setResizable(false);
        loginpage.add(this);
        login.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20)); 

       Register.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20)); 
    

        this.setLayout(null);
        this.add(userText);
        userText.setBounds(40,120,140,20);
        this.add(passText); 
        passText.setBounds(50,170,140,20);
        this.add(Register);
         Register.setBounds(30,220,100,25);
         this.add(inputUser);
         inputUser.setBounds(160,120,100,20);
         this.add(inputPass);
        inputPass.setBounds(160,170,100,20);
        this.add(login);
        login.setBounds(160,220,100,25);
        this.add(notif);
        notif.setBounds(80,250,90,20);
        this.add(countdown);
        countdown.setBounds(170,250,90,20);  
       LoginIsPressed();
       RegisterIsPressed();
    }   
    private void RegisterIsPressed()
    {        
    RegisterPage rp = new RegisterPage();
    rp.Createregisterpage();
        Register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
           loginpage.dispose();
           rp.getFrame().setVisible(true);
            }
        });  
    }
    private void LoginIsPressed()
    {
       LogIn  li = new LogIn ();
       
       inputUser.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) { if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  login.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
          inputPass.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) {
               if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  login.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if((inputUser.getText().equals(""))|(inputPass.getText().equals("")))
                {
         JOptionPane.showMessageDialog(null,"no username/password","Log In Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                try {   
                    li.userText();
                    li.Login(inputUser.getText(),inputPass.getText());
                     if(li.checker()==true)
                    {
                        loginpage.dispose();
                        li.result();
                    }
                     else
                     {
                         mistake++;
                         li.result();
                         if(mistake==3)
                         { mistake=0;
                           timerstart();
                         }
                     }
                   inputUser.setText("");
                   inputPass.setText("");
                } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
                }  
            }
            }
        });
    }
     private void timerstart()
    {   notif.setText("Log in disabled for: ");
        countdown.setText("30");
     
        ActionListener al;
  
        al = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
              if(Integer.parseInt( countdown.getText())>0)
              { inputUser.setEnabled(false);
                  inputPass.setEnabled(false);
                  login.setEnabled(false);
                  Register.setEnabled(false);
                  loginpage.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                   countdown.setText(Integer.toString(Integer.parseInt(countdown.getText())-1));
              }  
              else if(Integer.parseInt( countdown.getText())==0)
              {   t.stop();
                 countdown.setText("");
                 notif.setText("");
                 loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 inputUser.setEnabled(true);
                  inputPass.setEnabled(true);
                  login.setEnabled(true);
                  Register.setEnabled(true);
              }
            }
        };
        t= new Timer(1000,al);
                   if(!t.isRunning())
         {
         t.start();
         }
    }
      public javax.swing.JFrame getFrame()
    {
        return loginpage;
    }
}
  