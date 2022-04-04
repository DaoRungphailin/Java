package Pro2;
import java.util.*;

public class Pro2_64011258 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter color : ");
        String color = input.next(); 

        System.out.print("Is Triagle filled (true/false)? : ");
        boolean filled = input.nextBoolean();

        boolean sideInput = true;
        while(sideInput){
            System.out.print("Enter three sides of triangle : ");
            double side1 = input.nextDouble();
            double side2 = input.nextDouble();
            double side3 = input.nextDouble();

            try {
                Triangle triangle = new Triangle(side1, side2, side3);
				sideInput = false;	
				
				triangle.setColor(color);
				triangle.setFilled(filled);
		
				System.out.println(triangle.toString());
				System.out.println("Area: " + triangle.getArea());
				System.out.println("Perimeter: " + triangle.getPerimeter());
				System.out.println("Color: " + triangle.getColor());
				System.out.println("Triangle is " + (triangle.IsFilled() ? "" : " not ") 
					+ "filled");
            }
            catch(IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
