package hw.hw5;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class BorderTest extends JPanel{
	public BorderTest(){
		super(new GridLayout(1,0));
		//2-colored border
		JPanel pane = new JPanel();
		pane.add(new JLabel("A 2-colored border", JLabel.CENTER));
		Border b1 = new LineBorder(Color.red,3);
		Border b2 = new LineBorder(Color.green,3);
		pane.setBorder(new CompoundBorder(b1, b2));
	    
	    //3-colored border
	    JPanel p2 = new JPanel();
		p2.add(new JLabel("A 3-colored border", JLabel.CENTER));
		Border b1a = new LineBorder(Color.red,3);
		Border b2a = new LineBorder(Color.green,3);
		Border b3a = new LineBorder(Color.blue,3);
		Border first = new CompoundBorder(b1a, b2a);
		Border second = new CompoundBorder(first, b3a);
		p2.setBorder(second);
		
		//A 2-colored border with a title on the outside border:
		JPanel p3 = new JPanel();
		p3.add(new JLabel("A 2-colored border with a title on the outside border", JLabel.CENTER));
		Border b1b = new LineBorder(Color.red,3);
		Border b2b = new LineBorder(Color.green,3);
		Border b3b = new TitledBorder(b2b, "A Title");
		Border firstA = new CompoundBorder(b3b, b1b);
		p3.setBorder(firstA);
		
		
		//A 2-colored border with a title across both borders
		JPanel p4 = new JPanel();
		p4.add(new JLabel("A 2-colored border with a title across both borders", JLabel.CENTER));
		Border b1c = new LineBorder(Color.red,3);
		Border b2c = new LineBorder(Color.green,3);
		Border firstB = new CompoundBorder(b1c, b2c);
		Border b3c = new TitledBorder(firstB, "A Title");
		p4.setBorder(b3c);
		
		//CREATION
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    add(pane);
	    add(p2);
	    add(p3);
	    add(p4);
	    
	}
	
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("BorderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        BorderTest newContentPane = new BorderTest();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
