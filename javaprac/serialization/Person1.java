import java.io.*;

//serialization using manual (externalizable)

public class Person1 implements Externalizable {
    private String name;
    private int age;

    public Person1() {
        // Default constructor is required for Externalizable
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    public static void main(String[] args) {
        String filePath = "person.bin";

        // Serialize object
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            Person1 person = new Person1("Mehar", 37);
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize object
        try (ObjectInput in = new ObjectInputStream(new FileInputStream(filePath))) {
            Person1 person = (Person1) in.readObject();
            System.out.println("Name: " + person.name);
            System.out.println("Age: " + person.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
