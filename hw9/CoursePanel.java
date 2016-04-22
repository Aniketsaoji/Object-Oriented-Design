package hw.hw9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CoursePanel extends JPanel{
	private JButton btn1 = new JButton("NEW COURSE");
	private JTextField area1 = new JTextField("code", 5);
	private JTextField area2 = new JTextField("title", 5);
	private DefaultTableModel m1 = new DefaultTableModel();
	private JTable t1 = new JTable(m1);
	
	public CoursePanel(){
		String[] columnnames = new String[] {"Code", "Title",};
		m1.setColumnIdentifiers(columnnames);
		t1.setPreferredScrollableViewportSize(new Dimension(300, 100));
		JScrollPane sp1 = new JScrollPane(t1);
		
		
		add(btn1); add(area1); add(area2); add(sp1);
	}
	
	public void addHandler(final CourseButtonHandler bh){
		btn1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                 bh.buttonPressed(area1.getText(), area2.getText());
              }
		});
	}
	
	public void addCourse(Course c){
		m1.addRow(new Object[]{c.getCode(), c.getTitle()});
		m1.fireTableDataChanged();
	}
	
	public String getCurrentCourse(){
		int row = t1.getSelectedRow();
		String course = m1.getValueAt(row, 0).toString();
		return course;
	}

}
