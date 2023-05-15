// package streams;
import java.io.*;
// import java.util.*;

public class bufout {

    public void readandwrite(String filein, String fileout) throws IOException, FileNotFoundException {

        FileInputStream in = null;
        BufferedInputStream bis = null;
        FileOutputStream write = null;
        BufferedOutputStream bos = null;

        in = new FileInputStream(filein);
        bis = new BufferedInputStream(in);
        write = new FileOutputStream(fileout);
        bos = new BufferedOutputStream(write);

        // byte[] buffer = new byte[1024];
        int data = 0;
        while ((data = bis.read()) > -1) {
            // System.out.print((char) data);
            bos.write(data);
        }
        System.out.println("Success");
        bis.close();
        bos.close();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        bufout obj = new bufout();
        obj.readandwrite("data.txt", "data1.txt");
    }
}
