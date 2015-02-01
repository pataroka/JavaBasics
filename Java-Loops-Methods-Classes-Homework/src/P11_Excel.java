import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


// For this program to work you need to download Apache POI library. You can do so here
// http://apache.cbox.biz/poi/release/bin/poi-bin-3.11-20141221.zip


public class P11_Excel {

    public static void main(String[] args) throws IOException {

	Locale.setDefault(Locale.ROOT);
	try (FileInputStream input = new FileInputStream("assets/Incomes-Report.xlsx")) {
	    XSSFWorkbook workbook = new XSSFWorkbook(input);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    ArrayList<Office> offices = new ArrayList<>();
	    for (int i = 1; i < 12; i++) {
		XSSFRow currentRow = sheet.getRow(i);
		Office office = new Office(currentRow.getCell(0)
			.getStringCellValue(), currentRow.getCell(5)
			.getNumericCellValue());
		offices.add(office);
	    }
	    ArrayList<Office> officesTotal = new ArrayList<>();
	    for (int i = 0; i < offices.size(); i++) {
		int count = 0;
		for (int j = i + 1; j < offices.size(); j++) {
		    if (offices.get(i).getTown()
			    .equals(offices.get(j).getTown())) {
			double total = offices.get(i).getIncome()
				+ offices.get(j).getIncome();
			offices.get(i).setIncome(total);
			officesTotal.add(new Office(offices.get(i).getTown(),
				total));
			offices.remove(offices.get(j));
			j--;
			count++;
		    }
		}
		if (count == 0) {
		    officesTotal.add(new Office(offices.get(i).getTown(),
			    offices.get(i).getIncome()));
		}
	    }
	    for (int i = 0; i < officesTotal.size(); i++) {
		for (int j = i + 1; j < officesTotal.size(); j++) {
		    if (officesTotal.get(i).getTown()
			    .equals(officesTotal.get(j).getTown())) {
			officesTotal.remove(i);
		    }
		}
	    }
	    double grantTotal = 0.0;
	    for (Office office : officesTotal) {
		grantTotal += office.getIncome();
	    }
	    Collections.sort(officesTotal);
	    for (Office office : officesTotal) {
		System.out.printf("%s Total -> %.2f\n", office.getTown(),
			office.getIncome());
	    }
	    System.out.printf("Grand Total -> %.2f", grantTotal);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}