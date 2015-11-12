//Yin Zhao
//yz2426
//main class. User enters number of cities (less than 7) in console window when prompted
import java.util.Scanner;

import javax.swing.JFrame;


public class TSPTest {

	public static void main(String[] args) {

		int n;
		System.out.println("Please enter number of cities: integer between 1 and 7");
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		if(n < 1 || n > 7) {
			System.out.println("invalid number of cities.");
		}
		
		else{
			
			JFrame frame = new TSPFrame(n);
			frame.setTitle("Traveling Salesman Path");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		
		}
		scan.close();
	}

}
