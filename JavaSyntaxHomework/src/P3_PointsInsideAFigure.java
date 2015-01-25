import java.util.Locale;
import java.util.Scanner;


public class P3_PointsInsideAFigure {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ROOT);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the coordinates of the point:");
		
		float ax = in.nextFloat();
		float ay = in.nextFloat();
		
		if ((ax < 12.5) || (ax > 22.5)){
			System.out.println("Outside");
		} 
		else if ((ay < 6) || (ay > 13.5)){
			System.out.println("Outside");
		} 
		else if ((ax > 17.5) & (ax < 20)){
			System.out.println("Outside");
		}
		else {
			System.out.println("Inside");
		}
		in.close();
	}
}
