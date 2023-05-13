/* ObjectInput and OutputStreams are used to do serialization */
// package streams;
import java.util.*;
import java.io.*;

public class serialization implements Serializable {
    String name = " ";
    transient int phone = 0;
    transient String address = " ";

    public serialization(String n, int ph, String ad) {
        name = n;
        phone = ph;
        address = ad;
    }

    public void print() {
        System.out.println(name + " " + phone + " " + address);
    }

    public static void main(String[] args) {
        serialization obj = new serialization("Ehsaan", 537, "hostel");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
            out.writeObject(obj);
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
            // System.out.println("some text");
            serialization ref = (serialization) in.readObject();
            System.out.println(ref.address + " " + ref.phone + " " + ref.name);

            out.close();
            in.close();
        } catch (IOException e) {
            System.out.println("Exception IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception class not found");
        }
    }
}
