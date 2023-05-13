import java.io.*;
import java.util.*;

public class HashMapFileExample {
    public static void main(String[] args) throws IOException {
        // Create a new HashMap
        HashMap<Integer, Student> map = new HashMap<>();

        // Add some data to the map
        map.put(1, new Student("Alice", "555-1234", "123 Main St", 1001));
        map.put(2, new Student("Bob", "555-5678", "456 Elm St", 1002));
        map.put(3, new Student("Charlie", "555-9012", "789 Oak St", 1003));

        // Write data to a file with ":" delimiter
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            int rollNo = entry.getKey();
            Student student = entry.getValue();
            writer.write(rollNo + ":" + student.getName() + ":" + student.getPhone() + ":" + student.getAddress() + "\n");
        }
        writer.close();

        // Read data from the file
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        HashMap<Integer, Student> newMap = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            int rollNo = Integer.parseInt(parts[0]);
            String name = parts[1];
            String phone = parts[2];
            String address = parts[3];
            Student student = new Student(name, phone, address, rollNo);
            newMap.put(rollNo, student);
        }
        reader.close();

        // Print the contents of the new map
        for (Map.Entry<Integer, Student> entry : newMap.entrySet()) {
            int rollNo = entry.getKey();
            Student student = entry.getValue();
            System.out.println("Roll No: " + rollNo);
            System.out.println("Name: " + student.getName());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Address: " + student.getAddress());
            System.out.println();
        }
    }
}

class Student {
    private String name;
    private String phone;
    private String address;
    private int rollNo;

    public Student(String name, String phone, String address, int rollNo) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getRollNo() {
        return rollNo;
    }
}
