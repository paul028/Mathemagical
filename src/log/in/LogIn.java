package log.in;

import javax.swing.JOptionPane;
import GUI.MainMenu;
public class LogIn extends CriticalDataReader{
 
    private int i;
    private String enteredUsername;
    private String enteredPassword;
    private String temp2;
    private String temp="";
    private  boolean check;
    
    public void Login(String enteredUsername,String enteredPassword)
    { 
           for(int i=0;i<enteredPassword.length();i++)
       {
           {
           if(((enteredPassword.charAt(i)>=65)&(enteredPassword.charAt(i)<=77))|((enteredPassword.charAt(i)>=97)&(enteredPassword.charAt(i)<=109)))
           {
           temp+=(char)(enteredPassword.charAt(i)+13);
           }
          else  if(((enteredPassword.charAt(i)>=78)&(enteredPassword.charAt(i)<=90)) |((enteredPassword.charAt(i)>=110)&(enteredPassword.charAt(i)<=122)))
           {
          temp+=(char)(enteredPassword.charAt(i)-13);
           }
           else if(enteredPassword.charAt(i)==32)
          {
              temp+=(char)(enteredPassword.charAt(i));
          }
           else
           {
                temp+=(char)(enteredPassword.charAt(i));
           }
       }
       }
        this.enteredUsername = enteredUsername;
        this.enteredPassword=temp;
        temp="";
        checker();
    }
       public boolean checker()
    {  
        for(int i=0;i<usernames.length;i++)
        {
          if(enteredUsername.equals(usernames[i]))
          { 
              if(enteredPassword.equals(passwords[i]))
              { this.i=i;
                  check=true;
              }
              else
              {
                  check=false;
              }
          }
        } 
       return check;
    }
       public void result()
       { MainMenu mm = new MainMenu();
      
            if(check==true)
        {
     JOptionPane.showMessageDialog(null,"WELCOME "+names[i],"WELCOME",JOptionPane.INFORMATION_MESSAGE);
     
     {
       if(topscore_e==0)
       {
           mm.setTopScorer_easy("Easy : No Top Scorer Yet");
       }
          else
       {
             mm.setTopScorer_easy("<html>Easy : "+topscorer_e+"<br>"+" Score: "+topscore_e+"</html>"); 

       }
        }
     
       {
             if(topscore_m==0)
       {
           mm.setTopScorer_medium("Medium : No Top Scorer Yet");

       }
            else
              {
            mm.setTopScorer_medium("<html>Medium : "+topscorer_m+"<br>"+" Score: "+topscore_m+"</html>");
                 }
        }
       
             {    
          if(topscore_h==0)
              {
           mm.setTopScorer_hard("Hard : No Top Scorer Yet");
              }
          else 
             {
          mm.setTopScorer_hard("<html>Hard : "+topscorer_h+"<br>"+" Score: "+topscore_h+"</html>");
             }
        }
             mm.setindex(i);
        mm.setMyscore("Easy : "+scores_e[i],"Medium : "+scores_m[i],"Hard : "+scores_h[i]);
         mm.createMainmenu();
         mm.getFrame().setVisible(true); 
        }
        else
        { 
            for(int i =0;i<usernames.length;i++)
            {
             usernames[i]="";
             passwords[i]="";
             names[i]="";
             scores_e[i]="";  
             scores_m[i]="";
             scores_h[i]="";
            }
    readuser="";
    readpass="";
    readname="";
    totaluser=0;
    totalpassword=0;
    totalname=0;
    totalscore_e=0;
    totalscore_m=0;
    totalscore_h=0;
    readscore_e="";
    readscore_m="";
    readscore_h="";
    topscore_e=0;
    topscore_m=0;
    topscore_h=0;
    topscorer_e="";
    topscorer_m="";
    topscorer_h="";
           JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
        }    
       }
   
}
