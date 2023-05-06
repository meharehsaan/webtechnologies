import java.util.*;

class NumFormExcp
{
    public static void main(String args[ ])
    {

	Scanner in = new Scanner(System.in);

                try{

               String str1 = in.nextLine();   //changing into string 
	       int num1 = Integer.parseInt(str1); // changing into interger

        	System.out.println ("Number :"+ num1);
		   }

		catch(NumberFormatException e){

     //System.out.println("You have problem in data conversion.: " + e);
       System.out.println("Exception Message: " + e.getMessage());
				
				}

	    }

}
