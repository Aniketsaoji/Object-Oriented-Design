package hw.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public abstract class Player {
	private String name;
	protected int chips;
	private String type;

	public int rollDice(Arbiter arbiter){
		int result = 0;
		int roll = 0;
		List<Integer> printroll = new ArrayList<Integer>();
		boolean acedOut = false;
		for(int x = 0; x < arbiter.getNumberOfDice(); x++){
			Random rand = new Random();
			roll = rand.nextInt((4+1) - 1) + 1;
			printroll.add(roll);
			result += roll;
			if(roll == 1){
				acedOut = true;
			}
		}
		System.out.println(this.name + " rolled: " + printroll.toString());
		if(acedOut){
			if(getType() == "Human"){
				JOptionPane.showMessageDialog(null, getName() + " Aced out!");
			}
			else{
				System.out.println(getName() + " Aced out!");
			}
			return 1;
		}
		else{
			return result;
		}
		
	}
	
	public abstract void beginTurn(Pot thepot, Arbiter arbiter);
	
	
	
	// Getters and Setters
	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
