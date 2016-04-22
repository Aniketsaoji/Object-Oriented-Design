package hw.hw4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

public class FrameInput implements WeatherInput{
	private WeatherMgr mgr;
	private String city;
	private float temperature;
	private float humidity;
	private float pressure;
	private boolean complete = false;
	
	public FrameInput(WeatherMgr mgr){
		this.mgr = mgr;
	}
	
	public void run(){
		//the method should create and display the input frame
		GUIFrame5 frame = new GUIFrame5(this);
		frame.pack();
    	
	}
	public void update(){
		mgr.update(this.city, this.temperature, this.humidity, this.pressure);	
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	

}

@SuppressWarnings("serial")
class GUIFrame5 extends JFrame {
   private GUIPanel5 panel;
   
   public GUIFrame5(FrameInput fi) {
      setTitle("Frame Input");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(200,200);
      panel = new GUIPanel5(fi, this);
      setContentPane(panel);
      setVisible(true);
   }
}

@SuppressWarnings("serial")
class GUIPanel5 extends JPanel {
	
	private FrameInput fi;
	
   private JLabel lbl     = new JLabel("Enter City:");
   private JTextField txt = new JTextField("50", 4);
   
   private JLabel lbl2     = new JLabel("Enter Temperature");
   private JTextField txt2 = new JTextField("50", 4);
   
   private JLabel lbl3     = new JLabel("Enter Humidity");
   private JTextField txt3 = new JTextField("50", 4);
   
   private JLabel lbl4     = new JLabel("Enter Pressure");
   private JTextField txt4 = new JTextField("50", 4);

   private JButton btn2 = new JButton("Enter Submission");
   private GUIFrame5 it;
   
   public GUIPanel5(FrameInput fi, GUIFrame5 it) {
      this.fi = fi;
      this.it = it;
      JPanel p1 = new JPanel();
      p1.add(lbl); p1.add(txt);
      p1.setBorder(new LineBorder(Color.red));
      
      JPanel p2 = new JPanel();
      p2.add(lbl2); p2.add(txt2);
      p2.setBorder(new LineBorder(Color.blue));
      
      JPanel p3 = new JPanel();
      p3.add(lbl3); p3.add(txt3);
      p3.setBorder(new LineBorder(Color.green));
      
      JPanel p4 = new JPanel();
      p4.add(lbl4); p4.add(txt4);
      p4.setBorder(new LineBorder(Color.orange));
      

      
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(p1); add(p2); add(p3); add(p4);
      
      // new for version 5       
      add(btn2);
      btn2.addActionListener(new TextFieldListener(this));  
   }
   
   public void synch(String val, float val2, float val3, float val4) {
	  // added for version 4
      lbl.setText("value is " + val);
      txt.setText("" + val);
      
      lbl2.setText("value is " + val2);
      txt2.setText("" + val2);
      
      lbl3.setText("value is " + val3);
      txt3.setText("" + val3);
      
      lbl4.setText("value is " + val4);
      txt4.setText("" + val4);
      
      fi.setCity(val);
      fi.setTemperature(val2);
      fi.setHumidity(val3);
      fi.setPressure(val4);
      fi.setComplete(true);
      fi.update();
      it.dispose();

   }

   // new for version 5:
   public List<String> getTextFieldValue() {
	   List<String> result = new ArrayList<String>();
	   result.add(txt.getText());
	   result.add(txt2.getText());
	   result.add(txt3.getText());
	   result.add(txt4.getText());
	   
	   
      return result;
   } 
}  

class TextFieldListener implements ActionListener {
   private GUIPanel5 pnl;
   
   public TextFieldListener(GUIPanel5 pnl) {
      this.pnl = pnl;
   }
   
   public void actionPerformed(ActionEvent evt) {
      List<String> s = pnl.getTextFieldValue();
      String val = "";
      float val2 = 0;
      float val3 = 0;
      float val4 = 0;
      try {
         val = s.get(0);
         val2 = Float.parseFloat(s.get(1));
         val3 = Float.parseFloat(s.get(2));
         val4 = Float.parseFloat(s.get(3));
      } catch (NumberFormatException e) {}
      pnl.synch(val, val2, val3, val4);
   }
}
