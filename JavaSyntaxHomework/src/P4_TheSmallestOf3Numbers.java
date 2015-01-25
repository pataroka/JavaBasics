import java.util.Scanner;


public class P4_TheSmallestOf3Numbers {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number a:");
		double a = in.nextDouble();
		
		System.out.println("Enter number b:");
		double b = in.nextDouble();
		
		System.out.println("Enter number c:");
		double c = in.nextDouble();
		
		if (a < b) {
			if (a < c){
				System.out.println("The smallest number is: " + a);
			}
			else {
				System.out.println("The smallest number is: " + c);
			}
		}
		else if (b < c){
			System.out.println("The smallest number is: " + b);
		}
		else {
			System.out.println("The smallest number is: " + c);
		}
		in.close();
	}

}
