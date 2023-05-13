// import java.util.*;
import java.lang.Object;

class A {

    // if not in A toString of Object is called
    @Override
    public String toString() {
        String x = "Hello A ";
        return x;
    }

    public void aprint() {
        System.out.println("Hello i am parent A");

    }
}

class B extends A {

    // if not in B toString of A is called

    @Override
    public String toString() {
        String x = "Hello B";
        return x;
    }

    public void bprint() {
        System.out.println("Hello i am sub parent B");

    }
}

class C extends B {
    public void cprint() {
        System.out.println("Hello i am child parent C");
    }
}

public class inheritanceobj {
    public static void main(String[] args) {
        Object obj = new A();
        
        try{
        ((A) obj).aprint();
        ((B) obj).aprint(); //runtime error not compile time
        String y = obj.toString();
        System.out.println(y);
        }catch(ClassCastException e){
            System.out.println("Exception");
        }
    }
}