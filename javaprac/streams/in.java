import java.io.*;

public class in {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("in.class");

        int ch = 0;
        while((ch = in.read()) != -1){
            System.out.print((char) ch);
        }

        in.close();
    }
}
