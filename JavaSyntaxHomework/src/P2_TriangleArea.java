import java.util.Scanner;


public class P2_TriangleArea {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the coordinates of side a:");
		int ax = in.nextInt();
		int ay = in.nextInt();
		System.out.println("Enter the coordinates of side b:");
		int bx = in.nextInt();
		int by = in.nextInt();
		System.out.println("Enter the coordinates of side c:");
		int cx = in.nextInt();
		int cy = in.nextInt();
		int area = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2;
		System.out.println("The area of the triangle is: " + Math.abs(area));
		in.close();

	}

}
