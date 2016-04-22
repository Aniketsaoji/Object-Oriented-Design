package hw.hw9;

import java.util.List;

public class EnrollmentController implements EnrollmentObserver, EnrollmentButtonHandler{
	private StudentCourseModel model;
	private EnrollmentView view;
	private StudentController sc;
	private CourseController cc;

	public EnrollmentController(StudentCourseModel model, EnrollmentView ev, StudentController sc,
			CourseController cc) {
		this.model = model;
		this.view = ev;
		this.sc = sc;
		this.cc = cc;
		model.addEnrollmentObserver(this);
		view.addHandler(this);
	}
	
	public void update(List<Course> alist){
		view.showStudentInfo(alist);
		String name = sc.getCurrentStudentName();
		view.changeName(name);
	}
	
	public void updateRemove(int row){
		view.showStudentInfoRemove(row);
		String name = sc.getCurrentStudentName();
		view.changeName(name);
	}

	public void buttonSelectPressed() {
		int id = sc.getCurrentStudent();
		model.showCourses(id);
	}

	public void buttonAddPressed() {
		int id = sc.getCurrentStudent();
		String c = cc.getCurrentCourse();
		model.addStudentCourse(c, id);
	}

	public void buttonDropPressed() {
		int id = sc.getCurrentStudent();
		String c = view.getCurrentCourse();
		model.dropStudentCourse(c, id);
	}


}
