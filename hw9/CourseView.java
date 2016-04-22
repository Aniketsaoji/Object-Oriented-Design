package hw.hw9;

import javax.swing.JFrame;

public class CourseView extends JFrame{
	private CoursePanel cp;
	
	public CourseView(){
		setTitle("Course Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(900, 200);
		setSize(500, 200);
		cp = new CoursePanel();
		getContentPane().add(cp);
	    setVisible(true);
	}
	
	public void addHandler(CourseButtonHandler ch){
		cp.addHandler(ch);
	}
	
	public void addCourse(Course c){
		cp.addCourse(c);
	}
	
	public String getCurrentCourse(){
		return cp.getCurrentCourse();
	}

}
