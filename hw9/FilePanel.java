package hw.hw9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FilePanel extends JPanel{
	private JButton btn1 = new JButton("SAVE AND EXIT");
	
	public FilePanel(){
		JPanel p1 = new JPanel();
		p1.add(btn1);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(p1);
		
	}
	
	public void addHandler(final FileButtonHandler bh){
		btn1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                 try {
					bh.buttonPressed();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              }
		});
	}
		
}
