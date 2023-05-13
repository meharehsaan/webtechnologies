// This file contains rough java codes having core java concepts


// By default, the input in Java is taken as a string. (System.in)


//implicit and explicit casting
class some {
    int x = 10;
    long y = x; // implicit casting from int to long

    double z = 3.14159;
    float s = (float) z; // explicit casting from double to float

}


// garbage collector
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



//casting
/*
 * For example, if a double value is cast to an int, the decimal portion of the
 * value will be lost. It is also possible to cast a value to an incompatible
 * data type, which will result in a run time error. Therefore, it is important
 * to be careful when using type casting in Java.
 */


// super keyword
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


// Did private or static methods maked abstract or not?

// Private methods and static methods are not inherited by subclasses, so making them abstract would not make sense. Abstract methods are meant to be implemented by subclasses, but if they are private or static, they cannot be overridden by subclasses.
// Abstract classes are designed to be inherited by other classes and provide a base for subclasses to extend or specialize. They can contain method implementations that are shared by all the subclasses, or they can provide default implementations that can be overridden by subclasses.
