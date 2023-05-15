// import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
// import java.util.*;
import javax.swing.JOptionPane;


public class objstream {
    public static void main(String[] args) {
      try {
        PersonInformation info1 = new PersonInformation("ahmad", "ali44", 21);
        PersonInformation info2 = new PersonInformation("Ali ahmad", "alir2", 22);
        
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("data1.txt"));

        // ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
        // PersonInformation read; // = (PersonInformation) ois.readObject();
        ous.writeObject(info1);
        ous.writeObject(info2);
        System.out.println("ObjectOutputstream success");
        // while ((read = (PersonInformation) ois.readObject()) != null) {
        //   read.display();
        // }
        // System.out.println("Objectreadstream success");
        // ois.close();
        
        ous.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }


class PersonInformation implements Serializable {
  String name;
  transient String password;
  static int age;

  public PersonInformation(String name, String password, int age) {
    this.name = name;
    this.password = password;
    PersonInformation.age = age;
  }

  public void display() {
    JOptionPane.showMessageDialog(null, "name: " + name + " password:" + password + " age:" + age);
  }
}

