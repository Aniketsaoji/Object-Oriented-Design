package hw.hw2;

public class Pot {
	private static int chips;
	
	public Pot(){
		this.chips = 0;
	}
	
	public static void addFromBank(int turn){
		chips += (turn);
	}
	
	public void reset(){
		this.chips = 0;
	}

	public static int getChips() {
		return chips;
	}

}
