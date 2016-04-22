package hw.hw9;

import javax.swing.JFrame;

public class StudentView extends JFrame {
	private StudentPanel sp;
	
	public StudentView(){
		setTitle("Student Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(300, 200);
		setSize(500, 200);
		sp = new StudentPanel();
		getContentPane().add(sp);
	    setVisible(true);
	}
	
	public void addHandler(StudentButtonHandler bh) {
	      sp.addHandler(bh);
	}
	
	public void addStudent(Student s){
		sp.addStudent(s);
	}
	
	public int getCurrentStudent(){
		return sp.getCurrentStudent();
	}
	
	public String getCurrentStudentName(){
		return sp.getCurrentStudentName();
	}

}
