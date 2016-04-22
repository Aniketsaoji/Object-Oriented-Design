package hw.hw9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * You should create a model that holds all information about students, courses,
 * and enrollments. The model should have appropriate accessor and mutator methods.
 * It should also have methods to save the state to a file and to initialize the state from the file.
 */

public class StudentCourseModel {
	private Collection<StudentObserver> studentobserver = new ArrayList<StudentObserver>();
	private Collection<CourseObserver> courseobserver = new ArrayList<CourseObserver>();
	private Collection<EnrollmentObserver> enrollmentobserver = new ArrayList<EnrollmentObserver>();
	
	private List<Student> thestudents = new ArrayList<Student>();
	private List<Course> thecourses = new ArrayList<Course>();
	
	public void addStudentObserver(StudentObserver so){
		studentobserver.add(so);
	}
	
	public void addCourseObserver(CourseObserver co){
		courseobserver.add(co);
	}
	
	public void addEnrollmentObserver(EnrollmentObserver eo){
		enrollmentobserver.add(eo);
	}
	
	public void saveState(){
		
	}
	
	public void addStudent(String name, int GradYear){
		Student temp = new Student(name, GradYear);
		temp.setId(thestudents.size()+1);
		thestudents.add(temp);
		notifyStudentObservers(temp);
	}
	
	public void addCourse(String name, String title){
		Course temp = new Course(name, title);
		thecourses.add(temp);
		notifyCourseObservers(temp);
	}
	
	public Course courseLookup(String code){
		for(Course c: thecourses){
			if(c.getCode() == code){
				return c;
			}
		}
		return null;
	}
	
	public void addStudentCourse(String c, int id){
		Student temp = thestudents.get(id-1);
		Course temp2 = courseLookup(c);
		temp.addCourse(temp2);
		notifyEnrollmentObservers(temp.getCourses());
	}
	
	public void dropStudentCourse(String c, int id){
		Student temp = thestudents.get(id-1);
		temp.removeCourse(c);
		int row  = temp.getRow();
		notifyEnrollmentObserversRemove(row);
	}
	
	public void showCourses(int id){
		Student temp = thestudents.get(id-1);
		List<Course> alist = temp.getCourses();
		notifyEnrollmentObservers(alist);
	}
	
	private void notifyStudentObservers(Student s){
		for(StudentObserver obs : studentobserver){
			obs.update(s);
		}
	}
	
	private void notifyCourseObservers(Course c){
		for(CourseObserver obs : courseobserver){
			obs.update(c);
		}
	}
	
	private void notifyEnrollmentObservers(List<Course> alist){
		for(EnrollmentObserver obs : enrollmentobserver){
			obs.update(alist);
		}
	}
	
	private void notifyEnrollmentObserversRemove(int row){
		for(EnrollmentObserver obs : enrollmentobserver){
			obs.updateRemove(row);
		}
	}
	
	// Each controller must call this when opening, but it does not function correctly
	public void openSave() throws IOException, ClassNotFoundException{
		InputStream is = new FileInputStream("output.dat");
		ObjectInputStream input = new ObjectInputStream(is);
		while(input.readObject() != null){
			thestudents.add((Student) input.readObject());
		}
		input.close();
	}
	
	public void saveExit() throws IOException, ClassNotFoundException{
		OutputStream os = new FileOutputStream("output.dat");
		ObjectOutputStream output = new ObjectOutputStream(os);
		for(Student s : thestudents){
			output.writeObject(s);
		}
		output.close();
		System.exit(0);
	}
}
