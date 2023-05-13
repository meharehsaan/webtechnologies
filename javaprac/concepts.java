
// By default, the input in Java is taken as a string.

class some {
    int x = 10;
    long y = x; // implicit casting from int to long

    double z = 3.14159;
    float s = (float) z; // explicit casting from double to float

}

public class GarbageCollectionExample {
    public static void main(String[] args) {
        GarbageCollectionExample obj = new GarbageCollectionExample();

        // Call System.gc() to suggest garbage collection
        System.gc();
    }

    // This method is called by the garbage collector before the object is destroyed
    protected void finalize() {
        System.out.println("Object destroyed.");
    }
}

/*
 * For example, if a double value is cast to an int, the decimal portion of the
 * value will be lost. It is also possible to cast a value to an incompatible
 * data type, which will result in a runtime error. Therefore, it is important
 * to be careful when using type casting in Java.
 */

class B {
    public void getData() {
        System.out.println("Inside getData() of class B");
    }
}

class C extends B {
    public void getData() {
        super.getData(); // Calling getData() of class B using super keyword
        System.out.println("Inside getData() of class C");
    }
}

public class Main {
    public static void main(String[] args) {
        C c = new C();
        c.getData(); // Output: Inside getData() of class B, Inside getData() of class C
    }
}
