import java.util.Scanner;


public class P6_FormattingNumbers {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a:");
		int a = in.nextInt();
		
		System.out.println("Enter b:");
		float b = in.nextFloat();
		
		System.out.println("Enter c:");
		float c = in.nextFloat();
		
		char sep = '|';
		
		String hex = Integer.toHexString(a);
		hex = hex.toUpperCase();
		
		String bin = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');
		

		System.out.printf("%1$c%2$-10s%1$c%3$s%1$c%4$10.2f%1$c%5$-10.3f%1$c",sep,hex,bin,b,c);
		
		in.close();

	}

}
