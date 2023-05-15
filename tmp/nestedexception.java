
public class nestedexception {
    public static void main(String[] args) {
        try {
            System.out.println("Something wrtitten here.....");
            try {
                // int x = 10, y = 0;
                // int z = x / y;
                // System.out.println(z);
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArithmeticException e) {
                System.out.println("Exception Arithmetic 1" + e);
            }finally{
                System.out.println("finally block excecuted ");
            }

            System.out.println("Something.... written here 2");

        } catch (Exception e) {
            System.out.println("Exception 2" + e);
        }
        System.out.println("something written here at last");

        try{

        }finally{

        }


    }
}
