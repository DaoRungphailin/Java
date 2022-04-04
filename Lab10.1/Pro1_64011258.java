import java.util.*;

public class Pro1_64011258 {
    public static void main(String[] args) {
         
        Scanner input = new Scanner(System.in);

        //Array of 100 random integers
        int[] array = new int[100];
        for(int i = 0; i < 100 ; i++) {
            array[i] = (int)(Math.random()*100)+1;
        }

        System.out.println("Enter the index of the array: ");
        try{
            System.out.println("The corresponding element value : " + array[input.nextInt()]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Out of Bounds.");
        }
    }
}
