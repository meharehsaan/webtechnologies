import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileInfoExample {
    public static void main(String[] args) {
        // Create a file object for the file at the specified location
        File file = new File("c:/files/sample.txt");

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists");

            // Check if the file is readable and writable
            if (file.canRead()) {
                System.out.println("File is readable");
            }
            if (file.canWrite()) {
                System.out.println("File is writable");
            }

            // Get the creation time of the file
            try {
                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                FileTime creationTime = attr.creationTime();
                System.out.println("File created on: " + creationTime);
            } catch (Exception e) {
                System.out.println("Error getting file creation time: " + e.getMessage());
            }

            // Get the last modified time of the file
            FileTime lastModifiedTime = FileTime.fromMillis(file.lastModified());
            System.out.println("File last modified on: " + lastModifiedTime);
        } else {
            System.out.println("File does not exist");
        }
    }
}
