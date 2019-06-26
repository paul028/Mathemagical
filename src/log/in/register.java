
package log.in;
import GUI.loginPage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;


public class register extends CriticalDataReader{
    
    private String newUser;
    private String newName;
    private String newPass;
    private String newScore="0";
    private boolean result;
    
   
    
    public void addAccount(String newUser,String newName, String newPass) throws IOException 
    {
        this.newUser = newUser;
        this.newName = newName;
        this.newPass = newPass;
       checker();
    }
    public boolean checker() 
    {
        for(int i=0;i<usernames.length;i++)
        {
            if(newUser.equals(usernames[i]))
            {
                result = false;
                break;     
            }
            else
            {
                result =true;
            }
        }
        return result;
    }
    public void result() throws IOException
    {
      
        if(result==true)
        {
                
                saveUsername();
                JOptionPane.showMessageDialog(null,"Succesfuly Registered","Result",JOptionPane.INFORMATION_MESSAGE);
                loginPage lp = new loginPage();
                lp.CreateLoginPage();
                lp.getFrame().setVisible(result);
        }
        else
        {
    
            JOptionPane.showMessageDialog(null,"username Already registered","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void saveUsername() throws FileNotFoundException, IOException
    {
       String delimiter=";";
        OutputStream user = new FileOutputStream("userdata/user.txt");
        for(int i=0;i<usernames.length;i++)
        {
            user.write(usernames[i].getBytes());
            user.write(delimiter.getBytes());
            user.flush();
        }
        user.write(newUser.getBytes());
        user.write(delimiter.getBytes());
        user.flush();
        user.close();
        savePassword();
    }
    private void savePassword() throws FileNotFoundException, IOException
    {
       String encrypt_holder=newPass;
       newPass="";
          for(int i=0;i<encrypt_holder.length();i++)
       {
           {
           if(((encrypt_holder.charAt(i)>=65)&(encrypt_holder.charAt(i)<=77))|((encrypt_holder.charAt(i)>=97)&(encrypt_holder.charAt(i)<=109)))
           {
            newPass+=(char)(encrypt_holder.charAt(i)+13);
           }
          else  if(((encrypt_holder.charAt(i)>=78)&(encrypt_holder.charAt(i)<=90)) |((encrypt_holder.charAt(i)>=110)&(encrypt_holder.charAt(i)<=122)))
           {
            newPass+=(char)(encrypt_holder.charAt(i)-13);
           }
           else if(encrypt_holder.charAt(i)==32)
          {
              newPass+=(char)(encrypt_holder.charAt(i));
          }
          else
           {
               newPass+=(char)(encrypt_holder.charAt(i));
           }
       }
       }
       String delimiter=";";
        OutputStream user = new FileOutputStream("userdata/pass.txt");
        for(int i=0;i<passwords.length;i++)
        {
            user.write(passwords[i].getBytes());
            user.write(delimiter.getBytes());
            user.flush();
        }
        user.write(newPass.getBytes());
        user.write(delimiter.getBytes());
        user.flush();
        user.close();
        saveName();  
    }
  private void saveName() throws FileNotFoundException, IOException
    {
       String delimiter=";";
        OutputStream user = new FileOutputStream("userdata/name.txt");
        for(int i=0;i<names.length;i++)
        {
            user.write(names[i].getBytes());
            user.write(delimiter.getBytes());
            user.flush();
        }
        user.write(newName.getBytes());
        user.write(delimiter.getBytes());
        user.flush();
        user.close();
        saveScore_easy();     
        saveScore_medium();
        saveScore_hard();
    }
  private void saveScore_easy() throws FileNotFoundException,IOException
  {
        String delimiter=";";
        OutputStream user = new FileOutputStream("userdata/score_easy.txt");
        for(int i=0;i<scores_e.length;i++)
        {
            user.write(scores_e[i].getBytes());
            user.write(delimiter.getBytes());
            user.flush();
        }
        user.write(newScore.getBytes());
        user.write(delimiter.getBytes());
        user.flush();
        user.close();
        
  }
    private void saveScore_medium() throws FileNotFoundException,IOException
  {
        String delimiter=";";
        OutputStream user = new FileOutputStream("userdata/score_medium.txt");
        for(int i=0;i<scores_m.length;i++)
        {
            user.write(scores_m[i].getBytes());
            user.write(delimiter.getBytes());
            user.flush();
        }
        user.write(newScore.getBytes());
        user.write(delimiter.getBytes());
        user.flush();
        user.close();
        
  }
      private void saveScore_hard() throws FileNotFoundException,IOException
  {
        String delimiter=";";
        OutputStream user = new FileOutputStream("userdata/score_hard.txt");
        for(int i=0;i<scores_h.length;i++)
        {
            user.write(scores_h[i].getBytes());
            user.write(delimiter.getBytes());
            user.flush();
        }
        user.write(newScore.getBytes());
        user.write(delimiter.getBytes());
        user.flush();
        user.close();
        
  }
public void displayLogin() throws IOException
{
    loginPage lp = new loginPage();
                lp.CreateLoginPage();
                lp.getFrame().setVisible(true);
}
 
}
