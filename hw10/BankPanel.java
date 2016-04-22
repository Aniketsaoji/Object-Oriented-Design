package hw.hw10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BankPanel extends JPanel{
	private JLabel l1 = new JLabel("UserName");
	private JTextField j1 = new JTextField(5);
	private Border select = new TitledBorder("Select Account");
	private JButton b1 =new JButton("New Account");
	private JButton b2 =new JButton("Get Account");
	
	private Border access = new TitledBorder("Access Account");
	private JLabel l2 = new JLabel("Amount");
	private JTextField j2 = new JTextField(5);
	private JButton b3 =new JButton("Deposit");
	private JButton b4 =new JButton("Withdraw");
	private JButton b5 =new JButton("Show Balance");
	private String text;
	private JTextField j3 = new JTextField(text, 5);
	
	public BankPanel(){
		//super(new GridLayout(1,0));
		JPanel p1 = new JPanel();
		add(p1);
		p1.add(l1);
		p1.add(j1);
		p1.setBorder(select);
		p1.add(b1);
		p1.add(b2);
		
		JPanel p2 = new JPanel();
		add(p2);
		p2.setBorder(access);
		p2.add(l2);
		p2.add(j2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(j3);
	}

	public void addHandler(BankButtonHandler bh) {
		b1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
                bh.buttonNewAccount(j1.getText());
             }
		});
		b2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
               bh.buttonGetAccount(j1.getText());
            }
		});
		b3.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
              bh.buttonDeposit(Integer.parseInt(j2.getText()));
           }
		});
		b4.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
             bh.buttonWithdraw(Integer.parseInt(j2.getText()));
          }
		});
		b5.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {
            bh.buttonShowBalance();
         }
		});
	}

	public void forceupdate() {
		
	}

	public void showBalance(double balance) {
		j2.setText(Double.toString(balance));
		
	}
	

}
