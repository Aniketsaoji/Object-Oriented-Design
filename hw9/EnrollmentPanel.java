package hw.hw9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EnrollmentPanel extends JPanel{
	private JButton btn1 = new JButton("ADD");
	private JButton btn2 = new JButton("DROP");
	private JButton btn3 = new JButton("SELECT STUDENT");
	private DefaultTableModel m1 = new DefaultTableModel();
	private JTable t1 = new JTable(m1);
	
	public EnrollmentPanel(){
		String[] columnnames = new String[] {"Course", "Title"};
		m1.setColumnIdentifiers(columnnames);
		t1.setPreferredScrollableViewportSize(new Dimension(300, 100));
		JScrollPane sp1 = new JScrollPane(t1);
		
		add(sp1); add(btn1); add(btn2); add(btn3);
	}
	
	public void showStudentInfo(List<Course> alist){
		if(!alist.isEmpty()){
			Course c = alist.get(alist.size()-1);
			m1.addRow(new Object[]{c.getCode(), c.getTitle()});	
			m1.fireTableDataChanged();
		}
	}
	
	public void showStudentInfoRemove(int row){
		m1.removeRow(row);	
		m1.fireTableDataChanged();
	}
	
	public void addHandler(final EnrollmentButtonHandler bh){
		btn3.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                 bh.buttonSelectPressed();
              }
		});
		
		btn2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                bh.buttonDropPressed();
             }
		});
		
		btn1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                bh.buttonAddPressed();
             }
		});
	}
	
	public String getCurrentCourse(){
		int row = t1.getSelectedRow();
		String course = m1.getValueAt(row, 0).toString();
		return course;
	}

}
