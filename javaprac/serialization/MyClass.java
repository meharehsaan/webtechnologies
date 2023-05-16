import java.io.*;

public class MyClass implements Externalizable {
    private String name;
    private int age;

    public MyClass() {
    }

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Serialize the data members
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Deserialize the data members
        name = (String) in.readObject();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyClass obj = new MyClass("Ehsaan", 21);

        FileOutputStream fos = new FileOutputStream("data.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Write the object to the file
        oos.writeObject(obj);
        System.out.println("Object written to file.");

        FileInputStream fis = new FileInputStream("data.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Read the object from the file
        MyClass newObj = (MyClass) ois.readObject();
        System.out.println("Object read from file: " + newObj);

        fis.close();
        fos.close();
        oos.close();
        ois.close();

    }
}
