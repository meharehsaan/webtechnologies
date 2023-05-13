class Person {
    String name;
    int phone;

    Person(){
        name = " ";
        phone = 0;
    }

    Person(String n, int ph){
        name = n;
        phone = ph;
    }

    public String getName(){
        return name;
    }

    public int getphone(){
        return phone;
    }
}

class Teacher extends Person{
    String address;

    public Teacher(){
        super();
        address = " ";
    }

    public Teacher (String n, int ph, String ad){
        super(n, ph);
        address = ad;
    }

    public String getaddress(){
        return address;
    }
}

public class Casting{
    public static void main(String[] args) {
        Person p = new Teacher("Ehsaan", 37, "Hostel");
        // Person p1 = new Person("Mehar", 25);
        Teacher t2 = new Teacher("Ehsaan1", 371, "Hostel1");
        // System.out.println(p.getName()+" "+p.getphone());
        Teacher t = (Teacher) p;   //downcasting 
       Person p2 = t2;             //upcasting

        // t.getName();
        // t.getphone();
        // t.getaddress();
        System.out.println(t.getName()+" "+t.getphone()+" "+t.getaddress());
        System.out.println(p2.getName()+" "+p2.getphone());
    }
}