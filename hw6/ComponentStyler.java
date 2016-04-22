package hw.hw6;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//ComponentStyler is an abstract factory class
// need methods to create a JButton, JLabel, JTextField, and JTextArea.

public class ComponentStyler {
	private Color c1;
	private Color c2;

	public ComponentStyler(Color c1, Color c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public JTextArea createJTextArea(int size, int size2){
		JTextArea j = new JTextArea(40,30);
		j.setBackground(c2);
		j.setOpaque(true);
		j.setBorder(new LineBorder(c1,3));
		return j;
	}
	
	public JTextField createJTextField(int size){
		JTextField j = new JTextField(8);
		j.setBackground(c2);
		j.setOpaque(true);
		j.setBorder(new LineBorder(c1,3));
		return j;
	}
	
	public JButton createJButton(String measurement){
		JButton j = new JButton(measurement);
		j.setBackground(c2);
		j.setOpaque(true);
		j.setBorder(new LineBorder(c1,3));
		return j;
	}
	
	public JLabel createJLabel(String field){
		JLabel j = new JLabel(field);
		j.setForeground(c1);
		return j;
	}

}
