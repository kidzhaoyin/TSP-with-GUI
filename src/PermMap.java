//Yin Zhao
//yz2426
//the class to draw map for BOTH algorithms

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;


public class PermMap extends JComponent{

	
	private ArrayList<RandomCity.City> path;
	private static final int AXES_OFFSET=50;
	
	public PermMap(ArrayList<RandomCity.City> p,int n){
		path=p;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.blue);
		//case of a single city
		if(path.size()==1){
			RandomCity.City c=path.get(0);
			g2.fillOval(xConverter(c.x)-5, yConverter(c.y)-5, 10, 10);
		}
		//general cases
		else{
			RandomCity.City a=path.get(0);
			RandomCity.City b=path.get(1);
			for(int i=0;i<path.size();i++){
			
				g2.fillOval(xConverter(a.x)-5, yConverter(a.y)-5, 10, 10);
				g2.drawString("("+a.x+","+a.y+")",xConverter(a.x)-50, yConverter(a.y)-9);
				g2.drawLine(xConverter(a.x),yConverter(a.y),xConverter(b.x),yConverter(b.y));
				a=b;
				b=path.get(i);
			}
		
			g2.fillOval(xConverter(a.x)-5, yConverter(a.y)-5, 10, 10);
			g2.fillOval(xConverter(b.x)-5, yConverter(b.y)-5, 10, 10);
			g2.drawString("("+a.x+","+a.y+")",xConverter(a.x)-50, yConverter(a.y)-9);
			g2.drawString("("+b.x+","+a.y+")",xConverter(b.x)-50, yConverter(b.y)-9);
			g2.drawLine(xConverter(a.x),yConverter(a.y),xConverter(b.x),yConverter(b.y));
		}
		
	}
	//method to convert x coordinate to fit frame
	private int xConverter(double x){
		return (int)((getWidth()-2*AXES_OFFSET)*(x/(double)1)+AXES_OFFSET);	
	}
	//method to convert y coordinate to fit frame
	private int yConverter(double y){
		return (int)((getHeight()-2*AXES_OFFSET)*(y/(double)1)+AXES_OFFSET);
	}
		
	
}
