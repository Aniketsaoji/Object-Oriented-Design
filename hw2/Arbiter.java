package hw.hw2;

import java.util.List;

public class Arbiter {
	private static int currentTurn;
	private static int numberOfDice;
	private static int rollNumber;
	private static List<Player> playerlist;
	private static Pot thepot;

	public Arbiter(List<Player> players, Pot pot){
		this.currentTurn = 0;
		this.numberOfDice = 1;
		this.rollNumber = 1;
		this.playerlist = players;
		thepot = pot;
	}
	
	public void nextPlayer(){
		if(this.currentTurn+1 == playerlist.size()){
			this.currentTurn = 0;
			//System.out.println("player list reset, current turn = 0");
		}
		else{
			//System.out.println("about to change players");
			this.currentTurn ++;
			//System.out.println("next player, current turn = " + currentTurn);
		}
		this.numberOfDice = 1;
		this.rollNumber = 0;
	}
	
	public void nextRoll(){
		this.numberOfDice ++;
		this.rollNumber ++;
		thepot.addFromBank(rollNumber);
	}
	
	public static Player whoseTurn(){
		Player currentPlayer = playerlist.get(currentTurn);
		return currentPlayer;
	}
	
	public static void printTurnSummaryAced(Player currentPlayer) {
		String chipsummary = "Chip count: ";
		System.out.println(currentPlayer.getName() + " aced out after " +rollNumber + " rolls");
		for(Player p: playerlist){
			chipsummary += (p.getName() + ": " + p.getChips() + " ");
		}
		System.out.println(chipsummary);
		System.out.println("The pot contains "+thepot.getChips()+" chips");
		System.out.println();
	}
	
	public static void printTurnSummaryStop(Player currentPlayer) {
		String chipsummary = "Chip count: ";
		System.out.println(currentPlayer.getName() + " stopped after " +rollNumber + " rolls and won " + currentPlayer.getChips() + " chips");
		for(Player p: playerlist){
			chipsummary += (p.getName() + ": " + p.getChips() + " ");
		}
		System.out.println(chipsummary);
		System.out.println("The pot contains "+thepot.getChips()+" chips");
		System.out.println();
		
	}
	
	public boolean gameOver(){
		boolean anyoneOver30 = false;
		for(Player p: playerlist){
			if(p.getChips() >= 30){
				anyoneOver30 = true;
			}
		}
		return anyoneOver30;
	}

	
	// Getters and Setters
	public static int getCurrentTurn() {
		return currentTurn;
	}

	public static int getNumberOfDice() {
		return numberOfDice;
	}

	public static int getRollNumber() {
		return rollNumber;
	}


	

}
