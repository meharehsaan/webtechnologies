
class GenericException
{
	static int num = 34, den = 2;
	static int quot = 0;
	
    public static void main (String args[])
    {

       try
           {
            quot = num / den;
	    System.out.println(quot);
       	   }
        catch (Exception obj)
          {
            System.out.println ("Error in the code");
            System.out.println ("Exception:" + obj);
          }
	 
      }
}

