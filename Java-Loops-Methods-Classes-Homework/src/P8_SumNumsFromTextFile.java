import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P8_SumNumsFromTextFile {

    public static void main(String[] args) {
	int sum = 0;
	try (BufferedReader fileReader = new BufferedReader(new FileReader(
		"assets/inputP8.txt"));) {
	    while (true) {
		String line = fileReader.readLine();
		if (line == null) {
		    break;
		}
		sum += Integer.parseInt(line);
	    }
	} catch (IOException e) {
	    System.out.println("Error");
	}
	System.out.println(sum);
    }
}