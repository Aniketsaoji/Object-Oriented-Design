package hw.hw9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{
	private String name;
	private int id;
	private int GradYear;
	private int row;
	private List<Course> courses = new ArrayList<Course>();
	
	public Student(String name, int GradYear){
		this.name = name;
		this.GradYear = GradYear;
	}

	public String getName() {
		return name;
	}

	public int getGradYear() {
		return GradYear;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void addCourse(Course c){
		courses.add(c);
	}
	
	public void removeCourse(String code){
		int index = 0;
		for(int i = 0; i<courses.size(); i++){
			if(code == courses.get(i).getCode()){
				index = i;
			}
		}
		courses.remove(index);
		this.row = index;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	public int getRow() {
		return row;
	}
	

}
