import java.util.Scanner;


public class P6_SumTwoNumbers {

	public static void main(String[] args) {
		System.out.println("Enter number a:");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		System.out.println("Enter number b:");
		int b = in.nextInt();
		System.out.println(a + b);
		in.close();
	}
}
