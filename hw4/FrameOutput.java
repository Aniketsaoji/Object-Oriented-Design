package hw.hw4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FrameOutput implements WeatherOutput{
	
	public FrameOutput(Collection<WeatherDisplay> observers, String title) {
		for(WeatherDisplay wd : observers){
			wd.setOutputStrategy(this);
		}
	}
	public void display(String output) {
		GUIFrame6 frame = new GUIFrame6(output);
		frame.pack();
	}

}

@SuppressWarnings("serial")
class GUIFrame6 extends JFrame {
   private GUIPanel6 panel;
   private String output;
   
   public GUIFrame6(String output) {
	   this.output = output;
      setTitle("Frame Output");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(200,200);
      panel = new GUIPanel6(output);
      setContentPane(panel);
      setVisible(true);
   }
}

@SuppressWarnings("serial")
class GUIPanel6 extends JPanel {

   private JTextArea area = new JTextArea(10,35);
   private String output;

   
   public GUIPanel6(String output) {
	   this.output = output;
      JScrollPane areasp = new JScrollPane(area);
      
      areasp.setBorder(new LineBorder(Color.green));
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(areasp);
      area.append(output);
      
      // new for version 5
   
   }
}  