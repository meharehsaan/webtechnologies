import java.sql.*;
import java.util.*;

class addressBook{

	Connection con = null;
	Statement st = null;
	
	public addressBook(){
		try{
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		String url = "jdbc:mysql://127.0.0.1:3306/mydata";
		    	con = DriverManager.getConnection(url,"root","root");
		    	st = con.createStatement();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("Occurs Exception in constructor" + e);
		}
	}

	public void addPerson() throws SQLException{
		//Statement st = con.createStatement();

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Name :: ");
		String name = in.nextLine();

		System.out.println("Enter Address :: ");
		String add = in.nextLine();

		System.out.println("Enter Phone Number :: ");
		int phone = in.nextInt();
		
		String query="insert into info(username,address,phone) values('"+name+"', '"+add+"', "+phone+")";

		int rs = st.executeUpdate(query);

	     	if(rs > 0){
		    System.out.println("Record inserted successfully.");
	  	}
		else{
    	 		System.out.println("Record could not inserted.");
         	}
	}

	public void searchPerson() throws SQLException{
		Scanner in = new Scanner(System.in);
	
		System.out.print("Please enter Name to search: ");
		String name = in.nextLine();
    
     		String query="Select * from info where username='"+name+"' ";
	        ResultSet rs = st.executeQuery(query);
   
    		if(rs.next()){
	    		String name1 = rs.getString("username");
  			System.out.println("Name: exits which is "+ name1);
	  	}
     		else{
    	 		System.out.println("No record found");
         	}
	}

	public void deletePerson() throws Exception{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter Name to search: ");
		String name = in.nextLine();

     		//String query="Select * from info where username='"+name+"' ";
     		//ResultSet rs = st.executeQuery(query);
		//String dbname = rs.getString("username");
		if(1==1){
			String query1 = "DELETE FROM info where username = '"+name+"' ";
			int rs1 = st.executeUpdate(query1);
			if(rs1 > 0){
				System.out.println("Deleted Record Sucessfully");
			}else{
				System.out.println("Error deleting record");
			}
		}
		else{
			System.out.println("Record does not exist");
		}

	}

	public static void main(String[] args) throws Exception {
		
		addressBook obj = new addressBook();
		Scanner in = new Scanner(System.in);

		while (true) {
                        System.out.println("Choose an option :: ");
                        System.out.println("1.  Add Person");
                        System.out.println("2.  Search Person");
			System.out.println("3.  Remove Person");
                        System.out.println("4.  Exit program \n");
                        System.out.print("Enter your choice :: ");

                        int option = in.nextInt();
                        switch (option) {

                                case 1:
					obj.addPerson();
					break;
					
				case 2:
					obj.searchPerson();
					break;

				case 3:
					obj.deletePerson();
					break;

				case 4:
					System.exit(0);

				default:
					System.out.println("Invalid Choice!\n");
			}
		}
	
	}

}
