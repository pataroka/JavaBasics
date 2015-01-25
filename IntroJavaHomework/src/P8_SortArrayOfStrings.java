import java.util.Scanner;


public class P8_SortArrayOfStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		String[] stringArray = new String[a];
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = in.next();
		}
		boolean swapped = true;
		int j = 0;
		String tmp;
		while (swapped) {
		      swapped = false;
		      j++;
		      for (int i = 0; i < stringArray.length - j; i++) {
		    	  int result = stringArray[i].compareToIgnoreCase(stringArray[i + 1]);
		            if (result > 0) {                          
		                  tmp = stringArray[i];
		                  stringArray[i] = stringArray[i + 1];
		                  stringArray[i + 1] = tmp;
		                  swapped = true;
		            }
		      }                
		}
		
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println(stringArray[i]);
		}
		in.close();
	}
}
