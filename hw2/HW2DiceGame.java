package hw.hw2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HW2DiceGame {
	private static List<Player> playerlist = new ArrayList<Player>();
	private static boolean setupComplete = false;
	private static Pot thepot = new Pot();
	private static Arbiter arbiter = new Arbiter(playerlist, thepot);
	private static Player currentPlayer;
	private static Player winner;
	
	
	public static void main(String[] args) {
		while(!setupComplete){
			setup();
		}
		System.out.println("The Players:");
		for(Player p: playerlist){
			System.out.println(p.getName() + " ---- " + p.getType());
		}
		
		while(arbiter.gameOver() != true){
			currentPlayer = Arbiter.whoseTurn();
			System.out.println("It is now "+currentPlayer.getName()+"'s turn");
			System.out.println("");
			currentPlayer.beginTurn(thepot, arbiter);
			System.out.println("");
		}
		for(Player p : playerlist){
			if(p.getChips() >= 30){
				winner = p;
			}
		}
		JOptionPane.showMessageDialog(null, "Game over. " + winner.getName() + " won!");
		System.out.println("Game over. " + winner.getName() + " won!");
	}
	
	public static void setup(){
		try{
			String answer = JOptionPane.showInputDialog("Enter player name. Hit cancel if no more players");
	        String[] answers = answer.split(" ");
	        String name = answers[0];
	        String type = JOptionPane.showInputDialog("Enter type of player (human = 0, AgressiveBot = 1, CleverBot = 2");
	        String[] types = type.split(" ");
	        String thetype = types[0];
	        if(Integer.parseInt(thetype) == 0){
	        	Human temp = new Human();
	        	temp.setName(name);
	        	temp.setType("Human");
	        	playerlist.add(temp);
	        }
	        else if(Integer.parseInt(thetype) == 1){
	        	AggressiveBot temp = new AggressiveBot();
	        	temp.setName(name);
	        	temp.setType("AggressiveBot");
	        	playerlist.add(temp);
	        }
	        else if(Integer.parseInt(thetype) == 2){
	        	CleverBot temp = new CleverBot();
	        	temp.setName(name);
	        	temp.setType("CleverBot");
	        	playerlist.add(temp);
	        }
	        else{
	        	JOptionPane.showMessageDialog(null, "You must input a valid player type (0, 1, or 2). Add the player again.");
	        	
	        }
		}
		catch(NullPointerException npe){
			if(playerlist.size() < 2){
				JOptionPane.showMessageDialog(null, "You must have more than 1 player. Add another player.");
			}
			else{
				setupComplete = true;
			}
		}
		catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "You must input a valid player type (0, 1, or 2). Add the player again.");
		}
        
        
	}
	
}
