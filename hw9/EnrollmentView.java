package hw.hw9;

import java.util.List;

import javax.swing.JFrame;

public class EnrollmentView extends JFrame{
	private EnrollmentPanel ep;
	private String username = "";
	
	public EnrollmentView(){
		setTitle("Enrollment" + username);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(300, 500);
		setSize(500, 200);
		ep = new EnrollmentPanel();
		getContentPane().add(ep);
	    setVisible(true);
	}
	
	public void addHandler(EnrollmentButtonHandler eh) {
	      ep.addHandler(eh);
	}
	
	public void showStudentInfo(List<Course> alist){
		ep.showStudentInfo(alist);
	}
	
	public void showStudentInfoRemove(int row){
		ep.showStudentInfoRemove(row);
	}
	
	public void changeName(String name){
		username = "for ";
		username += name;
		this.setTitle("Enrollment " + username);
	}
	
	public String getCurrentCourse(){
		return ep.getCurrentCourse();
	}

}
