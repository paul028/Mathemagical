package processor;
import java.io.*;
import javax.swing.ImageIcon;
public class QandA_Reader {
    private String  read="";
    private String  read2="";
    private ImageIcon[] Questions;
    private String[] Answers;
    private int ATOTAL=0;
    private int QTOTAL=0;
    private String mode ="";
public void easy() throws FileNotFoundException
{
        InputStream AS = new FileInputStream("questions/Easy_Answer.txt");
        mode="easy";
        countAnswer(AS);
        transferQuestions();
}
public void medium() throws FileNotFoundException
{
        InputStream AS = new FileInputStream("questions/Medium_Answer.txt");
     mode="medium";
        countAnswer(AS);
      transferQuestions();
}
public void hard() throws FileNotFoundException
{
     InputStream AS = new FileInputStream("questions/Hard_Answer.txt");
      mode="hard";
        countAnswer(AS);
         transferQuestions();
}
public void transferQuestions()
 {
        ImageIcon save[]=new  ImageIcon[ATOTAL];
        for(int i =0;i<save.length;i++)
        {
            save[i]=new ImageIcon("questions/image_questions/"+mode+"/"+mode+(i+1)+".png");
        }
   Questions=save;

}
public void countAnswer(InputStream A)
{
    int data_answers;
        try {
            while((data_answers= A.read())!=-1)
             {
                 if(data_answers==59)
                 {
                 ATOTAL++;
                 }  
                 read2 +=(char)data_answers;
             }
            } 

         catch (IOException e) 
         {
            e.printStackTrace();
         }
      transferAnswers();
}
public void transferAnswers()
 {
        String save[]=new String[ATOTAL];
        for(int i =0;i<save.length;i++)
        {
            save[i]="";
        }
        int z=0;
   for(int i=0;i<save.length;)
   {
               for(int j=z;j<read2.length();j=z)
                {
                    z++;
                    if(read2.charAt(j)==59)
                    {
                   i++;
                   break;
                    }
                    else
                    {
                        save[i]+=read2.charAt(j);
                    }
                }
   }
   Answers=save;
}
public ImageIcon[] getQuestions()
{
    return Questions;
}
public String[] getAnswers()
{
    return Answers;
}
public int getQTOTAL()
{
    return ATOTAL;
}
} 
