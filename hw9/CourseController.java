package hw.hw9;

public class CourseController implements CourseObserver, CourseButtonHandler{
	private StudentCourseModel model;
	private CourseView view;

	public CourseController(StudentCourseModel model, CourseView cv) {
		this.model = model;
		this.view = cv;
		model.addCourseObserver(this);
		view.addHandler(this);
	}
	
	public void update(Course c) {
		view.addCourse(c);
	}

	public void buttonPressed(String code, String title) {
		model.addCourse(code, title);
	}
	
	public String getCurrentCourse(){
		return view.getCurrentCourse();
	}

}
