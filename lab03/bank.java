import java.util.*;

public class bank {
	public ArrayList<customer> cust;

	public bank() {
		cust = new ArrayList<customer>();
	}

	public void addCustomer()
			throws invalidAgeException, lowBalanceException, duplicateCustomerException, invalidCustomerIDException {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter name :: ");
		String name = in.nextLine();
		System.out.println("Enter id :: ");
		String id = in.nextLine();

		System.out.println("Enter age :: ");
		int age = in.nextInt();
		if (age < 18 && age > 65) {
			throw new invalidAgeException();
		}

		System.out.println("Enter balance :: ");
		double balance = in.nextDouble();
		if (balance == 0) {
			throw new lowBalanceException();
		}

		// customer obj
		customer p = new customer(name, id, age, balance);
		if (searchCustomer(id) == true) {
			throw new duplicateCustomerException();
		} else {
			if (cust.add(p)) {
				System.out.println("Record added successfully\n");
			}
		}
	}

	public boolean searchCustomer(String id) {
		for (int i = 0; i < cust.size(); i++) {
			customer p = (customer) cust.get(i);
			if (p.getId().equals(id)) {
				System.out.println("Customer exists\n");
				p.print();
				return true;
			}
		}
		return false;
	}

	// main
	public static void main(String[] args) {

		bank ab = new bank();
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("Choose an option :: ");
			System.out.println("1.  Add customer");
			System.out.println("2.  Search customer");
			System.out.println("3.  Exit program \n");
			System.out.print("Enter your choice :: ");

			int option = in.nextInt();
			switch (option) {

				case 1:
					try {
						ab.addCustomer();
					} catch (invalidAgeException e) {
						System.out.println("Error: " + e.toString());
						System.exit(1);
					} catch (lowBalanceException e) {
						System.out.println("Error: " + e.toString());
						System.exit(1);
					} catch (invalidCustomerIDException e) {
						System.out.println("Error: " + e.toString());
						System.exit(1);
					} catch (duplicateCustomerException e) {
						System.out.println("Error " + e.toString());
					}
					break;

				case 2:
					boolean result = false;
					System.out.print("Enter Id : ");
					Scanner sc = new Scanner(System.in);
					String idx = sc.nextLine();
					result = ab.searchCustomer(idx);
					if (result == false) {
						System.out.println("Does not exists\n");
					}
					break;

				case 3:
					System.exit(0);
				default:
					System.out.println("Invalid choice!\n");
			}
		}
	}
}

class duplicateCustomerException extends Exception {
	@Override
	public String toString() {
		return "NewException duplicateCustomer ";
	}
}

class lowBalanceException extends Exception {
	@Override
	public String toString() {
		return "NewException lowBalance ";
	}
}

class invalidCustomerIDException extends Exception {
	@Override
	public String toString() {
		return "NewException invalidCustomer ";
	}
}

class invalidAgeException extends Exception {
	@Override
	public String toString() {
		return "NewException invalidIndex ";
	}
}

class customer {

	String name;
	String id;
	int age;
	double balance;

	// parametrazied.... constructor....
	public customer(String name, String id, int age, double balance) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void print(){
	
		System.out.println("Customer Information");

		System.out.println("Name = " + name);
		System.out.println("ID = " + id);
		System.out.println("Age = " + age);
		System.out.println("Balance = " + balance + "\n");
	}
}
