import java.util.Locale;
import java.util.Scanner;


public class P9_PointsInsideTheHouse {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ROOT);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the coordinates of the point:");
		
		double x = in.nextDouble();
		double y = in.nextDouble();
		
		double position = 0;
		
		if ((x > 17.5) & (x < 20) & (y > 8.5)){
			System.out.println("Outside.");
		}
		else {
			for (int i = 1; i <= 5; i++){
				switch (i){
				case 1: position = (17.5 - 12.5) * (y - 8.5) - (3.5 - 8.5) * (x - 12.5); break;
				case 2: position = (22.5 - 17.5) * (y - 3.5) - (8.5 - 3.5) * (x - 17.5); break;
				case 3: position = (22.5 - 22.5) * (y - 8.5) - (13.5 - 8.5) * (x - 22.5); break;
				case 4: position = (12.5 - 22.5) * (y - 13.5) - (13.5 - 13.5) * (x - 22.5); break;			
				case 5: position = (12.5 - 12.5) * (y - 13.5) - (8.5 - 13.5) * (x - 12.5); break;
				}
				if (position < 0){
					System.out.println("Outside."); break;
				}
				else if ((i == 5) & (position >= 0)){
					System.out.println("Inside.");
				}
			}
		}
		in.close();
	}

}
