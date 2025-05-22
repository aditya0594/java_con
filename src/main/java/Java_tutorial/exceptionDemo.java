package Java_tutorial;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

import java.nio.channels.ScatteringByteChannel;

public class exceptionDemo {
    // one try  can be followed the no of catch
    //catch block immediate block after the try
    //
    public static void main(String[] args) {
        int b = 7;
        int c = 0;
        try {
                //int k = b / c;
                //System.out.println(k);

            int arr[] = new int[5];
            System.out.println(arr[6]);

        }catch (ArithmeticException E){
            System.out.println("Error catch for the arithmetic Exception ");
        }
        catch (IndexOutOfBoundsException ets){
            System.out.println("Error catch for the Index out of bound Exception ");
        }
        catch (Exception e )
            {
                System.out.println("error in ");
            }
        finally {
            System.out.println("This will run if it will run or failed");
        }

        }

    }


