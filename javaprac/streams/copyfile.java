// Must create file.txt before compilation of this code 
// import java.util.*;
import java.io.*;

public class copyfile {
    public static void main(String[] args) {
        
        FileInputStream fin = null;
        FileOutputStream fos = null;
        String str = " ";
        int eof = -1;   //no eof keyword exists in java

        try{
            fin = new FileInputStream("file.txt");
            fos = new FileOutputStream("file1.txt");
            byte[] buffer = new byte[1024];
            int bytes; 

            while ((bytes = fin.read(buffer)) != eof) {
                fos.write(buffer, 0, bytes);              
            }
            System.out.println("Success");
        }
        catch(Exception e){
            System.out.println("Exception occurs");
        }
    }
}
