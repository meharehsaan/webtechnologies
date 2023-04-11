class Person {
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  @Override
   public String toString(){
  	return "I am providing custom string";  
  }
}

public class objclasstostring {
  public static void main(String[] args) {
    Person p = new Person("Mehar", 37);
    System.out.println(p.toString());
  }
}

