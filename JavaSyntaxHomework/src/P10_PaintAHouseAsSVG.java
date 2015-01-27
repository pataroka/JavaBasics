import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JPanel;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;


public class P10_PaintAHouseAsSVG extends JPanel {
	
	public static int n;
	
	public P10_PaintAHouseAsSVG(ArrayList<String> inputCoordinates){
		this.inputCoordinatesArrayList = inputCoordinates;
	}
	//set array list to store coordinates
	public ArrayList<String> inputCoordinatesArrayList = new ArrayList<String>(); 
	//define house color and opacity
	public Color houseColor = new Color (0.75f, 0.75f, 0.75f, 0.7f); 
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		Graphics2D g2 = (Graphics2D) g;
		int scale = 35;
		
		g2.setStroke(new BasicStroke(3f));
		//draw left side of the house
		Shape leftWall = new Rectangle2D.Double(12.5*scale, 8.5*scale, 5*scale, 5*scale);
		g2.setPaint(houseColor);
		g2.fill(leftWall);
		g2.setPaint(Color.BLUE);
		g2.draw(leftWall);
		//draw right side of the house
		Shape rightWall = new Rectangle2D.Double(20*scale, 8.5*scale, 2.5*scale, 5*scale);
		g2.setPaint(houseColor);
		g2.fill(rightWall);
		g2.setPaint(Color.BLUE);
		g2.draw(rightWall);
		//draw the roof of the house  
		GeneralPath roof = new GeneralPath();
		roof.moveTo(12.5*scale, 8.5*scale);
		roof.lineTo(17.5*scale, 3.5*scale);
		roof.lineTo(22.5*scale, 8.5*scale);
		roof.closePath();
		g2.setPaint(houseColor);
		g2.fill(roof);
		g2.setPaint(Color.BLUE);
		g2.draw(roof);
		//set line shape and color of the coordinate system
		float[] dash = {2f, 3f};
		g.setColor(Color.CYAN);
		BasicStroke bs = new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, dash, 0f);
		g2.setStroke(bs);
		//draw the coordinate system
		double xx1 = 9, yx1 = 10;
		double xx2 = 23.5, yx2 = 10;
		double xy1 = 3.5, yy1 = 2;
		double xy2 = 3.5, yy2 = 17;
		double c = 2.5;
		
		for (int i = 0; i < 6; i++){
			Shape xLine = new Line2D.Double(xx1*scale, xy1*scale, xx2*scale, xy2*scale);
			Shape yLine = new Line2D.Double(yx1*scale, yy1*scale, yx2*scale, yy2*scale);
			g2.draw(xLine);
			g2.draw(yLine);
			xy1 = xy1 + c;
			xy2 = xy2 + c;			
			yx1 = yx1 + c;
			yx2 = yx2 + c;
		}
		//set font of coordinates
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial", Font.PLAIN, 3*scale/4));
		//draw coordinates
		float x = 9.5f;
		float y = 3.75f;
		String[] coordsX = {"10", "12.5", "15", "17.5", "20", "22.5"};
		String[] coordsY = {"3.5", "6", "8.5", "11", "13.5", "16"};
		
		for (int i = 0; i < 6; i++){			
			g2.drawString(coordsX[i], x*scale, 1.5f*scale);
			g2.drawString(coordsY[i], 7.5f*scale, y*scale);
			x = x + 2.5f;
			y = y + 2.5f;
		}
		
		//draw a trademark :)
		g2.setColor(Color.DARK_GRAY);
		g2.setFont(new Font("Arial", Font.PLAIN, scale/4));
		
		String trademark = "Created by pataroka, 2015";
		g2.drawString(trademark, 0.5f*scale, 0.5f*scale);
		
		g2.setStroke(new BasicStroke(2f));
		
		for (String string : inputCoordinatesArrayList){
			
			String[] posPoint = string.split(" ");
			double pointX = Double.parseDouble(posPoint[0]);
			double pointY = Double.parseDouble(posPoint[1]);
			String positionPoint = pointsInsideTheHouse(string);
			
			Shape point = new Ellipse2D.Double(pointX*scale, pointY*scale, scale/3, scale/3);
			
			if (positionPoint.equals("Inside")){
				g2.setPaint(Color.BLACK);
				g2.fill(point);
			}
			else {
				g2.setPaint(Color.LIGHT_GRAY);
				g2.fill(point);
				g2.setPaint(Color.DARK_GRAY);
				g2.draw(point);
			}
		}
	}
		
	public static String pointsInsideTheHouse(String position){
		String[] posPoint = position.split(" ");
		double pointX = Double.parseDouble(posPoint[0]);
		double pointY = Double.parseDouble(posPoint[1]);
		double pos = 0;
		String positionPoint = null;
		
		if ((pointX > 17.5) & (pointX < 20) & (pointY > 8.5)){
			positionPoint = "Outside";
		}
		else {
			for (int i = 1; i <= 5; i++){
				switch (i){
				case 1: pos = (17.5 - 12.5) * (pointY - 8.5) - (3.5 - 8.5) * (pointX - 12.5); break;
				case 2: pos = (22.5 - 17.5) * (pointY - 3.5) - (8.5 - 3.5) * (pointX - 17.5); break;
				case 3: pos = (22.5 - 22.5) * (pointY - 8.5) - (13.5 - 8.5) * (pointX - 22.5); break;
				case 4: pos = (12.5 - 22.5) * (pointY - 13.5) - (13.5 - 13.5) * (pointX - 22.5); break;			
				case 5: pos = (12.5 - 12.5) * (pointY - 13.5) - (8.5 - 13.5) * (pointX - 12.5); break;
				}
				if (pos < 0){
					positionPoint = "Outside"; break;
				}
				else if ((i == 5) & (pos >= 0)){
					positionPoint = "Inside";
				}
			}
		}
		return positionPoint;
	}

	public static void main(String[] args) throws SVGGraphics2DIOException, IOException {
		Locale.setDefault(Locale.ROOT);
		
		ArrayList<String> inputCoordinates = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of points you want to check:");
		n = in.nextInt();
		String ignoredLine = in.nextLine();
		System.out.println("Enter the x and y coordinates of each point on a seperate line:");
		
		for (int i = 0; i < n; i++){
			String inputLine = in.nextLine();
			inputCoordinates.add(inputLine);
		}
		in.close();
		
		
		P10_PaintAHouseAsSVG paintHouse = new P10_PaintAHouseAsSVG(inputCoordinates);
		DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
		String svgNS = "http://www.w3.org/2000/svg";
		Document doc = domImpl.createDocument(svgNS, "html", null);
		SVGGraphics2D svg = new SVGGraphics2D(doc);
		
		Dimension size = new Dimension(1000,1000);
		svg.setSVGCanvasSize(size);
		paintHouse.paintComponent(svg);
		svg.stream(new FileWriter("house.html"), false);
	}

}
