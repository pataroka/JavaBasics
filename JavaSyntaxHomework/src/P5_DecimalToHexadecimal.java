import java.util.Scanner;


public class P5_DecimalToHexadecimal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a positive integer number:");
		int num = in.nextInt();
		
		String hex = Integer.toHexString(num);
		hex = hex.toUpperCase();
		System.out.println("The hexadecimal value of the number is " + hex);
				
		in.close();

	}

}
