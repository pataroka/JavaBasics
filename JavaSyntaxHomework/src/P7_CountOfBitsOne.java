import java.util.Scanner;


public class P7_CountOfBitsOne {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a number:");
		int num = in.nextInt();
		
		String bin = Integer.toBinaryString(num);
		
		int count = 0;
		
		for (int i = 0; i < bin.length(); i++ ){
			if (bin.charAt(i) == '1'){
				count++;
			}
		}
		
		System.out.println("There are " + count + " ones in the binary representation of this number.");
				
		in.close();

	}

}
