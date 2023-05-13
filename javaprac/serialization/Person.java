// serialization is implemented in which we are saving the state of the ph and balance 
// variable when sharing obj to others and someone else.

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient String ph;    	  // marked as transient
    private transient double balance;    // marked as transient
    
    public Person(String name, int age, String ph, double balance) {
        this.name = name;
        this.age = age;
        this.ph = ph;
        this.balance = balance;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getPh() {    // added getter for ph
        return ph;
    }
    
    public double getBalance() {    // added getter for balance
        return balance;
    }
    
    public static void main(String[] args) {
        Person person = new Person("Mehar", 37, "1234567890", 1000.0);
        
        try {
            // Serialization
            FileOutputStream fileOut = new FileOutputStream("person.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            
            // Deserialization
            FileInputStream fileIn = new FileInputStream("person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            
            System.out.println("Original person: " + person.getName() + ", " + person.getAge() + ", " + person.getPh() + ", " + person.getBalance());
            System.out.println("Deserialized person: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge() + ", " + deserializedPerson.getPh() + ", " + deserializedPerson.getBalance());
        } catch(IOException e) {
            e.toString();
        } catch(ClassNotFoundException e) {
            e.toString();
        }
    }
}

