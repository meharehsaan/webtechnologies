class Animals{
	void makeSound(){
		System.out.println("Animals make noises");
	}
	void great(){
		System.out.println("animals greate noises");
	}
}

class Cat extends Animals{
	//no function delared in cat class
}

class Dog extends Animals{	
	void makeSound(){
		super.makeSound();
		super.great() //can also call other functions not only overrided;
		System.out.println("Woo Woo");
	}
}

public class Animalsound{
	public static void main(String[] args){
		Animals A = new Animals();
		Cat C = new Cat();
		Dog D = new Dog();

		A.makeSound();
		C.makeSound();
		D.makeSound();
	}
}
