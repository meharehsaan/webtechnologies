import java.io.*;
import java.util.*;

public class out {
    public static void main(String[] args) throws IOException {
        Scanner  in = new Scanner(System.in);
        String str = in.nextLine();

        FileOutputStream out = new FileOutputStream("file.txt");
        
        byte[] arr = str.getBytes();
        
        for(int i = 0; i < arr.length; i++){
            out.write(arr[i]);
        }

        System.out.print("Succesfully written in file\n");
        out.close();
    }
}
