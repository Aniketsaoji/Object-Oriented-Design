package hw.hw9;

import java.io.IOException;

public class FileController implements FileButtonHandler{
	private StudentCourseModel model;
	private FileView view;

	public FileController(StudentCourseModel model, FileView fv) {
		this.model = model;
		this.view = fv;
		view.addHandler(this);
	}
	
	public void buttonPressed() throws ClassNotFoundException, IOException {
		model.saveExit();
	}

}
