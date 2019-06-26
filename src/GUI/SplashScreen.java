
package GUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class SplashScreen  extends JPanel{

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JWindow window = new JWindow();
    private JProgressBar progressBar = new JProgressBar();
    private  int count;
    private  Timer timer1;
 
    
    public void paintComponent(Graphics g){
   Image image;
        try {
            image = ImageIO.read(new File("image/splash2.jpg"));
             super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this);
        }
        } catch (IOException ex) {
          
        }
    }
    public void createSplashScreen() {
        window.setSize(640,400);
        window.setLocation(screenSize.width/2,screenSize.height/2);
        window.setLocationRelativeTo(null);
        window.add(this);
        this.setLayout(null);
        progressBar.setMaximum(50);
        progressBar.setBounds(220, 340, 250, 15);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(20,10,10));
        this.add(progressBar);

        loadProgressBar();
        
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);


                if (count == 80) {
                    try {
                        window.setVisible(false);
                        timer1.stop();
                        loginPage lp = new loginPage();
                        lp.CreateLoginPage();
                        lp.getFrame().setVisible(true);
                    } catch (IOException ex) {
                       ex.printStackTrace();
                    }
                }

            }
      
        };
        timer1 = new Timer(40, al); 
        timer1.start();
    }
public javax.swing.JWindow getsplashscreen()
{
    return window;
}
    
}