import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class P9_ListOfProducts {

	public static void main(String[] args) throws Exception {
		 ArrayList<Product> products = new ArrayList<Product>();
         BufferedReader reader;
         BufferedWriter writer = null;
         try {
             reader = new BufferedReader(new FileReader("assets/inputP9.txt"));
             String line = null;
             while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                products.add(new Product(splittedLine[0], Double.parseDouble(splittedLine[1])));
             }
             Collections.sort(products);
            
             writer = new BufferedWriter(new FileWriter("assets/output.txt"));
             for(Product product : products){
                     writer.write(product.getPrice() + " " + product.getName() + "\r\n");
             }
             writer.close();
         }
         catch (Exception e) {
                 System.out.println("Error");
         }
	}

}