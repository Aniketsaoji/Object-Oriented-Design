package hw.hw9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentPanel extends JPanel{
	private JButton btn1 = new JButton("NEW STUDENT");
	private JTextField area1 = new JTextField("name", 5);
	private JTextField area2 = new JTextField("year", 5);
	private DefaultTableModel m1 = new DefaultTableModel();
	private JTable t1 = new JTable(m1);
	
	public StudentPanel(){
		String[] columnnames = new String[] {"Id", "Name", "GradYear"};
		m1.setColumnIdentifiers(columnnames);
		t1.setPreferredScrollableViewportSize(new Dimension(300, 100));
		JScrollPane sp1 = new JScrollPane(t1);
		
		
		add(btn1); add(area1); add(area2); add(sp1);
	}
	
	public void addHandler(final StudentButtonHandler bh){
		btn1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                 bh.buttonPressed(area1.getText(), Integer.valueOf(area2.getText()));
              }
		});
	}
	
	public void addStudent(Student s){
		m1.addRow(new Object[]{String.valueOf(s.getId()), s.getName(), String.valueOf(s.getGradYear())});
		m1.fireTableDataChanged();
	}
	
	public int getCurrentStudent(){
		int row = t1.getSelectedRow();
		int id = Integer.parseInt(m1.getValueAt(row, 0).toString());
		return id;
	}
	
	public String getCurrentStudentName(){
		int row = t1.getSelectedRow();
		String name = m1.getValueAt(row, 1).toString();
		return name;
	}

}
