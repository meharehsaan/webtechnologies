class NewThread implements Runnable
 {
	String t_name;     //holds the thread name
	Thread t;      //holds the threa information


	//parameterized constructor
	NewThread(String t_name)
	{
 	 this.t_name = t_name; 

 	 t = new Thread(this, t_name);

	 System.out.println("New thread: " + t);

	 t.start();
	}

	public void run()
	{
	try
	 {
 	  for(int i=0; i<5; i++)
	   {
 	    System.out.println("Thread " + t_name + " : " + i);
 	    Thread.sleep(500);
	   }
 	 }
	catch(InterruptedException e)
	 {
	  System.out.println("Child thread interrupted " + e.getMessage());
	 }
	System.out.println("Thread "+ t_name + " Exiting");
 	}
}

class MultipleThreads
{

public static void main(String args[])
{

 NewThread t1 = new NewThread("One");
 NewThread t2 = new NewThread("Two");
 NewThread t3 = new NewThread("Three");

 	try
 	{
 	   Thread.sleep(10000);
	}
 catch(InterruptedException e)
 {
 	System.out.println("Main interrupted " + e.getMessage());
 }
System.out.println("Main Exiting");

 }
}
