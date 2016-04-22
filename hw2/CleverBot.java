package hw.hw2;

import javax.swing.JOptionPane;

public class CleverBot extends Player{
	private boolean done = false;
	public CleverBot(){
		setType("CleverBot");
		setChips(0);
	}

	public void beginTurn(Pot thepot, Arbiter arbiter) {
		done = false;
		while (!done) {
			thepot.addFromBank(arbiter.getRollNumber());
			int myroll = rollDice(arbiter);
			if (myroll == 1) {
				arbiter.printTurnSummaryAced(this);
				arbiter.nextPlayer();
				done = true;
			} else {
				int choice = 2;
				if (thepot.getChips() > 10) {
					choice = 1;
				}
				if (choice == 1) {
					super.chips += thepot.getChips();
					thepot.reset();
					arbiter.printTurnSummaryStop(this);
					arbiter.nextPlayer();
					done = true;
				} else if (choice == 2) {
					arbiter.nextRoll();
				}

			}
		}
	}
}
