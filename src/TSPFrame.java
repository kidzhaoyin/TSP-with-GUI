//Yin Zhao
//yz2426

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TSPFrame extends JFrame{
	private static final int FRAME_WIDTH=600;
	private static final int FRAME_HEIGHT=400;
	
	private JLabel title;
	private JButton perB;
	private JButton nnB;
	private ActionListener listener1;
	private ActionListener listener2;
	private PermMap pm;
	private RandomCity rc;
	private int num;
	
	public TSPFrame(int n){
		num=n;
		rc=new RandomCity(n);
		title=new JLabel("Please choose the way to find path for Traveling Salesman: ");
		add(title,BorderLayout.NORTH);
		
		
		class ChoiceListener1 implements ActionListener{
			public void actionPerformed(ActionEvent event){
				JFrame fr=new JFrame();
				fr.setSize(2000,2000);
				fr.setTitle("Permutation Path");
				PermuteTSP pt=new PermuteTSP(rc.getCities(),num);
				pm=new PermMap(pt.findShortest(),num);
				fr.add(pm);
				fr.setVisible(true);
				fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		}
		listener1=new ChoiceListener1();
		class ChoiceListener2 implements ActionListener{
			public void actionPerformed(ActionEvent event){
				JFrame fr=new JFrame();
				fr.setSize(2000,2000);
				fr.setTitle("Nearest Neighbor Path");
				NearestNeighbor nn=new NearestNeighbor(rc.getCities());
				pm=new PermMap(nn.findBest(),num);
				fr.add(pm);
				fr.setVisible(true);
				fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		listener2=new ChoiceListener2();
		
		add(createButtons());
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
	
	public JPanel createButtons(){
		perB=new JButton("Permutation");
		perB.addActionListener(listener1);
		
		nnB=new JButton("Nearest Neightbor");
		nnB.addActionListener(listener2);
		
		JPanel panel=new JPanel();
		panel.add(perB);
		panel.add(nnB);
	
		return panel;
	}


}
