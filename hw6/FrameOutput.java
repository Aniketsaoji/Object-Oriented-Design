package hw.hw6;

import java.util.Collection;
import javax.swing.*;

@SuppressWarnings("serial")
public class FrameOutput extends JFrame implements WeatherOutput {   
	private DisplayPanel pnl;

   public FrameOutput(Collection<WeatherDisplay> displays, String title, ComponentStyler cs) {
	   for (WeatherDisplay wd : displays)
   			wd.setOutput(this);
   		setTitle(title);
   		setDefaultCloseOperation(EXIT_ON_CLOSE);
      pnl = new DisplayPanel(cs);
      setContentPane(pnl);
      pack();
      setVisible(true);
   }
   
   public void display(String s) {
   		pnl.display(s);
   }
}

@SuppressWarnings("serial")
class DisplayPanel extends JPanel {
	private ComponentStyler cs;
   public JTextArea info;
	   
	   public DisplayPanel(ComponentStyler cs) {
		   this.cs = cs;
		   info = cs.createJTextArea(40, 30);
	   		add(info); 
	   }
	   
	   public void display(String s) {
	   		info.append(s + "\n");
	   }
}
