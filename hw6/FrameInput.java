package hw.hw6;

import javax.swing.*;

public class FrameInput implements WeatherInput {
	private WeatherMgr mgr;
	private ComponentStyler cs;

	public FrameInput(WeatherMgr mgr, ComponentStyler cs) {
		this.mgr = mgr;
		this.cs = cs;
	}

	public void run() {
		new CmdFrame(mgr, cs);
	}
}

@SuppressWarnings("serial")
class CmdFrame extends JFrame {
	private ComponentStyler cs;
	public CmdFrame(WeatherMgr mgr, ComponentStyler cs) {
		super("Manage Weather Input");
		this.cs = cs;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new CmdPanel(mgr));
		pack();
		setVisible(true);
	}

	class CmdPanel extends JPanel {
		public JTextField city = cs.createJTextField(8);
		public JTextField temp = cs.createJTextField(8);
		public JTextField humidity = cs.createJTextField(8);
		public JTextField pressure = cs.createJTextField(8);
		public JButton btn = cs.createJButton("NEW MEASUREMENT");

		public CmdPanel(WeatherMgr mgr) {
			JPanel p1 = new JPanel();
			p1.add(cs.createJLabel("City:"));
			p1.add(city);
			JPanel p2 = new JPanel();
			p2.add(cs.createJLabel("Temp:"));
			p2.add(temp);
			JPanel p3 = new JPanel();
			p3.add(cs.createJLabel("Pressure:"));
			p3.add(pressure);
			JPanel p4 = new JPanel();
			p4.add(cs.createJLabel("Humidity:"));
			p4.add(humidity);
			JPanel p5 = new JPanel();
			p5.add(btn);
			add(p1); add(p2); add(p3); add(p4); add(p5);

			btn.addActionListener((evt) -> {
				float stemp  = Float.parseFloat(temp.getText());
				float shumid = Float.parseFloat(humidity.getText());
				float spress = Float.parseFloat(pressure.getText());
				mgr.newMeasurement(city.getText(), stemp, shumid, spress);
			});			
		}
	}
}
