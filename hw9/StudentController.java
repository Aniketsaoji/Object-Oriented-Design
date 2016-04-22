package hw.hw9;

public class StudentController implements StudentObserver, StudentButtonHandler{
	private StudentCourseModel model;
	private StudentView view;

	public StudentController(StudentCourseModel model, StudentView sv) {
		this.model = model;
		this.view = sv;
		model.addStudentObserver(this);
		view.addHandler(this);
		//model.openSave();
	}

	public void buttonPressed(String name, int GradYear) {
		model.addStudent(name, GradYear);
	}

	public void update(Student s) {
		view.addStudent(s);
	}
	
	public int getCurrentStudent(){
		return view.getCurrentStudent();
	}
	
	public String getCurrentStudentName(){
		return view.getCurrentStudentName();
	}
	

}
