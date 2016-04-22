package hw.hw2;

import javax.swing.JOptionPane;

public class Human extends Player{
	private boolean done = false;
	
	public Human(){
		setType("Human");
		setChips(0);
	}

	public void beginTurn(Pot thepot, Arbiter arbiter) {
		done = false;
		while (!done){
			thepot.addFromBank(arbiter.getRollNumber());
			int myroll = rollDice(arbiter);
			if(myroll == 1){
				arbiter.printTurnSummaryAced(this);
	        	arbiter.nextPlayer();
	        	done = true;
			}
			else{
				try{
					String answer = JOptionPane.showInputDialog(getName()+ ": " + "You rolled: "+ myroll+". Type 1 to take the pot (" +thepot.getChips()+ "). Type 2 to keep going.");
			        String[] choices = answer.split(" ");
			        String choice = choices[0];
			        if(Integer.parseInt(choice) == 1){
			        	super.chips += thepot.getChips();
			        	thepot.reset();
			        	arbiter.printTurnSummaryStop(this);
			        	arbiter.nextPlayer();
			        	done = true;
			        }
			        else if(Integer.parseInt(choice) == 2){
			        	arbiter.nextRoll();
			        }
				}
				catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "You must input a valid choice (1 or 2). We chose 2 for you :p.");
				}
				
			}
		}
	}

}
