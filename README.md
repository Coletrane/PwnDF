# PwnDF
PDF password cracking tool using the iText and BouncyCastle libraries. 
*For legal and research use only*

Install/Run:

1. Download BouncyCastle (v1.54 and up) https://www.bouncycastle.org/latest_releases.html
2. Download iText https://github.com/itext/itextpdf.git
3. Compile with $ javac -cp [itext jar file]:.:[bouncycastle jar file] PwnDF.java
4. Run with $ java -cp [itext jar file]:.:[bouncycastle jar file] PwnDF.java [dictionary file] [pdf file]

Notes:

The default configuration is to run 8 threads, command line argument specification of thread count will be included in future versions

Upon finding an acceptable password, the string will be written to a file "Password.txt" the program will continue to look for a second password and write this to "Password1.txt"
