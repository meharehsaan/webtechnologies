
// package streams;
import java.io.*;
// import java.util.*;

public class bufferstreams {
    public static void main(String[] args) {
        try {
            FileInputStream bis = new FileInputStream("data.txt");
            BufferedInputStream bis1 = new BufferedInputStream(bis);
            FileOutputStream bos = new FileOutputStream("data1.txt");
            BufferedOutputStream bos1 = new BufferedOutputStream(bos);

            try {
                byte[] buffer = new byte[1024];
                int bytes;
                while ((bytes = bis1.read(buffer)) != -1) {
                    // System.out.println();
                    bos1.write(buffer, 0, bytes);
                }
                System.out.println("success\n");
                bis1.close();
                bos1.close();
            } catch (IOException e) {
                System.out.println("Exception occuring");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not exists");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e);
        }
    }
}
