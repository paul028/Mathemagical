
package log.in;

import java.io.*;
public class CriticalDataReader {
    protected int totaluser=0;
    protected int totalpassword=0;
    protected int totalname=0;
    protected String readuser="";
    protected String readpass="";
    protected String readname="";     
    protected int totalscore_e=0;
    protected int totalscore_m=0;
    protected int totalscore_h=0;
    protected String readscore_e="";
    protected String readscore_m="";
    protected String readscore_h="";
    protected String[] usernames;
    protected String[] passwords;
    protected String[] names;
    protected String[] scores_e;
        protected String[] scores_m;
            protected String[] scores_h;
    protected int topscore_e;
    protected String topscorer_e;
     protected int topscore_m;
    protected String topscorer_m;
     protected int topscore_h;
    protected String topscorer_h;
    public void userText() throws FileNotFoundException
    {
        InputStream user= new FileInputStream("userdata/user.txt");
       countUser(user);
       passText();
       userName();
       userScore_easy();
       userScore_medium();
       userScore_hard();
    }
    private void passText() throws FileNotFoundException
    {
         InputStream pass= new FileInputStream("userdata/pass.txt");
         countPassword(pass);
    }
   private void userName() throws FileNotFoundException
    {
        InputStream name= new FileInputStream("userdata/name.txt"); 
        countName(name);
    }
    public void userScore_easy() throws FileNotFoundException
    {

      InputStream score= new FileInputStream("userdata/score_easy.txt");
      countScore_easy(score);
      
    }
     public void userScore_medium() throws FileNotFoundException
    {
      InputStream score= new FileInputStream("userdata/score_medium.txt");
      countScore_medium(score);
      
    }
      public void userScore_hard() throws FileNotFoundException
    {
      InputStream score= new FileInputStream("userdata/score_hard.txt");
      countScore_hard(score);
      
    }
    private void countScore_easy(InputStream Q)
{
    int data_score;
        try {
            while((data_score= Q.read())!=-1)
             {
                 if(data_score==59)
                 {
                 totalscore_e++;
                 }  
                 readscore_e +=(char)data_score;
             }
            } 
         catch (IOException e) 
         {
            e.printStackTrace();
         }
        transferScore_easy();
}
private void transferScore_easy()
 {
        String save[]=new String[totalscore_e];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<readscore_e.length();j=z)
                {
                    z++;
                    if(readscore_e.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=readscore_e.charAt(j);
                    }
                }
   }
   
   scores_e=save;
   topScorer_easy();
}
    private void countScore_medium(InputStream Q)
{
    int data_score;
        try {
            while((data_score= Q.read())!=-1)
             {
                 if(data_score==59)
                 {
                 totalscore_m++;
                 }  
                 readscore_m +=(char)data_score;
             }
            } 
         catch (IOException e) 
         {
            e.printStackTrace();
         }
        transferScore_medium();
}
private void transferScore_medium()
 {
        String save[]=new String[totalscore_m];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<readscore_m.length();j=z)
                {
                    z++;
                    if(readscore_m.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=readscore_m.charAt(j);
                    }
                }
   }
   
   scores_m=save;
   topScorer_medium();
}
 private void countScore_hard(InputStream Q)
{
    int data_score;
        try {
            while((data_score= Q.read())!=-1)
             {
                 if(data_score==59)
                 {
                 totalscore_h++;
                 }  
                 readscore_h +=(char)data_score;
             }
            } 
         catch (IOException e) 
         {
            e.printStackTrace();
         }
        transferScore_hard();
}
private void transferScore_hard()
 {
        String save[]=new String[totalscore_h];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<readscore_h.length();j=z)
                {
                    z++;
                    if(readscore_h.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=readscore_h.charAt(j);
                    }
                }
   }
   
   scores_h=save;
   topScorer_hard();
}
public void topScorer_easy()
{
    int[] score = new int[totalscore_e];
    for(int i=0;i<scores_e.length;i++)
    {
        score[i]=Integer.parseInt(this.scores_e[i]);
    }
    
     int y=0;
        for( int x=1 ; x < scores_e.length; x++){
            if(score[y] > score[x]){
               topscore_e= score[y];
               topscorer_e=names[y];
            }
            else{
                y=x;
                topscore_e = score[y];
                topscorer_e=names[y];
            }
        }
}
public void topScorer_medium()
{
    int[] score = new int[totalscore_m];
    for(int i=0;i<scores_m.length;i++)
    {
        score[i]=Integer.parseInt(this.scores_m[i]);
    }
    
     int y=0;
        for( int x=1 ; x < scores_m.length; x++){
            if(score[y] > score[x]){
               topscore_m = score[y];
               topscorer_m=names[y];
            }
            else{
                y=x;
                topscore_m = score[y];
                topscorer_m=names[y];
            }
        }
}
public void topScorer_hard()
{
    int[] score = new int[totalscore_h];
    for(int i=0;i<scores_h.length;i++)
    {
        score[i]=Integer.parseInt(this.scores_h[i]);
    }
    
     int y=0;
        for( int x=1 ; x < scores_h.length; x++){
            if(score[y] > score[x]){
               topscore_h = score[y];
               topscorer_h=names[y];
            }
            else{
                y=x;
                topscore_h= score[y];
                topscorer_h=names[y];
            }
        }
}
public String getTopScorer_easy()
{
    return topscorer_e;
}
public String getTopScorer_medium()
{
    return topscorer_m;
}
public String getTopScorer_hard()
{
    return topscorer_h;
}
public int getTopScore_easy()
{
    return topscore_e;
}
public int getTopScore_medium()
{
    return topscore_m;
}
public int getTopScore_hard()
{
    return topscore_h;
}
  public String[] getScore_easy()
       {
           return scores_e;
       }
    public String[] getScore_medium()
       {
           return scores_m;
       }
      public String[] getScore_hard()
       {
           return scores_h;
       }
private void countUser(InputStream Q)
{
    int data_username;
        try {
            while((data_username= Q.read())!=-1)
             {
                 if(data_username==59)
                 {
                 totaluser++;
                 }  
                 readuser +=(char)data_username;
             }
            } 
         catch (IOException e) 
         {
            e.printStackTrace();
         }
        transferUsername();
}
private void transferUsername()
 {
        String save[]=new String[totaluser];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<readuser.length();j=z)
                {
                    z++;
                    if(readuser.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=readuser.charAt(j);
                    }
                }
   }
   usernames=save;
}
private void countPassword(InputStream Q)
{
    int data_password;
        try {
            while((data_password= Q.read())!=-1)
             {
                 if(data_password==59)
                 {
                 totalpassword++;
                 }  
                 readpass +=(char)data_password;
             }
            } 
         catch (IOException e) 
         {
            e.printStackTrace();
         }
        transferPassword();
}
    //include password d +13 Algorithm
 private void transferPassword()
 {
        String save[]=new String[totalpassword];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<readpass.length();j=z)
                {
                    z++;
                    if(readpass.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=readpass.charAt(j);
                    }
                }
   }
  passwords=save;
}  
private void countName(InputStream Q)
{
    int data_name;
        try {
            while((data_name= Q.read())!=-1)
             {
                 if(data_name==59)
                 {
                 totalname++;
                 }  
                 readname +=(char)data_name;
             }
            } 

         catch (IOException e) 
         {
            e.printStackTrace();
         }
        transfername();
}
private void transfername()
 {
        String save[]=new String[totalname];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<readname.length();j=z)
                {
                    z++;
                    if(readname.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=readname.charAt(j);
                    }
                }
   }
   names=save;
}   

 
}
