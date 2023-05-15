// import java.util.*;

interface printable {
    void print();
}

abstract class abstract0 {
    public abstract String getName();

    public abstract int getRoll();

    public abstract void simpleprint();

    public void printhello() {
        System.out.println("Hello ");
    }
}

class interfacejava extends abstract0 implements printable {
    String name;
    int roll;

    public interfacejava() {
        name = "Ehsaan";
        roll = 37;
    }

    @Override
    public void simpleprint(){
        System.out.println("Printng to check abstract class func output in interfacejava");
    }

    @Override // interface function
    public void print() {
        System.out.println("Overriding printable class function");
    }

    @Override // abstract class fucntion
    public String getName() {
        return name;
    }

    @Override
    public int getRoll() {
        return roll;
    }
}

class B extends interfacejava {
    @Override // abstract class fucntion
    public String getName() {
        return name;
    }

    // calls upper class function 
    // public void simpleprint(){
    //     System.out.println("Printng to check abstract class func output in class B");
    // }

    @Override
    public int getRoll() {
        return roll;
    }
}

public class interfaceprac {
    public static void main(String[] args) {
        interfacejava obj = new interfacejava();
        // abstract0 obj = new abstract0(); // cannot create abstract class object
        abstract0 obj1 = new B();

        System.out.println("obj getting data = " + obj.getName() + " " + obj.getRoll());
        obj.print();

        System.out.println("Obj1 getting data" + obj1.getName() + " " + obj1.getRoll());
        obj1.printhello();
        obj1.simpleprint();

    }

}