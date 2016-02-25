import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.PdfReader;


public class PwnDF_Thread implements Runnable
{ 
  public String pdf;
  public Scanner wscan;
  public static boolean passFound = false;
  
  public PwnDF_Thread(String pdf, Scanner wscan)
  {
    this.pdf = pdf;
    this.wscan = wscan;
  }
  @Override
  public void run()
  {
    int lineIndex = 0;
    while (wscan.hasNextLine())
    { 
      String cur = wscan.nextLine();
      try
      {
        PdfReader reader = new PdfReader(pdf, cur.getBytes());
        System.out.println(cur + " YES.");
        
        if (passFound == false)
        {
          PrintWriter writer = new PrintWriter("Password.txt", "UTF-8");
          writer.append(cur + "\n");
          writer.close();
          passFound = true;
        }
        else
        {
          PrintWriter writer1 = new PrintWriter("Password1.txt", "UTF-8");
          writer1.append(cur + "\n");
          writer1.close();
        }
      }
      catch (BadPasswordException bpe)
      {
        System.out.println(cur + " NO.");
      }
      catch (IOException e)
      {
        System.out.println("IOException!");
        e.printStackTrace();
      }
    }
    
  }
}
