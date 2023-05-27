import java.io.*;
import java.util.*;

class Employee {
	int id;
	String name;
	static double salary;
	String rank;

	public Employee(int id, String name, double salary, String rank){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rank = rank;
	}

	public void print(){
		System.out.println("Object Contents = " + id + " :: " + name + " :: " + salary + " :: " + rank);
	}
}

public class Driver{
	public ArrayList<Employee> emp;

        public Driver() {
                emp = new ArrayList<Employee>();
        }
	
	public void addEmp(){
		Scanner in = new Scanner(System.in);
                System.out.println("Enter id :: ");
                int id = in.nextInt();
      		in.nextLine();   // giving /n
                System.out.println("Enter name :: ");
                String name = in.nextLine();
                System.out.println("Enter salary :: ");
                double salary = in.nextDouble();
		in.nextLine();   // giving /n
                System.out.println("Enter rank :: ");
                String rank = in.nextLine();

		Employee e = new Employee(id, name, salary, rank);
		e.print();
		emp.add(e);
		System.out.println("Record added successfully");
	}

	public void readCSV(){
		 try{
			Scanner in = new Scanner(new File("EmployeeData.csv"));
            		while (in.hasNextLine()) {
                		String[] row = in.nextLine().split(",");
                		int id = Integer.parseInt(row[0].trim());
                		String name = row[1].trim();
                		double salary = Double.parseDouble(row[2].trim());
                		String rank = row[3].trim();
                		emp.add(new Employee(id, name, salary, rank));
            	}
            	System.out.println("Data loaded successfully!");
        	} catch (FileNotFoundException e) {
            		System.out.println("File not found");
        	}
	}

	public void writeTXT(){
		 try {
			FileWriter fw = new FileWriter("file.txt");
			 PrintWriter pw = new PrintWriter(fw);
            		for (Employee em : emp) {
                		pw.println("ID: " + em.id + "\tName: " + em.name + "\tSalary: " + em.salary + "\tRank: " + em.rank);
				//System.out.println("file");
            		}
			fw.close();
			pw.close();
        	} catch (IOException e) {
            		System.out.println("File Not Found");
        	}
		System.out.println("Data written successfully!");
	}

	public void removeEmployee(int id) {
        	for (Employee em : emp) {
            		if (em.id == id) {
                		emp.remove(em);
                		System.out.println("Removed Employed having ID :: " + id);
				return;
            		}
			
        	}
        	System.out.println("Cannot Find employee with ID :: " + id);
    	}

	public static void main(String[] args){

		Driver obj = new Driver();
		Scanner in = new Scanner(System.in);

		while (true) {
                        System.out.println("Choose an option :: ");
                        System.out.println("1.  Add customer");
                        System.out.println("2.  Remove customer");
			System.out.println("3.  Read CSV and Write TXT");
                        System.out.println("4.  Exit program \n");
                        System.out.print("Enter your choice :: ");

                        int option = in.nextInt();
                        switch (option) {

                                case 1:
					obj.addEmp();
					obj.writeTXT();
					//System.out.println("hello control");
					break;
					
				case 2:
					System.out.println("Enter ID :: ");
                                        int id = in.nextInt();
					obj.removeEmployee(id);
					break;

				case 3:
					obj.readCSV();
					obj.writeTXT();
					break;

				case 4:
					System.exit(0);

				default:
					System.out.println("Invalid Choice!\n");
			}
		}
	}
}
