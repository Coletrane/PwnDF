import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

// PwnDF
// A java library for cracking PDFs using password dictionaries

public class PwnDF
{
  public File worldlist;
  public File pdf;
  Scanner wscan;
  Scanner pscan;
  
  public static void main(String[] args) throws IOException
  {
    File wordlist;
    File pdf;
    Scanner wscan;
    Scanner pscan;
    
    
    wordlist = new File(args[0]);
    pdf = new File(args[1]);

    wscan = new Scanner(wordlist);
    pscan = new Scanner(pdf);
    PwnDF_Thread th[] = new PwnDF_Thread[8];
    
    for (int i = 0; i < 8; i++)
    {
      th[i] = new PwnDF_Thread(args[1], wscan);
      th[i].run();
    }
  }
}
