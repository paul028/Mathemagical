package GUI;
import log.in.register;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class RegisterPage {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ImageIcon img = new ImageIcon("image/asd.jpg");
    private JFrame registerpage = new JFrame("Register");
    private JPanel registerpanel = new JPanel();
    private JLabel userText = new JLabel("User Name :");
    private JLabel nameText = new JLabel("Full Name :");
    private JLabel passText = new JLabel("Password  :");
    private JLabel repassText = new JLabel("Re-Enter Password:");
    private JTextField inputUser = new JTextField();
    private JTextField inputFName = new JTextField();
    private JPasswordField inputPass = new JPasswordField();
    private JPasswordField reinputPass = new JPasswordField();
    private JButton clear = new JButton("Clear");
    private JButton Register = new JButton("Register Me");
     private JButton Return = new JButton("Return to Log In Page");
      public void Createregisterpage()
      {
  
    registerpage.setIconImage(img.getImage());
    registerpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    registerpage.setSize(300,400); 
    registerpage.setLocation(screenSize.width/2,screenSize.height/2);
    registerpage.setLocationRelativeTo(null);
    registerpage.setResizable(false);
    registerpage.add(registerpanel);
     registerpanel.setBackground(new Color(130,118,167));
    registerpanel.setLayout(null);
    registerpanel.add(userText);
    userText.setBounds(55,100,80,30);
    registerpanel.add(nameText);
    nameText.setBounds(62,130,80,30);
    registerpanel.add(passText);
    passText.setBounds(55,160,80,30);
    registerpanel.add(repassText);
    repassText.setBounds(10,190,120,30);
    registerpanel.add(inputUser);
     inputUser.setBounds(130,105,100,20);
    registerpanel.add(inputFName);
    inputFName.setBounds(130,135,100,20);
    registerpanel.add(inputPass);
    inputPass.setBounds(130,165,100,20);
    registerpanel.add(reinputPass);
    reinputPass.setBounds(130,195,100,20);
    registerpanel.add(clear);
    clear.setBounds(20,235,80,20);
    registerpanel.add(Register);
    Register.setBounds(120,235,110,20);
     registerpanel.add(Return);
     Return.setBounds(70,265,160,20);
    clearIsPressed();
    registerMeIsPressed();
    returnIsPressed();
      }
    private void returnIsPressed()
    {
         inputUser.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) { if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
              {
                  Return.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
          inputPass.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) {
               if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  Return.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
   Return.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 try {
                     registerpage.dispose();
                     register re = new register();
                     re.displayLogin();
                 } catch (IOException ex) {
                    ex.printStackTrace();
                 }
             }
         }); 
    }
  private void clearIsPressed()
    {
    clear.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
             inputUser.setText("");
             inputFName.setText("");
             inputPass.setText(null);
             reinputPass.setText(null);  
             }
         }); 
    }
  private void registerMeIsPressed()
  {     register re = new register();
   inputUser.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) { if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  Register.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
          inputPass.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) {
               if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  Register.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
             reinputPass.addKeyListener(new KeyListener() {
           public void keyTyped(KeyEvent ke) {}
           public void keyPressed(KeyEvent ke) {
               if(ke.getKeyCode()==KeyEvent.VK_ENTER)
              {
                  Register.doClick();
              }}
           public void keyReleased(KeyEvent ke) {}
       });
        Register.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
              
               if((inputPass.getText().equals(""))|(reinputPass.getText().equals(""))|
                     (inputUser.getText().equals(""))|(inputFName.getText().equals("")))
             {
                  JOptionPane.showMessageDialog(null,"All data should be filled","Error",JOptionPane.ERROR_MESSAGE);
             }   else if(inputPass.getText().length()<8)
             {JOptionPane.showMessageDialog(null,"Password should have atleast 8characters","Error",JOptionPane.ERROR_MESSAGE);
             inputPass.setText("");
             reinputPass.setText("");
             }
             else if(inputPass.getText().equals(reinputPass.getText()))
             {
                 try {
                     re.userText();
                     re.addAccount(inputUser.getText(),inputFName.getText(),inputPass.getText());
                    if(re.checker()==true)
                    {
                        registerpage.dispose();
                        re.result();
                    }
                    else
                    {
                        re.result();
                    }
              inputUser.setText("");
              inputFName.setText("");
                 } catch (FileNotFoundException ex) {
                  ex.printStackTrace();
                 } catch (IOException ex) {
                   ex.printStackTrace();
                 }
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Password Does not Match","Error",JOptionPane.ERROR_MESSAGE);
                   inputPass.setText(null);
                 reinputPass.setText(null);
             }
             }
         });
  }
        public javax.swing.JFrame getFrame()
    {
        return registerpage;
    }
}
