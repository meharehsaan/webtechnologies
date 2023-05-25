
class employ{
    String name; 

    public String print(){
        System.out.println("print employ");
        return name;
    }
}

class teacher extends employ{
    String life = " ";

    @Override
    public String print(){
        System.out.println("print teacher");
        return life;
    }

    public void nice(){
        System.out.println("print teacher nice");
        // return "hello";
    }
}

public class Driver{
    public static void main(String[] args) {
        employ b = new teacher();
        b.print();

        teacher n = (teacher) b;

        n.nice();
        
    }
    
}

