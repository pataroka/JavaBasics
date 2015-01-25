import java.util.Scanner;


public class P1_RectangleArea {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number a:");
		int a = in.nextInt();
		System.out.println("Enter number b:");
		int b = in.nextInt();
		System.out.println("The area of the rectangle is: " + a * b);
		in.close();
	}

}
