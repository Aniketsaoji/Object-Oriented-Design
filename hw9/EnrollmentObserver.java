package hw.hw9;

import java.util.List;

public interface EnrollmentObserver {
	public void update(List<Course> alist);
	public void updateRemove(int row);
}
