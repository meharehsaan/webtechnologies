
class excep
{
    public static void main(String args[])
    {
        try {
            int array[] = new int[100];
            array[100] = 100;
	    System.out.println("Hello world");
        } 


	catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("exception: AIOB");
         }

 	catch (Exception ex) {
            System.out.println("Parent Exception");
          }





	
    }
}

