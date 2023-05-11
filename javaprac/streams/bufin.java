import java.io.*;
import java.util.*;

public class bufin {
    public void readdata(String filename) throws IOException, FileNotFoundException {
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        fis = new FileInputStream(filename);
        bis = new BufferedInputStream(fis);

        int data = 0;
        while ((data = bis.read()) > -1) {
            System.out.print((char) data);
        }

        System.out.println("\nReaded Data successfully");

        bis.close();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        bufin obj = new bufin();
        obj.readdata("data.txt");
    }

}
