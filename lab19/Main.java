package lab19;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		for(int i = 0; i < 3; i++) {
		   Scanner choose = new Scanner(System.in);
		   System.out.println("Enter the number of sides of the shape. 1 for circle, 3 for triangle, or 4 for rectangle: ");
		   int choice = choose.nextInt();
		   if (choice == 1){
		       Scanner centerX = new Scanner(System.in);
		       System.out.println("Where is the x coordinate of the center of the circle located?");
		       double x = centerX.nextDouble();
		       centerX.close();
		       
		       Scanner centerY = new Scanner(System.in);
		       System.out.println("Where is the y coordinate of the center of the circle located?");
		       double y = centerY.nextDouble();
		       centerY.close();
		       Scanner r = new Scanner(System.in);
		       System.out.println("What is the radius of the circle?");
		       double radius = r.nextDouble();
		       r.close();
		       shapes[i] = new Circles(radius, new Point(x, y));
		   } else if(choice == 4){
		       Scanner l = new Scanner(System.in);
		       System.out.println("What is the length of the rectangle?");
		       double length = l.nextDouble();
		       l.close();
		       Scanner w = new Scanner(System.in);
		       System.out.println("What is the width of the rectangle?");
		       double width = w.nextDouble();
		       w.close();
		       shapes[i] = new Rectangle(length, width);
		   } else if(choice == 3){
		       Scanner a = new Scanner(System.in);
		       System.out.println("What is the length of side A of the triangle?");
		       double aside = a.nextDouble();
		       a.close();
		       Scanner b = new Scanner(System.in);
		       System.out.println("What is the length of side B of the triangle?");
		       double bside = b.nextDouble();
		       b.close();
		       Scanner c = new Scanner(System.in);
		       System.out.println("What is the length of side B of the triangle?");
		       double cside = c.nextDouble();
		       c.close();
		       Scanner ba = new Scanner(System.in);
		       System.out.println("What is the base of the triangle?");
		       double base = ba.nextDouble();
		       ba.close();
		       Scanner h = new Scanner(System.in);
		       System.out.println("What is the height of the triangle?");
		       double height = h.nextDouble();
		       h.close();
		       shapes[i] = new Triangle(aside, bside, cside,  base, height);
		   }
		}
		
		for(int i = 0; i < 3; i++) {
		      if(shapes[i].getNUMBER_OF_SIDES() == 1){
		          System.out.println(((Circles)shapes[i]).toString() + ", perimeter = " + shapes[i].perimeter() + ", area = " + shapes[i].area());
		        }else if(shapes[i].getNUMBER_OF_SIDES() == 4){
		          System.out.println(((Rectangle)shapes[i]).toString() + ", perimeter = " + shapes[i].perimeter() + ", area = " + shapes[i].area());
		        }else if(shapes[i].getNUMBER_OF_SIDES() == 3){
		          System.out.println(((Triangle)shapes[i]).toString() + ", perimeter = " + shapes[i].perimeter() + ", area = " + shapes[i].area());
		        }
		}
		
		
		
		
	}
}
