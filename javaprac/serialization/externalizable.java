import java.io.*;
import java.util.*;

public class externalizable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        // Create a HashMap to store the Person objects
        Map<String, Person> map = new HashMap<>();

        // Create a Person object
        Person p1 = new Person("John", 30, "Male", "john@example.com");
        System.out.println("Before serialization: " + p1);

        // Save the Person object in the HashMap
        map.put("person1", p1);

        // Serialize the HashMap
        FileOutputStream fos = new FileOutputStream("person.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(map);
        oos.close();

        // Deserialize the HashMap
        FileInputStream fis = new FileInputStream("person.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Map<String, Person> map2 = (Map<String, Person>) ois.readObject();
        ois.close();

        // Retrieve the Person object from the HashMap
        Person p2 = map2.get("person1");
        System.out.println("After deserialization: " + p2);
    }
}



class Person implements Externalizable {

    private String name;
    private int age;
    private String gender;
    private String email;

    public Person() {}

    public Person(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(email);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        email = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email + "]";
    }
}
