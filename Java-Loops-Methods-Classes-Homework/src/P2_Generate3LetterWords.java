import java.util.Scanner;

public class P2_Generate3LetterWords {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] charArr = in.next().toCharArray();
		for (char first : charArr) {
		    for (char second : charArr) {
				for (char third : charArr) {
				    System.out.printf("%c%c%c ", first, second, third);
				}
		    }
		}
		in.close();
    }
}