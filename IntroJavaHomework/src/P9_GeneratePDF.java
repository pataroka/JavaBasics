import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
 
public class P9_GeneratePDF {
       
        public static void main(String[] args) {
                try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream("CardDeck.pdf"));                      
                        document.open();
                                              
                        BaseFont baseFont = BaseFont.createFont("fonts/arial.ttf", BaseFont.IDENTITY_H, true);
                        Font black = new Font(baseFont, 60f, 0, BaseColor.BLACK);
                        Font red = new Font(baseFont, 60f, 0, BaseColor.RED);
                        Font color = black;
                        
                        String face = "";
                        char suit = ' ';
                        
                        Paragraph card = new Paragraph();
                        
                        PdfPTable table = new PdfPTable(4);
                        table.setWidthPercentage(100);     
                       
                        for (int i = 2; i <= 14; i++) {
                                switch (i) {
                                case 10: face = "10"; break;
                                case 11: face = " J"; break;
                                case 12: face = " Q"; break;
                                case 13: face = " K"; break;
                                case 14: face = " A"; break;
                                default: face = " " + i; break;
                                }
                                for (int j = 1; j <= 4; j++) {
                                        switch (j) {
                                        case 1: suit = '♣';  color = black; break;
                                        case 2: suit = '♦';  color = red; break;
                                        case 3: suit = '♠';  color = black; break;
                                        case 4: suit = '♥';  color = red; break;
                                        }
                                        card = new Paragraph(face + suit, color);
                                        
                                        PdfPCell cell = new PdfPCell();
                                        cell.setMinimumHeight(140);
                                        cell.setVerticalAlignment(Element.ALIGN_CENTER);
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        cell.addElement(card);
                                        
                                        table.addCell(cell);
                                }
                        }
                        document.add(table);
                        document.close();                      
                }
                catch (Exception e) {
                        e.printStackTrace();
                }
        } 
}