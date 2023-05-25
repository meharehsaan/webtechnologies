
class base {
    public void foo(){
        System.out.println("Base");
    }    
}

class Derived extends base{
    public void foo(){
        System.out.println("Derived");
    }
}

public class error{
    public static void main(String[] args) {
        System.out.println(fun());
    }
    int fun(){
        System.out.println("Hello");
    }
}


