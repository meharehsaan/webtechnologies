import java.io.*;

public class WordCount {
    public static void main(String[] args) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Exception Occurs");
        }

        System.out.println("The file contains " + wordCount + " words.");
    }
}

