package hw.hw9;

import javax.swing.JFrame;

public class FileView extends JFrame{
	private FilePanel fp;
	
	public FileView(){
		setTitle("Save");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 200);
		setSize(150,60);
		fp = new FilePanel();
		setContentPane(fp);
	    setVisible(true);
	}
	
	public void addHandler(FileButtonHandler bh) {
	      fp.addHandler(bh);
	}

}
