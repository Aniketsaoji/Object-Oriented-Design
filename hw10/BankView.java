package hw.hw10;

import javax.swing.JFrame;

public class BankView extends JFrame {
	
	private BankPanel bp;
	private String username = "";
	
	public BankView(){
		setTitle("Enrollment" + username);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(300, 500);
		setSize(600, 200);
		bp = new BankPanel();
		getContentPane().add(bp);
	    setVisible(true);
	}
	
	public void addHandler(BankButtonHandler bh) {
		bp.addHandler(bh);
	}

	public void forceupdate() {
		bp.forceupdate();
	}

	public void showBalance(double balance) {
		bp.showBalance(balance);
	}

	

}
